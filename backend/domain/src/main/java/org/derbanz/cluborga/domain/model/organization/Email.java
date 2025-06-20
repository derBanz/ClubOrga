package org.derbanz.cluborga.domain.model.organization;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.derbanz.cluborga.domain.base.Caption;

@Entity(
  name = "org.derbanz.cluborga.domain.model.organization.contact"
)
@Table(
  name = "co_contact"
)
@Caption("") //todo
public class Email extends Contact {

  public static final String EMAIL = "email";

  @Basic
  @NotEmpty(
    message = "" //todo
  )
  @Caption("") //todo
  @Access(AccessType.FIELD)
  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
