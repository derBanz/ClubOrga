package org.derbanz.cluborga.domain.model.organization.transfer;

import jakarta.validation.constraints.NotEmpty;

public class EmailBto extends ContactBto {

  public static final String EMAIL = "email";

  @NotEmpty
  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
