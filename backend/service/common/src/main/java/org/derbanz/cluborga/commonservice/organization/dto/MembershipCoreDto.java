// generated
package org.derbanz.cluborga.commonservice.organization.dto;

import org.derbanz.cluborga.domain.base.dto.BaseDto;
import org.derbanz.cluborga.domain.enums.MembershipStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MembershipCoreDto extends BaseDto {

  private Date validFrom;
  private Date validTo;
  private Boolean discount;
  private MembershipStatus status;

  private PersonDto person;
  private ApplicationDto application;

  private List<PaymentMethodDto> paymentMethods;

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

  public PersonDto getPerson() {
    return person;
  }

  public void setPerson(PersonDto person) {
    this.person = person;
  }

  public ApplicationDto getApplication() {
    return application;
  }

  public void setApplication(ApplicationDto application) {
    this.application = application;
  }

  public List<PaymentMethodDto> getPaymentMethods() {
    if (paymentMethods == null) {
      setPaymentMethods(new ArrayList<>());
    }
    return paymentMethods;
  }

  public void setPaymentMethods(List<PaymentMethodDto> paymentMethods) {
    this.paymentMethods = paymentMethods;
  }

}