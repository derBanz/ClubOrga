package org.derbanz.cluborga.logic.organization.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import org.derbanz.cluborga.domain.model.organization.Contact;
import org.derbanz.cluborga.domain.model.organization.transfer.ContactBto;
import org.derbanz.cluborga.domain.model.organization.transfer.ContactBtoMapper;
import org.derbanz.cluborga.logic.organization.BaseContactLogic;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class BaseContactLogicImpl implements BaseContactLogic {

    @Inject
    ContactBtoMapper btoMapper;
    @Inject
    Validator validator;
    @Inject
    EntityManager entityManager;
    @Inject
    Logger log;

    @Override
    public ContactBto instantiate() {
        ContactBto bto = new ContactBto();
        // insert default parameters
        return bto;
    }

    @Override
    public ContactBto get(String id) {
        Contact bo = getBo(id);
        return btoMapper.toBto(bo);
    }

    @Override
    public List<ContactBto> getList(List<String> ids) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contact> query = cb.createQuery(Contact.class);
        Root<Contact> root = query.from(Contact.class);
        query.where(root.get(Contact.ID).in(ids));
        TypedQuery<Contact> result = entityManager.createQuery(query);
        return result.getResultStream().map(btoMapper::toBto).toList();
    }

    @Override
    public List<ContactBto> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contact> query = cb.createQuery(Contact.class);
        Root<Contact> root = query.from(Contact.class);
        TypedQuery<Contact> result = entityManager.createQuery(query);
        return result.getResultStream().map(btoMapper::toBto).toList();
    }

    @Override
    public Set<ConstraintViolation<ContactBto>> validate(ContactBto bto) {
        return validator.validate(bto);
    }

    @Override
    public boolean save(ContactBto bto) {
        Set<? extends ConstraintViolation<?>> validationResult = validate(bto);
        if (!validationResult.isEmpty()) {
            String message = validationResult.stream()
                    .map(val -> String.valueOf(val.getPropertyPath()).concat(": ").concat(val.getMessage())).collect(Collectors.joining("\n"));
            throw new ValidationException(message);
        }
        if (bto.getId() == null || bto.getId().isEmpty()) {
            Contact bo = new Contact();
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
            Contact bo = getBo(bto.getId());
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
    public boolean delete(ContactBto bto) {
        return delete(bto.getId());
    }

    @Override
    public boolean delete(String id) {
        Contact bo = getBo(id);
        if (bo != null) {
            bo.getPerson().removeContact(bo);
            entityManager.remove(bo);
            log.info(String.format("%s deleted.", bo));
            return true;
        } else {
            log.warn(String.format("Contact not found for deletion: %s", id));
            return false;
        }
    }

    protected Contact getBo(String id) {
        return entityManager.find(Contact.class, id);
    }

    protected void handleConnectedObjects(ContactBto bto, Contact bo) {
        // Contact does not control any connected object
    }
}
