package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.validation.constraints.NotEmpty;
import org.derbanz.cluborga.domain.base.transfer.BaseBto;

import java.util.Date;
import java.util.Objects;

public class PaymentMethodCoreBto extends BaseBto {

  public static final String VALID_FROM = "validFrom";
  public static final String VALID_TO = "validTo";
  public static final String IBAN = "iban";
  public static final String BIC = "bic";
  public static final String BANK = "bank";
  public static final String SEPA_MANDATA = "sepaMandate";

  public static final String MEMBERSHIP = "membership";

  @NotEmpty
  private Date validFrom;

  private Date validTo;

  @NotEmpty
  private String iban;

  private String bic;

  private String bank;

  @NotEmpty
  private Boolean sepaMandate;

  @NotEmpty
  private String membershipId;

  public Date getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(Date validFrom) {
    Objects.requireNonNull(validFrom, "Cannot set validFrom to null");
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
    Objects.requireNonNull(iban, "Cannot set iban to null");
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
    Objects.requireNonNull(sepaMandate, "Cannot set sepaMandate to null");
    this.sepaMandate = sepaMandate;
  }

  public String getMembershipId() {
    return membershipId;
  }

  public void setMembershipId(String membershipId) {
    this.membershipId = membershipId;
  }
}
