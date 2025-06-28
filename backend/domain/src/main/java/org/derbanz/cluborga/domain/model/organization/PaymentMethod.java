package org.derbanz.cluborga.domain.model.organization;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.derbanz.cluborga.domain.base.AbstractBusinessObject;
import org.derbanz.cluborga.domain.base.Caption;

import java.util.Date;


@Entity(
  name = "org.derbanz.cluborga.domain.model.organization.paymentmethod"
)
@Table(
  name = "co_paymentmethod"
)
@Caption("") //todo
public class PaymentMethod extends AbstractBusinessObject {

  public static final String VALID_FROM = "validFrom";
  public static final String VALID_TO = "validTo";
  public static final String IBAN = "iban";
  public static final String BIC = "bic";
  public static final String BANK = "bank";
  public static final String SEPA_MANDATA = "sepaMandate";

  public static final String MEMBERSHIP = "membership";

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
  @Access(AccessType.FIELD)
  private String iban;

  @Basic
  @Caption("") //todo
  @Access(AccessType.FIELD)
  private String bic;

  @Basic
  @Caption("") //todo
  @Access(AccessType.FIELD)
  private String bank;

  @Basic
  @NotEmpty(
    message = "" //todo
  )
  @Caption("") //todo
  @Access(AccessType.FIELD)
  private Boolean sepaMandate;

  @ManyToOne(fetch = FetchType.LAZY)
  @NotEmpty(
    message = "" //todo
  )
  private Membership membership;

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

  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public String getBic() {
    return bic;
  }

  public void setBic(String bic) {
    this.bic = bic;
  }

  public String getBank() {
    return bank;
  }

  public void setBank(String bank) {
    this.bank = bank;
  }

  public Boolean getSepaMandate() {
    return sepaMandate;
  }

  public void setSepaMandate(Boolean sepaMandate) {
    this.sepaMandate = sepaMandate;
  }

  public Membership getMembership() {
    return membership;
  }

  public void setMembership(Membership membership) {
    this.membership = membership;
  }
}
