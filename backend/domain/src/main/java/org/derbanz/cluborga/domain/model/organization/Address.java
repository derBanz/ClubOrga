package org.derbanz.cluborga.domain.model.organization;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.derbanz.cluborga.domain.base.Caption;
import org.derbanz.cluborga.domain.i18n.Constants;
import org.derbanz.cluborga.domain.i18n.ValidationMessages;

@Entity(
  name = "org.derbanz.cluborga.domain.model.organization.Address"
)
@Table(
  name = "co_address"
)
@Caption(Constants.BO_ADDRESS)
public class Address extends Contact {

  public static final String STREET = "street";
  public static final String NUMBER = "number";
  public static final String NUMBER_SUFFIX = "numberSuffix";
  public static final String POSTBOX = "postbox";
  public static final String ZIP = "zip";
  public static final String CITY = "city";
  public static final String COUNTRY = "country";


  @Basic
  @Caption(Constants.BO_ADDRESS_STREET)
  @Access(AccessType.FIELD)
  private String street;

  @Basic
  @Caption(Constants.BO_ADDRESS_NUMBER)
  @Access(AccessType.FIELD)
  private String number;

  @Basic
  @Caption(Constants.BO_ADDRESS_NUMBERSUFFIX)
  @Access(AccessType.FIELD)
  private String numberSuffix;

  @Basic
  @Caption(Constants.BO_ADDRESS_POSTBOX)
  @Access(AccessType.FIELD)
  private String postbox;

  @Basic
  @NotEmpty(
    message = ValidationMessages.BO_ADDRESS_REQUIRED_ZIP
  )
  @Caption(Constants.BO_ADDRESS_ZIP)
  @Access(AccessType.FIELD)
  private String zip;

  @Basic
  @NotEmpty(
    message = ValidationMessages.BO_ADDRESS_REQUIRED_CITY
  )
  @Caption(Constants.BO_ADDRESS_CITY)
  @Access(AccessType.FIELD)
  private String city;

  @Basic
  @NotEmpty(
    message = ValidationMessages.BO_ADDRESS_REQUIRED_COUNTRY
  )
  @Caption(Constants.BO_ADDRESS_COUNTRY)
  @Access(AccessType.FIELD)
  private String country;

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
}
