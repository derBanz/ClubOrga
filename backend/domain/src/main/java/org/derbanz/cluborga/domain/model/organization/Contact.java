package org.derbanz.cluborga.domain.model.organization;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.derbanz.cluborga.domain.base.AbstractBusinessObject;
import org.derbanz.cluborga.domain.base.Caption;
import org.derbanz.cluborga.domain.enums.ContactType;
import org.derbanz.cluborga.domain.i18n.Constants;

import java.util.Date;

@Entity(
        name = "org.derbanz.cluborga.domain.model.organization.contact"
)
@Table(
        name = "co_contact"
)
@Caption("") //todo
public class Contact extends AbstractBusinessObject {

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

    @Basic
    @NotEmpty(
            message = "" //todo
    )
    @Caption("") //todo
    @Enumerated(EnumType.STRING)
    @Access(AccessType.FIELD)
    private ContactType type;

    //Address contact
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
    @Caption(Constants.BO_ADDRESS_ZIP)
    @Access(AccessType.FIELD)
    private String zip;

    @Basic
    @Caption(Constants.BO_ADDRESS_CITY)
    @Access(AccessType.FIELD)
    private String city;

    @Basic
    @Caption(Constants.BO_ADDRESS_COUNTRY)
    @Access(AccessType.FIELD)
    private String country;

    //Email contact
    @Basic
    @Caption("") //todo
    @Access(AccessType.FIELD)
    private String email;

    //Phone contact
    @Basic
    @Caption("") //todo
    @Access(AccessType.FIELD)
    private String countryCode;

    @Basic
    @Caption("") //todo
    @Access(AccessType.FIELD)
    private String phoneNumber;


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

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
