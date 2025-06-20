package org.derbanz.cluborga.domain.model.organization.transfer;

import org.derbanz.cluborga.domain.model.organization.Phone;

import java.util.Objects;

public class PhoneBtoMapper extends ContactBtoMapper {

  private boolean mapPropertiesToBo(PhoneBto bto, Phone bo) {
    boolean result = !super.mapPropertiesToBo(bto, bo) ||
      !bo.getCountryCode().equals(bto.getCountryCode()) ||
      !bo.getPhoneNumber().equals(bto.getPhoneNumber());

    if (!Objects.isNull(bto.getCountryCode())) {
      bo.setCountryCode(bto.getCountryCode());
    }
    if (!Objects.isNull(bto.getPhoneNumber())) {
      bo.setPhoneNumber(bto.getPhoneNumber());
    }
    return result;
  }

  private void mapPropertiesToBto(Phone bo, PhoneBto bto) {
    super.mapPropertiesToBto(bo, bto);

    bto.setCountryCode(bo.getCountryCode());
    bto.setPhoneNumber(bo.getPhoneNumber());
  }

  public PhoneBto toBto(Phone bo) {
    PhoneBto bto = new PhoneBto();
    mapToBto(bo, bto);
    return bto;
  }

  public void mapToBto(Phone bo, PhoneBto bto) {
    mapPropertiesToBto(bo, bto);
  }

  public boolean mapToBo(Phone bo, PhoneBto bto) {
    return mapPropertiesToBo(bto, bo);
  }
}
