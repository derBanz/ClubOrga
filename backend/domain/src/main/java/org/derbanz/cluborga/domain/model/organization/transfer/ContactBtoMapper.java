package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.derbanz.cluborga.domain.base.transfer.BaseBtoMapper;
import org.derbanz.cluborga.domain.enums.ContactType;
import org.derbanz.cluborga.domain.model.organization.Contact;
import org.derbanz.cluborga.domain.model.organization.Person;

import java.util.Objects;

@ApplicationScoped
public class ContactBtoMapper extends BaseBtoMapper {

  @Inject
  EntityManager entityManager;

  protected boolean mapPropertiesToBo(ContactCoreBto bto, Contact bo) {
    boolean result = !bo.getValidFrom().equals(bto.getValidFrom()) ||
                       !bo.getValidTo().equals(bto.getValidTo()) ||
                       !bo.getType().equals(bto.getType()) ||
                       !bo.getStreet().equals(bto.getStreet()) ||
                       !bo.getNumber().equals(bto.getNumber()) ||
                       !bo.getNumberSuffix().equals(bto.getNumberSuffix()) ||
                       !bo.getPostbox().equals(bto.getPostbox()) ||
                       !bo.getZip().equals(bto.getZip()) ||
                       !bo.getCity().equals(bto.getCity()) ||
                       !bo.getCountry().equals(bto.getCountry()) ||
                       !bo.getEmail().equals(bto.getEmail()) ||
                       !bo.getCountryCode().equals(bto.getCountryCode()) ||
                       !bo.getPhoneNumber().equals(bto.getPhoneNumber());

    if (!Objects.isNull(bto.getValidFrom())) {
      bo.setValidFrom(bto.getValidFrom());
    }
    if (!Objects.isNull(bto.getValidTo())) {
      bo.setValidTo(bto.getValidTo());
    }
    if (!Objects.isNull(bto.getType())) {
      bo.setType(bto.getType());
    }
    if (!Objects.isNull(bto.getStreet())) {
      bo.setStreet(bto.getStreet());
    }
    if (!Objects.isNull(bto.getNumber())) {
      bo.setNumber(bto.getNumber());
    }
    if (!Objects.isNull(bto.getNumberSuffix())) {
      bo.setNumberSuffix(bto.getNumberSuffix());
    }
    if (!Objects.isNull(bto.getPostbox())) {
      bo.setPostbox(bto.getPostbox());
    }
    if (!Objects.isNull(bto.getZip())) {
      bo.setZip(bto.getZip());
    }
    if (!Objects.isNull(bto.getCity())) {
      bo.setCity(bto.getCity());
    }
    if (!Objects.isNull(bto.getCountry())) {
      bo.setCountry(bto.getCountry());
    }
    if (!Objects.isNull(bto.getEmail())) {
      bo.setEmail(bto.getEmail());
    }
    if (!Objects.isNull(bto.getCountryCode())) {
      bo.setCountryCode(bto.getCountryCode());
    }
    if (!Objects.isNull(bto.getPhoneNumber())) {
      bo.setPhoneNumber(bto.getPhoneNumber());
    }

    return result;
  }

  protected void mapPropertiesToBto(Contact bo, ContactCoreBto bto) {
    mapBasePropertiesToBto(bo, bto);
    bto.setValidFrom(bo.getValidFrom());
    bto.setValidTo(bo.getValidTo());

    bto.setStreet(bo.getStreet());
    bto.setNumber(bo.getNumber());
    bto.setNumberSuffix(bo.getNumberSuffix());
    bto.setPostbox(bo.getPostbox());
    bto.setZip(bo.getZip());
    bto.setCity(bo.getCity());
    bto.setCountry(bo.getCountry());

    bto.setIsPostbox(ContactType.ADDRESS.equals(bo.getType()) && bo.getPostbox() != null);

    bto.setEmail(bo.getEmail());

    bto.setCountryCode(bo.getCountryCode());
    bto.setPhoneNumber(bo.getPhoneNumber());

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
      bo.setPerson(entityManager.find(Person.class, bto.getPersonId()));
    } else {
      bo.setPerson(null);
    }
    return result;
  }
}
