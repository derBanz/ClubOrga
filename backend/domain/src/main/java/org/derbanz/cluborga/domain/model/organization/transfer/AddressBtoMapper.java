package org.derbanz.cluborga.domain.model.organization.transfer;

import org.derbanz.cluborga.domain.model.organization.Address;

import java.util.Objects;

public class AddressBtoMapper extends ContactBtoMapper {

  private boolean mapPropertiesToBo(AddressBto bto, Address bo) {
    boolean result = !super.mapPropertiesToBo(bto, bo) ||
      !bo.getStreet().equals(bto.getStreet()) ||
      !bo.getNumber().equals(bto.getNumber()) ||
      !bo.getNumberSuffix().equals(bto.getNumberSuffix()) ||
      !bo.getPostbox().equals(bto.getPostbox()) ||
      !bo.getZip().equals(bto.getZip()) ||
      !bo.getCity().equals(bto.getCity()) ||
      !bo.getCountry().equals(bto.getCountry());

    if (!Objects.isNull(bto.getStreet())) {
      bo.setStreet(bto.getStreet());
    }
    if (!Objects.isNull(bto.getNumber())) {
      bo.setNumber(bto.getNumber());
    }
    if (!Objects.isNull(bto.getNumberSuffix())) {
      bo.setNumberSuffix(bto.getNumberSuffix());
    }
    if (!Objects.isNull(bto.getPostbox())) {
      bo.setPostbox(bto.getPostbox());
    }
    if (!Objects.isNull(bto.getZip())) {
      bo.setZip(bto.getZip());
    }
    if (!Objects.isNull(bto.getCity())) {
      bo.setCity(bto.getCity());
    }
    if (!Objects.isNull(bto.getCountry())) {
      bo.setCountry(bto.getCountry());
    }
    return result;
  }

  private void mapPropertiesToBto(Address bo, AddressBto bto) {
    super.mapPropertiesToBto(bo, bto);

    bto.setStreet(bo.getStreet());
    bto.setNumber(bo.getNumber());
    bto.setNumberSuffix(bo.getNumberSuffix());
    bto.setPostbox(bo.getPostbox());
    bto.setZip(bo.getZip());
    bto.setCity(bo.getCity());
    bto.setCountry(bo.getCountry());

    bto.setIsPostbox(bo.getPostbox() != null);
  }

  public AddressBto toBto(Address bo) {
    AddressBto bto = new AddressBto();
    mapToBto(bo, bto);
    return bto;
  }

  public void mapToBto(Address bo, AddressBto bto) {
    mapPropertiesToBto(bo, bto);
  }

  public boolean mapToBo(Address bo, AddressBto bto) {
    return mapPropertiesToBo(bto, bo);
  }
}
