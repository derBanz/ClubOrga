package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.derbanz.cluborga.domain.base.transfer.BaseBtoMapper;
import org.derbanz.cluborga.domain.model.organization.Application;
import org.derbanz.cluborga.domain.model.organization.Membership;
import org.derbanz.cluborga.domain.model.organization.Person;

import java.util.Objects;

@ApplicationScoped
public class MembershipBtoMapper extends BaseBtoMapper {

  @Inject
  EntityManager entityManager;

  private boolean mapPropertiesToBo(MembershipCoreBto bto, Membership bo) {
    boolean result =
      !bo.getStartDate().equals(bto.getStartDate()) ||
        bo.getStopDate().equals(bto.getStopDate()) ||
        bo.getDiscount().equals(bto.getDiscount()) ||
        bo.getStatus().equals(bto.getStatus());

    if (!Objects.isNull(bto.getStartDate())) {
      bo.setStartDate(bto.getStartDate());
    }
    if (!Objects.isNull(bto.getStopDate())) {
      bo.setStopDate(bto.getStopDate());
    }
    if (!Objects.isNull(bto.getDiscount())) {
      bo.setDiscount(bto.getDiscount());
    }
    if (!Objects.isNull(bto.getStatus())) {
      bo.setStatus(bto.getStatus());
    }

    return result;
  }

  private void mapPropertiesToBto(Membership bo, MembershipCoreBto bto) {
    mapBasePropertiesToBto(bo, bto);
    bto.setStartDate(bo.getStartDate());
    bto.setStopDate(bo.getStopDate());
    bto.setDiscount(bo.getDiscount());
    bto.setStatus(bo.getStatus());

    if (bo.getPerson() != null) {
      bto.setPersonId(bo.getPerson().getId());
    }
    if (bo.getApplication() != null) {
      bto.setApplicationId(bo.getApplication().getId());
    }
  }

  public MembershipCoreBto toCoreBto(Membership bo) {
    MembershipCoreBto bto = new MembershipCoreBto();
    mapPropertiesToBto(bo, bto);
    return bto;
  }

  public MembershipBto toBto(Membership bo) {
    MembershipBto bto = new MembershipBto();
    mapToBto(bo, bto);
    return bto;
  }

  public void mapToBto(Membership bo, MembershipBto bto) {
    mapPropertiesToBto(bo, bto);
  }

  public boolean mapToBo(Membership bo, MembershipBto bto) {
    boolean result = mapPropertiesToBo(bto, bo);
    if (bto.getPersonId() != null) {
      bo.setPerson(entityManager.find(Person.class, bto.getPersonId()));
    } else {
      bo.setPerson(null);
    }
    if (bto.getApplicationId() != null) {
      bo.setApplication(entityManager.find(Application.class, bto.getApplicationId()));
    } else {
      bo.setApplication(null);
    }
    return result;
  }
}
