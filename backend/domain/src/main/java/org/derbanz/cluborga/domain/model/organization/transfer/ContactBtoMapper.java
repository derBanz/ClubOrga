package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.derbanz.cluborga.domain.base.transfer.BaseBtoMapper;
import org.derbanz.cluborga.domain.model.organization.Contact;
import org.derbanz.cluborga.domain.model.organization.Person;

import java.util.Objects;

@ApplicationScoped
public class ContactBtoMapper extends BaseBtoMapper {

  @Inject
  EntityManager entityManager;

  protected boolean mapPropertiesToBo(ContactCoreBto bto, Contact bo) {
    boolean result =
      !bo.getValidFrom().equals(bto.getValidFrom()) ||
        !bo.getValidTo().equals(bto.getValidTo());

    if (!Objects.isNull(bto.getValidFrom())) {
      bo.setValidFrom(bto.getValidFrom());
    }
    if (!Objects.isNull(bto.getValidTo())) {
      bo.setValidTo(bto.getValidTo());
    }

    return result;
  }

  protected void mapPropertiesToBto(Contact bo, ContactCoreBto bto) {
    mapBasePropertiesToBto(bo, bto);
    bto.setValidFrom(bo.getValidFrom());
    bto.setValidTo(bo.getValidTo());

    if (bo.getPerson() != null) {
      bto.setPersonId(bo.getPerson().getId());
    }
  }

  public ContactCoreBto toCoreBto(Contact bo) {
    ContactCoreBto bto = new ContactCoreBto();
    mapPropertiesToBto(bo, bto);
    return bto;
  }

  public ContactBto toBto(Contact bo) {
    ContactBto bto = new ContactBto();
    mapToBto(bo, bto);
    return bto;
  }

  public void mapToBto(Contact bo, ContactBto bto) {
    mapPropertiesToBto(bo, bto);
  }

  public boolean mapToBo(Contact bo, ContactBto bto) {
    boolean result = mapPropertiesToBo(bto, bo);

    if (bto.getPersonId() != null) {
      bo.setPerson(entityManager.getReference(Person.class, bto.getPersonId()));
    } else {
      bo.setPerson(null);
    }
    return result;
  }
}
