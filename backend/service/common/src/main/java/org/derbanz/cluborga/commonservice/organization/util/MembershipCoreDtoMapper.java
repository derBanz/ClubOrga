// generated
package org.derbanz.cluborga.commonservice.organization.util;

import jakarta.inject.Inject;
import org.derbanz.cluborga.commonservice.organization.dto.MembershipDto;
import org.derbanz.cluborga.domain.base.util.BaseDtoMapper;
import org.derbanz.cluborga.domain.model.organization.transfer.MembershipBto;

import java.util.List;

public class MembershipCoreDtoMapper extends BaseDtoMapper {

  @Inject
  ApplicationDtoMapper applicationDtoMapper;
  @Inject
  PaymentMethodDtoMapper paymentmethodDtoMapper;
  @Inject
  PersonDtoMapper personDtoMapper;

  private void mapPropertiesToBto(MembershipDto dto, MembershipBto bto) {
    mapBaseDtoToBto(dto, bto);

    bto.setValidFrom(dto.getValidFrom());
    bto.setValidTo(dto.getValidTo());
    bto.setDiscount(dto.getDiscount());
    bto.setStatus(dto.getStatus());
  }

  private void mapPropertiesToDto(MembershipBto bto, MembershipDto dto) {
    mapBaseBtoToDto(bto, dto);

    dto.setValidFrom(bto.getValidFrom());
    dto.setValidTo(bto.getValidTo());
    dto.setDiscount(bto.getDiscount());
    dto.setStatus(bto.getStatus());
  }

  public void mapToBto(MembershipDto dto, MembershipBto bto) {
    if (dto != null) {
      mapPropertiesToBto(dto, bto);
      if (dto.getPerson() != null) {
        bto.setPerson(personDtoMapper.toBto(dto.getPerson()));
      }
      if (dto.getApplication() != null) {
        bto.setApplication(applicationDtoMapper.toBto(dto.getApplication()));
      }
      bto.setPaymentMethods(dto.getPaymentMethods().stream().map(paymentmethodDtoMapper::toBto).toList());
    }
  }

  public MembershipBto toBto(MembershipDto dto) {
    MembershipBto bto = new MembershipBto();
    mapToBto(dto, bto);
    return bto;
  }

  public void mapToDto(MembershipBto bto, MembershipDto dto) {
    if (bto != null) {
      mapPropertiesToDto(bto, dto);
      if (bto.getPerson() != null) {
        dto.setPerson(personDtoMapper.toDto(bto.getPerson()));
      }
      if (bto.getApplication() != null) {
        dto.setApplication(applicationDtoMapper.toDto(bto.getApplication()));
      }
      dto.setPaymentMethods(bto.getPaymentMethods().stream().map(paymentmethodDtoMapper::toDto).toList());
    }
  }

  public MembershipDto toDto(MembershipBto bto) {
    MembershipDto dto = new MembershipDto();
    mapToDto(bto, dto);
    return dto;
  }
}