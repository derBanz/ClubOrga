// generated
package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.derbanz.cluborga.domain.base.transfer.BaseBto;
import org.derbanz.cluborga.domain.enums.ApplicationStatus;

import java.util.Date;
import java.util.Objects;

public class ApplicationCoreBto extends BaseBto {

  @NotEmpty
  private Date applicationDate;

  private Date dateOfReply;

  @NotNull
  private ApplicationStatus status;

  private MembershipBto membership;


  public Date getApplicationDate() {
    return applicationDate;
  }

  public void setApplicationDate(Date applicationDate) {
    Objects.requireNonNull(applicationDate, "ApplicationDate cannot be null.");
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
    Objects.requireNonNull(status, "Status cannot be null.");
    this.status = status;
  }


  public MembershipBto getMembership() {
    return membership;
  }

  public void setMembership(MembershipBto membership) {
    this.membership = membership;
  }

}