package org.derbanz.cluborga.commonservice.organization.dto;

import org.derbanz.cluborga.domain.enums.Gender;
import org.derbanz.cluborga.domain.model.organization.transfer.ContactBto;
import org.derbanz.cluborga.domain.model.organization.transfer.MembershipBto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonDto {
  private String id;
  private String creationUser;
  private Timestamp creation;
  private String lastUpdateUser;
  private Timestamp lastUpdate;
  private String name;
  private String firstName;
  private Date dateOfBirth;
  private Gender gender;
  private Boolean isMember;

  private List<MembershipBto> memberships;
  private List<ContactBto> contacts;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCreationUser() {
    return creationUser;
  }

  public void setCreationUser(String creationUser) {
    this.creationUser = creationUser;
  }

  public Timestamp getCreation() {
    return creation;
  }

  public void setCreation(Timestamp creation) {
    this.creation = creation;
  }

  public String getLastUpdateUser() {
    return lastUpdateUser;
  }

  public void setLastUpdateUser(String lastUpdateUser) {
    this.lastUpdateUser = lastUpdateUser;
  }

  public Timestamp getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Timestamp lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Boolean isMember() {
    return isMember;
  }

  public void setIsMember(Boolean member) {
    isMember = member;
  }

  public List<MembershipBto> getMemberships() {
    if (memberships == null) {
      setMemberships(new ArrayList<>());
    }
    return memberships;
  }

  public void setMemberships(List<MembershipBto> memberships) {
    this.memberships = memberships;
  }

  public List<ContactBto> getContacts() {
    if (contacts == null) {
      setContacts(new ArrayList<>());
    }
    return contacts;
  }

  public void setContacts(List<ContactBto> contacts) {
    this.contacts = contacts;
  }
}
