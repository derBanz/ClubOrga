// generated
package org.derbanz.cluborga.domain.model.organization;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.derbanz.cluborga.domain.base.AbstractBusinessObject;
import org.derbanz.cluborga.domain.enums.MembershipStatus;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(
  name = "org.derbanz.cluborga.domain.model.organization.Membership"
)
@Table(
  name = "co_membership"
)
public class Membership extends AbstractBusinessObject {

  public static final String VALID_FROM = "validFrom";
  public static final String VALID_TO = "validTo";
  public static final String DISCOUNT = "discount";
  public static final String STATUS = "status";

  public static final String PERSON = "person";
  public static final String APPLICATION = "application";
  public static final String PAYMENT_METHODS = "paymentMethods";

  @Basic
  @NotEmpty()
  @Access(AccessType.FIELD)
  private Date validFrom;

  @Basic
  @Access(AccessType.FIELD)
  private Date validTo;

  @Basic
  @NotEmpty()
  @Access(AccessType.FIELD)
  private Boolean discount;

  @Basic
  @NotEmpty()
  @Enumerated(EnumType.STRING)
  @Access(AccessType.FIELD)
  private MembershipStatus status;

  @ManyToOne(fetch = FetchType.LAZY)
  @NotEmpty()
  private Person person;

  @ManyToOne(fetch = FetchType.LAZY)
  private Application application;

  @OneToMany(
    cascade = {
      CascadeType.REMOVE
    },
    fetch = FetchType.LAZY,
    orphanRemoval = true
  )
  private Set<PaymentMethod> paymentMethods;


  public Date getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(final Date validFrom) {
    this.validFrom = validFrom;
  }

  public Date getValidTo() {
    return validTo;
  }

  public void setValidTo(final Date validTo) {
    this.validTo = validTo;
  }

  public Boolean getDiscount() {
    return discount;
  }

  public void setDiscount(final Boolean discount) {
    this.discount = discount;
  }

  public MembershipStatus getStatus() {
    return status;
  }

  public void setStatus(final MembershipStatus status) {
    this.status = status;
  }


  public Person getPerson() {
    return person;
  }

  public void setPerson(final Person person) {
    this.person = person;
  }

  public Application getApplication() {
    return application;
  }

  public void setApplication(final Application application) {
    this.application = application;
  }

  public Set<PaymentMethod> getPaymentMethods() {
    return paymentMethods;
  }

  public void setPaymentMethods(final Set<PaymentMethod> paymentMethods) {
    this.paymentMethods = paymentMethods;
  }

  public boolean addPaymentMethod(final PaymentMethod paymentMethod) {
    if (paymentMethod == null) {
      return false;
    }
    paymentMethod.setMembership(this);
    if (!(this.paymentMethods.contains(paymentMethod))) {
      return this.paymentMethods.add(paymentMethod);
    }
    return false;
  }
}