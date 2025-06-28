package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.derbanz.cluborga.domain.base.transfer.BaseBto;
import org.derbanz.cluborga.domain.enums.Gender;

import java.util.Date;
import java.util.Objects;

public class PersonCoreBto extends BaseBto {

  public static final String NAME = "name";
  public static final String FIRST_NAME = "firstName";
  public static final String DATE_OF_BIRTH = "dateOfBirth";
  public static final String GENDER = "gender";
  public static final String IS_MEMBER = "isMember";

  public static final String MEMBERSHIPS = "memberships";
  public static final String CONTACTS = "contacts";

  @NotEmpty
  private String name;

  private String firstName;

  private Date dateOfBirth;

  @NotNull
  private Gender gender;

  private Boolean isMember;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    Objects.requireNonNull(name, "Cannot set name to null");
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
    Objects.requireNonNull(gender, "Cannot set gender to null");
    this.gender = gender;
  }

  public Boolean isMember() {
    return isMember;
  }

  public void setIsMember(Boolean isMember) {
    this.isMember = isMember;
  }
}
