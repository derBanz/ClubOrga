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
import org.derbanz.cluborga.domain.model.organization.Membership;
import org.derbanz.cluborga.domain.model.organization.transfer.MembershipBto;
import org.derbanz.cluborga.domain.model.organization.transfer.MembershipBtoMapper;
import org.derbanz.cluborga.logic.organization.BaseMembershipLogic;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class BaseMembershipLogicImpl implements BaseMembershipLogic {

  @Inject
  MembershipBtoMapper btoMapper;
  @Inject
  Validator validator;
  @Inject
  EntityManager entityManager;
  @Inject
  Logger log;

  @Override
  public MembershipBto instantiate() {
    MembershipBto bto = new MembershipBto();
    // insert default parameters
    return bto;
  }

  @Override
  public MembershipBto get(String id) {
    Membership bo = getBo(id);
    return btoMapper.toBto(bo);
  }

  @Override
  public List<MembershipBto> getList(List<String> ids) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Membership> query = cb.createQuery(Membership.class);
    Root<Membership> root = query.from(Membership.class);
    query.where(root.get(Membership.ID).in(ids));
    TypedQuery<Membership> result = entityManager.createQuery(query);
    return result.getResultStream().map(btoMapper::toBto).toList();
  }

  @Override
  public List<MembershipBto> getAll() {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Membership> query = cb.createQuery(Membership.class);
    Root<Membership> root = query.from(Membership.class);
    TypedQuery<Membership> result = entityManager.createQuery(query);
    return result.getResultStream().map(btoMapper::toBto).toList();
  }

  @Override
  public Set<ConstraintViolation<MembershipBto>> validate(MembershipBto bto) {
    return validator.validate(bto);
  }

  @Override
  public boolean save(MembershipBto bto) {
    Set<? extends ConstraintViolation<?>> validationResult = validate(bto);
    if (!validationResult.isEmpty()) {
      String message = validationResult.stream()
                         .map(val -> String.valueOf(val.getPropertyPath()).concat(": ").concat(val.getMessage())).collect(Collectors.joining("\n"));
      throw new ValidationException(message);
    }
    if (bto.getId() == null || bto.getId().isEmpty()) {
      Membership bo = new Membership();
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
      Membership bo = getBo(bto.getId());
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
  public void delete(MembershipBto bto) {
    delete(bto.getId());
  }

  @Override
  public void delete(String id) {
    Membership bo = getBo(id);
    if (bo != null) {
      bo.getPerson().removeMembership(bo);
      entityManager.remove(bo);
      log.info(String.format("%s deleted.", bo));
    } else {
      log.warn(String.format("Membership not found for deletion: %s", id));
    }
  }

  protected Membership getBo(String id) {
    return entityManager.find(Membership.class, id);
  }

  protected void handleConnectedObjects(MembershipBto bto, Membership bo) {
    // Membership does not control any connected object
  }
}
