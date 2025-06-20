package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.validation.constraints.NotEmpty;
import org.derbanz.cluborga.domain.base.transfer.BaseBto;

import java.util.Date;
import java.util.Objects;

public class ContactCoreBto extends BaseBto {

  public static final String VALID_FROM = "validFrom";
  public static final String VALID_TO = "validTo";

  public static final String PERSON = "person";

  @NotEmpty
  private Date validFrom;

  private Date validTo;

  @NotEmpty
  private String personId;

  public Date getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(Date validFrom) {
    Objects.requireNonNull(validFrom, "Cannot set validFrom to null");
    this.validFrom = validFrom;
  }

  public Date getValidTo() {
    return validTo;
  }

  public void setValidTo(Date validTo) {
    this.validTo = validTo;
  }

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
    Objects.requireNonNull(personId, "Cannot set personId to null");
    this.personId = personId;
  }
}
