package org.derbanz.cluborga.domain.model.organization;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.derbanz.cluborga.domain.base.AbstractBusinessObject;
import org.derbanz.cluborga.domain.base.Caption;
import org.derbanz.cluborga.domain.enums.ApplicationStatus;

import java.util.Date;

@Entity(
  name = "org.derbanz.cluborga.domain.model.organization.application"
)
@Table(
  name = "co_application"
)
@Caption("") //todo
public class Application extends AbstractBusinessObject {

  public static final String APPLICATION_DATE = "applicationDate";
  public static final String DATE_OF_REPLY = "dateOfReply";
  public static final String STATUS = "status";

  public static final String MEMBERSHIP = "membership";

  @Basic
  @NotEmpty(
    message = "" //todo
  )
  @Caption("") //todo
  @Access(AccessType.FIELD)
  private Date applicationDate;

  @Basic
  @Caption("") //todo
  @Access(AccessType.FIELD)
  private Date dateOfReply;

  @Basic
  @NotNull(
    message = "" //todo
  )
  @Caption("") //todo
  @Enumerated(EnumType.STRING)
  @Access(AccessType.FIELD)
  private ApplicationStatus status;

  @OneToOne(fetch = FetchType.LAZY)
  @NotEmpty(
    message = "" //todo
  )
  private Membership membership;

  public Date getApplicationDate() {
    return applicationDate;
  }

  public void setApplicationDate(Date applicationDate) {
    this.applicationDate = applicationDate;
  }

  public Date getDateOfReply() {
    return dateOfReply;
  }

  public void setDateOfReply(Date dateOfReply) {
    this.dateOfReply = dateOfReply;
  }

  public ApplicationStatus getStatus() {
    return status;
  }

  public void setStatus(ApplicationStatus status) {
    this.status = status;
  }

  public Membership getMembership() {
    return membership;
  }

  public void setMembership(Membership membership) {
    this.membership = membership;
  }
}
