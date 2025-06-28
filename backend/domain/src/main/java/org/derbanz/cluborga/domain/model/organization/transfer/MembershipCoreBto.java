package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.derbanz.cluborga.domain.base.transfer.BaseBto;
import org.derbanz.cluborga.domain.enums.MembershipStatus;

import java.util.Date;
import java.util.Objects;

public class MembershipCoreBto extends BaseBto {

  public static final String START_DATE = "startDate";
  public static final String STOP_DATE = "stopDate";
  public static final String DISCOUNT = "discount";
  public static final String STATUS = "status";

  public static final String PERSON = "person";
  public static final String APPLICATION = "application";

  @NotEmpty
  private Date startDate;

  private Date stopDate;

  @NotEmpty
  private Boolean discount;

  @NotNull
  private MembershipStatus status;

  @NotEmpty
  private String personId;

  private String applicationId;

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    Objects.requireNonNull(startDate, "Cannot set startDate to null");
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
    Objects.requireNonNull(discount, "Cannot set discount to null");
    this.discount = discount;
  }

  public MembershipStatus getStatus() {
    return status;
  }

  public void setStatus(MembershipStatus status) {
    Objects.requireNonNull(status, "Cannot set status to null");
    this.status = status;
  }

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
    Objects.requireNonNull(personId, "Cannot set personId to null");
    this.personId = personId;
  }

  public String getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(String applicationId) {
    this.applicationId = applicationId;
  }
}
