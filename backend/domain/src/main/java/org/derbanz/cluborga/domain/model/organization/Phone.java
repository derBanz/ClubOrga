package org.derbanz.cluborga.domain.model.organization;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.derbanz.cluborga.domain.base.Caption;

@Entity(
  name = "org.derbanz.cluborga.domain.model.organization.phone"
)
@Table(
  name = "co_phone"
)
@Caption("") //todo
public class Phone extends Contact {

  public static final String COUNTRY_CODE = "countryCode";
  public static final String PHONE_NUMBER = "phoneNumber";

  @Basic
  @NotEmpty(
    message = "" //todo
  )
  @Caption("") //todo
  @Access(AccessType.FIELD)
  private String countryCode;

  @Basic
  @NotEmpty(
    message = "" //todo
  )
  @Caption("") //todo
  @Access(AccessType.FIELD)
  private String phoneNumber;

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
