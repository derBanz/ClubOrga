package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.validation.constraints.NotEmpty;
import org.derbanz.cluborga.domain.base.transfer.BaseBto;
import org.derbanz.cluborga.domain.enums.ApplicationStatus;

import java.util.Date;

public class ApplicationCoreBto extends BaseBto {

  public static final String APPLICATION_DATE = "applicationDate";
  public static final String DATE_OF_REPLY = "dateOfReply";
  public static final String STATUS = "status";

  public static final String MEMBERSHIP = "membership";

  @NotEmpty
  private Date applicationDate;

  private Date dateOfReply;

  @NotEmpty
  private ApplicationStatus status;

  @NotEmpty
  private String membershipId;

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

  public String getMembershipId() {
    return membershipId;
  }

  public void setMembershipId(String membershipId) {
    this.membershipId = membershipId;
  }
}
