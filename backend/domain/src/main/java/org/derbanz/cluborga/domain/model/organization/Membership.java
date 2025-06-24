package org.derbanz.cluborga.domain.model.organization;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.derbanz.cluborga.domain.base.AbstractBusinessObject;
import org.derbanz.cluborga.domain.base.Caption;
import org.derbanz.cluborga.domain.enums.MembershipStatus;

import java.util.Date;

@Entity(
        name = "org.derbanz.cluborga.domain.model.organization.membership"
)
@Table(
        name = "co_membership"
)
@Caption("") //todo
public class Membership extends AbstractBusinessObject {

    public static final String START_DATE = "startDate";
    public static final String STOP_DATE = "stopDate";
    public static final String DISCOUNT = "discount";
    public static final String STATUS = "status";

    public static final String PERSON = "person";
    public static final String APPLICATION = "application";

    @Basic
    @NotEmpty(
            message = "" //todo
    )
    @Caption("") //todo
    @Access(AccessType.FIELD)
    private Date startDate;

    @Basic
    @Caption("") //todo
    @Access(AccessType.FIELD)
    private Date stopDate;

    @Basic
    @NotEmpty(
            message = "" //todo
    )
    @Caption("") //todo
    @Access(AccessType.FIELD)
    private Boolean discount;

    @Basic
    @NotEmpty(
            message = "" //todo
    )
    @Caption("") //todo
    @Enumerated(EnumType.STRING)
    @Access(AccessType.FIELD)
    private MembershipStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotEmpty(
            message = "" //todo
    )
    private Person person;

    @OneToOne(fetch = FetchType.LAZY)
    private Application application;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public Boolean getDiscount() {
        return discount;
    }

    public void setDiscount(Boolean discount) {
        this.discount = discount;
    }

    public MembershipStatus getStatus() {
        return status;
    }

    public void setStatus(MembershipStatus status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
