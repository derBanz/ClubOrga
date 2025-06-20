package org.derbanz.cluborga.domain.model.organization.transfer;

import org.derbanz.cluborga.domain.model.organization.Email;

import java.util.Objects;

public class EmailBtoMapper extends ContactBtoMapper {

  private boolean mapPropertiesToBo(EmailBto bto, Email bo) {
    boolean result = !super.mapPropertiesToBo(bto, bo) ||
      !bo.getEmail().equals(bto.getEmail());

    if (!Objects.isNull(bto.getEmail())) {
      bo.setEmail(bto.getEmail());
    }
    return result;
  }

  private void mapPropertiesToBto(Email bo, EmailBto bto) {
    super.mapPropertiesToBto(bo, bto);

    bto.setEmail(bo.getEmail());
  }

  public EmailBto toBto(Email bo) {
    EmailBto bto = new EmailBto();
    mapToBto(bo, bto);
    return bto;
  }

  public void mapToBto(Email bo, EmailBto bto) {
    mapPropertiesToBto(bo, bto);
  }

  public boolean mapToBo(Email bo, EmailBto bto) {
    return mapPropertiesToBo(bto, bo);
  }
}
