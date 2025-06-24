package org.derbanz.cluborga.logic.organization.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import org.derbanz.cluborga.domain.model.organization.Membership;
import org.derbanz.cluborga.domain.model.organization.Person;
import org.derbanz.cluborga.domain.model.organization.transfer.PersonBto;
import org.derbanz.cluborga.domain.model.organization.transfer.PersonBtoMapper;
import org.derbanz.cluborga.logic.organization.BasePersonLogic;
import org.derbanz.cluborga.logic.organization.ContactLogic;
import org.derbanz.cluborga.logic.organization.MembershipLogic;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApplicationScoped
public class BasePersonLogicImpl implements BasePersonLogic {

    @Inject
    PersonBtoMapper btoMapper;
    @Inject
    Validator validator;
    @Inject
    EntityManager entityManager;
    @Inject
    Logger log;

    @Inject
    MembershipLogic membershipLogic;
    @Inject
    ContactLogic contactLogic;

    @Override
    public PersonBto instantiate() {
        PersonBto bto = new PersonBto();
        // insert default parameters
        return bto;
    }

    @Override
    public PersonBto get(String id) {
        Person bo = getBo(id);
        return btoMapper.toBto(bo);
    }

    @Override
    public List<PersonBto> getList(List<String> ids) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = cb.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);
        query.where(root.get(Person.ID).in(ids));
        TypedQuery<Person> result = entityManager.createQuery(query);
        return result.getResultStream().map(btoMapper::toBto).toList();
    }

    @Override
    public List<PersonBto> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = cb.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);
        TypedQuery<Person> result = entityManager.createQuery(query);
        return result.getResultStream().map(btoMapper::toBto).toList();
    }

    @Override
    public Set<ConstraintViolation<PersonBto>> validate(PersonBto bto) {
        return validator.validate(bto);
    }

    @Override
    @Transactional
    public boolean save(PersonBto bto) {
        Set<? extends ConstraintViolation<?>> validationResult = validate(bto);
        if (!validationResult.isEmpty()) {
            String message = validationResult.stream()
                    .map(val -> String.valueOf(val.getPropertyPath()).concat(": ").concat(val.getMessage())).collect(Collectors.joining("\n"));
            throw new ValidationException(message);
        }
        if (bto.getId() == null || bto.getId().isEmpty()) {
            Person bo = new Person();
            btoMapper.mapToBo(bo, bto);
            entityManager.persist(bo);
            bto.setId(bo.getId());
            bto.setCreation(bo.getCreation());
            bto.setCreationUser(bo.getCreationUser());
            bto.setLastUpdate(bo.getLastUpdate());
            bto.setLastUpdateUser(bo.getLastUpdateUser());
            handleConnectedObjects(bto, bo);
            log.info(String.format("%s created", bo));
            return true;
        } else {
            Person bo = getBo(bto.getId());
            boolean changes = btoMapper.mapToBo(bo, bto);
            handleConnectedObjects(bto, bo);
            if (changes) {
                entityManager.merge(bo);
                bto.setLastUpdate(bo.getLastUpdate());
                bto.setLastUpdateUser(bo.getLastUpdateUser());
                log.info(String.format("%s updated.", bo));
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean delete(PersonBto bto) {
        return delete(bto.getId());
    }

    @Override
    @Transactional
    public boolean delete(String id) {
        Person bo = getBo(id);
        if (bo != null) {
            entityManager.remove(bo);
            log.info(String.format("%s deleted.", bo));
            return true;
        } else {
            log.warn(String.format("Person not found for deletion: %s", id));
            return false;
        }
    }

    protected Person getBo(String id) {
        return entityManager.find(Person.class, id);
    }

    protected void handleConnectedObjects(PersonBto bto, Person bo) {
        this.handleMemberships(bto, bo);
        this.handleContacts(bto, bo);
    }

    private void handleMemberships(PersonBto bto, Person bo) {
        // Existing Bos without Bto are outdated and should be deleted
        bo.getMemberships().forEach(membershipBo -> {
            if (bto.getMemberships().stream().noneMatch(membershipBto -> membershipBo.getId().equals(membershipBto.getId()))) {
                membershipLogic.delete(membershipBo.getId());
            }
        });
        Map<String, Membership> membershipBoMap = bo.getMemberships().stream().collect(Collectors.toMap(Membership::getId, Function.identity()));
        bto.getMemberships().forEach(membershipBto -> {
            // update personId for memberships
            if (membershipBto.getPersonId() == null || membershipBto.getPersonId().isEmpty()) {
                membershipBto.setPersonId(bo.getId());
            }
            membershipLogic.save(membershipBto);
        });
    }

    private void handleContacts(PersonBto bto, Person bo) {
        //todo
    }
}
