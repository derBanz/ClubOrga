package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.derbanz.cluborga.domain.base.transfer.BaseBtoMapper;
import org.derbanz.cluborga.domain.enums.MembershipStatus;
import org.derbanz.cluborga.domain.model.organization.Person;

import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class PersonBtoMapper extends BaseBtoMapper {

  @Inject
  MembershipBtoMapper membershipBtoMapper;
  @Inject
  ContactBtoMapper contactBtoMapper;

  private boolean mapPropertiesToBo(PersonCoreBto bto, Person bo) {
    boolean result =
      !bo.getName().equals(bto.getName()) ||
        !bo.getFirstName().equals(bto.getFirstName()) ||
        !bo.getDateOfBirth().equals(bto.getDateOfBirth()) ||
        !bo.getGender().equals(bto.getGender());

    if (!Objects.isNull(bto.getName())) {
      bo.setName(bto.getName());
    }
    if (!Objects.isNull(bto.getFirstName())) {
      bo.setFirstName(bto.getFirstName());
    }
    if (!Objects.isNull(bto.getDateOfBirth())) {
      bo.setDateOfBirth(bto.getDateOfBirth());
    }
    if (!Objects.isNull(bto.getGender())) {
      bo.setGender(bto.getGender());
    }

    return result;
  }

  private void mapPropertiesToBto(Person bo, PersonCoreBto bto) {
    mapBasePropertiesToBto(bo, bto);
    bto.setName(bo.getName());
    bto.setFirstName(bo.getFirstName());
    bto.setDateOfBirth(bo.getDateOfBirth());
    bto.setGender(bo.getGender());

    Boolean isMember = bo.getMemberships().stream().anyMatch(membership -> membership.getStopDate() == null
      && List.of(MembershipStatus.ACTIVE_MEMBER, MembershipStatus.INACTIVE_MEMBER).contains(membership.getStatus()));
    bto.setIsMember(isMember);
  }

  public PersonCoreBto toCoreBto(Person bo) {
    PersonCoreBto bto = new PersonCoreBto();
    mapPropertiesToBto(bo, bto);
    return bto;
  }

  public PersonBto toBto(Person bo) {
    PersonBto bto = new PersonBto();
    mapToBto(bo, bto);
    return bto;
  }

  public void mapToBto(Person bo, PersonBto bto) {
    mapPropertiesToBto(bo, bto);
    List<MembershipBto> memberships = bo.getMemberships().stream().map(membershipBtoMapper::toBto).toList();
    bto.setMemberships(memberships);
    List<ContactBto> contacts = bo.getContacts().stream().map(contactBtoMapper::toBto).toList();
    bto.setContacts(contacts);
  }

  public boolean mapToBo(Person bo, PersonBto bto) {
    return mapPropertiesToBo(bto, bo);
  }
}
