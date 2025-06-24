package org.derbanz.cluborga.domain.model.organization;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.derbanz.cluborga.domain.base.AbstractBusinessObject;
import org.derbanz.cluborga.domain.base.Caption;
import org.derbanz.cluborga.domain.enums.Gender;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(
        name = "org.derbanz.cluborga.domain.model.organization.person"
)
@Table(
        name = "co_person"
)
@Caption("") //todo
public class Person extends AbstractBusinessObject {

    public static final String NAME = "name";
    public static final String FIRST_NAME = "firstName";
    public static final String DATE_OF_BIRTH = "dateOfBirth";
    public static final String GENDER = "gender";

    public static final String MEMBERSHIPS = "memberships";
    public static final String CONTACTS = "contacts";

    @Basic
    @NotEmpty(
            message = "" //todo
    )
    @Caption("") //todo
    @Access(AccessType.FIELD)
    private String name;

    @Basic
    @Caption("") //todo
    @Access(AccessType.FIELD)
    private String firstName;

    @Basic
    @Caption("") //todo
    @Access(AccessType.FIELD)
    private Date dateOfBirth;

    @Basic
    @NotEmpty(
            message = "" //todo
    )
    @Caption("") //todo
    @Enumerated(EnumType.STRING)
    @Access(AccessType.FIELD)
    private Gender gender;

    @OneToMany(
            cascade = {
                    CascadeType.REMOVE
            },
            mappedBy = "person",
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<Membership> memberships;

    @OneToMany(
            cascade = {
                    CascadeType.REMOVE
            },
            mappedBy = "person",
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<Contact> contacts;

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

    public Set<Membership> getMemberships() {
        if (this.memberships == null) {
            this.setMemberships(new HashSet<>());
        }
        return memberships;
    }

    public void setMemberships(Set<Membership> memberships) {
        this.memberships = memberships;
    }

    public boolean addMembership(final Membership membership) {
        if (membership == null) {
            return false;
        }
        membership.setPerson(this);
        if (!this.memberships.contains(membership)) {
            return this.memberships.add(membership);
        }
        return false;
    }

    public boolean removeMembership(final Membership membership) {
        if (membership == null) {
            return false;
        }
        return this.memberships.remove(membership);
    }

    public Set<Contact> getContacts() {
        if (this.contacts == null) {
            this.setContacts(new HashSet<>());
        }
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public boolean addContact(final Contact contact) {
        if (contact == null) {
            return false;
        }
        contact.setPerson(this);
        if (!this.contacts.contains(contact)) {
            return this.contacts.add(contact);
        }
        return false;
    }

    public boolean removeContact(final Contact contact) {
        if (contact == null) {
            return false;
        }
        return this.contacts.remove(contact);
    }

    public String toString() {
        return String.format("Person : %s (%s %s)", this.getId(), this.getFirstName(), this.getName());
    }
}
