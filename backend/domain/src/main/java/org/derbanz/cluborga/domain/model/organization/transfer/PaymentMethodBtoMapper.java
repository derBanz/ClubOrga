package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.derbanz.cluborga.domain.base.transfer.BaseBtoMapper;
import org.derbanz.cluborga.domain.model.organization.Membership;
import org.derbanz.cluborga.domain.model.organization.PaymentMethod;

import java.util.Objects;

public class PaymentMethodBtoMapper extends BaseBtoMapper {

  @Inject
  EntityManager entityManager;

  private boolean mapPropertiesToBo(PaymentMethodBto bto, PaymentMethod bo) {
    boolean result =
      !bo.getValidFrom().equals(bto.getValidFrom()) ||
        bo.getValidTo().equals(bto.getValidTo()) ||
        bo.getIban().equals(bto.getIban()) ||
        bo.getBic().equals(bto.getBic()) ||
        bo.getBank().equals(bto.getBank()) ||
        bo.getSepaMandate().equals(bto.getSepaMandate());

    if (!Objects.isNull(bto.getValidFrom())) {
      bo.setValidFrom(bto.getValidFrom());
    }
    if (!Objects.isNull(bto.getValidTo())) {
      bo.setValidTo(bto.getValidTo());
    }
    if (!Objects.isNull(bto.getIban())) {
      bo.setIban(bto.getIban());
    }
    if (!Objects.isNull(bto.getBic())) {
      bo.setBic(bto.getBic());
    }
    if (!Objects.isNull(bto.getBank())) {
      bo.setBank(bto.getBank());
    }
    if (!Objects.isNull(bto.getSepaMandate())) {
      bo.setSepaMandate(bto.getSepaMandate());
    }

    return result;
  }

  private void mapPropertiesToBto(PaymentMethod bo, PaymentMethodBto bto) {
    mapBasePropertiesToBto(bo, bto);
    bto.setValidFrom(bo.getValidFrom());
    bto.setValidTo(bo.getValidTo());
    bto.setIban(bo.getIban());
    bto.setBic(bo.getBic());
    bto.setBank(bo.getBank());
    bto.setSepaMandate(bo.getSepaMandate());

    if (bo.getMembership() != null) {
      bto.setMembershipId(bo.getMembership().getId());
    }
  }

  public PaymentMethodBto toCoreBto(PaymentMethod bo) {
    PaymentMethodBto bto = new PaymentMethodBto();
    mapPropertiesToBto(bo, bto);
    return bto;
  }

  public PaymentMethodBto toBto(PaymentMethod bo) {
    PaymentMethodBto bto = new PaymentMethodBto();
    mapToBto(bo, bto);
    return bto;
  }

  public void mapToBto(PaymentMethod bo, PaymentMethodBto bto) {
    mapPropertiesToBto(bo, bto);
  }

  public boolean mapToBo(PaymentMethod bo, PaymentMethodBto bto) {
    boolean result = mapPropertiesToBo(bto, bo);
    if (bto.getMembershipId() != null) {
      bo.setMembership(entityManager.getReference(Membership.class, bto.getMembershipId()));
    } else {
      bo.setMembership(null);
    }
    return result;
  }
}
