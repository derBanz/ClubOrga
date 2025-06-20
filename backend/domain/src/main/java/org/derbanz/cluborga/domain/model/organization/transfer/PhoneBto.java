package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.validation.constraints.NotEmpty;

public class PhoneBto extends ContactBto {

  public static final String COUNTRY_CODE = "countryCode";
  public static final String PHONE_NUMBER = "phoneNumber";

  @NotEmpty
  private String countryCode;

  @NotEmpty
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
