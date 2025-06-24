package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.validation.constraints.NotEmpty;
import org.derbanz.cluborga.domain.base.transfer.BaseBto;
import org.derbanz.cluborga.domain.enums.ContactType;

import java.util.Date;
import java.util.Objects;

public class ContactCoreBto extends BaseBto {

    public static final String VALID_FROM = "validFrom";
    public static final String VALID_TO = "validTo";
    public static final String TYPE = "type";

    public static final String STREET = "street";
    public static final String NUMBER = "number";
    public static final String NUMBER_SUFFIX = "numberSuffix";
    public static final String POSTBOX = "postbox";
    public static final String ZIP = "zip";
    public static final String CITY = "city";
    public static final String COUNTRY = "country";

    public static final String EMAIL = "email";

    public static final String COUNTRY_CODE = "countryCode";
    public static final String PHONE_NUMBER = "phoneNumber";

    public static final String PERSON = "person";

    @NotEmpty
    private Date validFrom;

    private Date validTo;

    @NotEmpty
    private ContactType type;

    private String street;

    private String number;

    private String numberSuffix;

    private String postbox;

    private String zip;

    private String city;

    private String country;

    private Boolean isPostbox;

    private String email;

    private String countryCode;

    private String phoneNumber;

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

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        Objects.requireNonNull(type, "Cannot set type to null");
        this.type = type;
    }

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

    public boolean isPostbox() {
        return this.isPostbox;
    }

    public void setPostbox(String postbox) {
        this.postbox = postbox;
    }

    public void setIsPostbox(Boolean isPostbox) {
        this.isPostbox = isPostbox;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        Objects.requireNonNull(personId, "Cannot set personId to null");
        this.personId = personId;
    }
}
