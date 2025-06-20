package org.derbanz.cluborga.domain.model.organization;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.derbanz.cluborga.domain.base.AbstractBusinessObject;
import org.derbanz.cluborga.domain.base.Caption;

import java.util.Date;

public class Contact extends AbstractBusinessObject {

  public static final String VALID_FROM = "validFrom";
  public static final String VALID_TO = "validTo";

  public static final String PERSON = "person";

  @Basic
  @NotEmpty(
    message = "" //todo
  )
  @Caption("") //todo
  @Access(AccessType.FIELD)
  private Date validFrom;

  @Basic
  @Caption("") //todo
  @Access(AccessType.FIELD)
  private Date validTo;

  @ManyToOne(fetch = FetchType.LAZY)
  @NotEmpty(
    message = "" //todo
  )
  private Person person;

  public Date getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(Date validFrom) {
    this.validFrom = validFrom;
  }

  public Date getValidTo() {
    return validTo;
  }

  public void setValidTo(Date validTo) {
    this.validTo = validTo;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}
