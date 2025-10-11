// generated
package org.derbanz.cluborga.commonservice.organization.dto;

import org.derbanz.cluborga.domain.base.dto.BaseDto;
import org.derbanz.cluborga.domain.enums.ApplicationStatus;

import java.util.Date;

public class ApplicationCoreDto extends BaseDto {

  private Date applicationDate;
  private Date dateOfReply;
  private ApplicationStatus status;

  private MembershipDto membership;

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

  public MembershipDto getMembership() {
    return membership;
  }

  public void setMembership(MembershipDto membership) {
    this.membership = membership;
  }

}