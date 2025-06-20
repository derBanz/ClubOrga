package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.validation.constraints.NotEmpty;

public class AddressBto extends ContactBto {

  public static final String STREET = "street";
  public static final String NUMBER = "number";
  public static final String NUMBER_SUFFIX = "numberSuffix";
  public static final String POSTBOX = "postbox";
  public static final String ZIP = "zip";
  public static final String CITY = "city";
  public static final String COUNTRY = "country";

  private String street;

  private String number;

  private String numberSuffix;

  private String postbox;

  @NotEmpty
  private String zip;

  @NotEmpty
  private String city;

  @NotEmpty
  private String country;

  private Boolean isPostbox;

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getNumberSuffix() {
    return numberSuffix;
  }

  public void setNumberSuffix(String numberSuffix) {
    this.numberSuffix = numberSuffix;
  }

  public String getPostbox() {
    return postbox;
  }

  public void setPostbox(String postbox) {
    this.postbox = postbox;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Boolean isPostbox() {
    return isPostbox;
  }

  public void setIsPostbox(Boolean isPostbox) {
    this.isPostbox = isPostbox;
  }
}
