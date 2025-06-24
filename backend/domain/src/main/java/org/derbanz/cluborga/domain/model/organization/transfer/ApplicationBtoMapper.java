package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.derbanz.cluborga.domain.base.transfer.BaseBtoMapper;
import org.derbanz.cluborga.domain.model.organization.Application;
import org.derbanz.cluborga.domain.model.organization.Membership;

import java.util.Objects;

public class ApplicationBtoMapper extends BaseBtoMapper {

  @Inject
  EntityManager entityManager;

  private boolean mapPropertiesToBo(ApplicationBto bto, Application bo) {
    boolean result =
      !bo.getApplicationDate().equals(bto.getApplicationDate()) ||
        bo.getDateOfReply().equals(bto.getDateOfReply()) ||
        bo.getStatus().equals(bto.getStatus());

    if (!Objects.isNull(bto.getApplicationDate())) {
      bo.setApplicationDate(bto.getApplicationDate());
    }
    if (!Objects.isNull(bto.getDateOfReply())) {
      bo.setDateOfReply(bto.getDateOfReply());
    }
    if (!Objects.isNull(bto.getStatus())) {
      bo.setStatus(bto.getStatus());
    }

    return result;
  }

  private void mapPropertiesToBto(Application bo, ApplicationBto bto) {
    mapBasePropertiesToBto(bo, bto);
    bto.setApplicationDate(bo.getApplicationDate());
    bto.setDateOfReply(bo.getDateOfReply());
    bto.setStatus(bo.getStatus());

    if (bo.getMembership() != null) {
      bto.setMembershipId(bo.getMembership().getId());
    }
  }

  public ApplicationBto toCoreBto(Application bo) {
    ApplicationBto bto = new ApplicationBto();
    mapPropertiesToBto(bo, bto);
    return bto;
  }

  public ApplicationBto toBto(Application bo) {
    ApplicationBto bto = new ApplicationBto();
    mapToBto(bo, bto);
    return bto;
  }

  public void mapToBto(Application bo, ApplicationBto bto) {
    mapPropertiesToBto(bo, bto);
  }

  public boolean mapToBo(Application bo, ApplicationBto bto) {
    boolean result = mapPropertiesToBo(bto, bo);
    if (bto.getMembershipId() != null) {
      bo.setMembership(entityManager.find(Membership.class, bto.getMembershipId()));
    } else {
      bo.setMembership(null);
    }
    return result;
  }
}
