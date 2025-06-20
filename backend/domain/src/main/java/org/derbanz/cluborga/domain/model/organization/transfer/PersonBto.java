package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.validation.Valid;

import java.util.List;

public class PersonBto extends PersonCoreBto {

  @Valid
  private List<MembershipBto> memberships;
  @Valid
  private List<ContactBto> contacts;

  public List<MembershipBto> getMemberships() {
    return memberships;
  }

  public void setMemberships(List<MembershipBto> memberships) {
    this.memberships = memberships;
  }

  public List<ContactBto> getContacts() {
    return contacts;
  }

  public void setContacts(List<ContactBto> contacts) {
    this.contacts = contacts;
  }

  @Override
  public boolean equals(Object object) {
    if (object == null) {
      return false;
    }
    if (object.getClass() != this.getClass()) {
      return false;
    }
    final PersonBto bto = (PersonBto) object;
    if (bto.getId() == null) {
      return object == this;
    } else {
      return this.getId().equals(bto.getId());
    }
  }
}
