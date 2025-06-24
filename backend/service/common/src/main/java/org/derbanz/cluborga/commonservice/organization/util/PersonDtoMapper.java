package org.derbanz.cluborga.commonservice.organization.util;

import jakarta.enterprise.context.ApplicationScoped;
import org.derbanz.cluborga.commonservice.organization.dto.PersonDto;
import org.derbanz.cluborga.domain.model.organization.transfer.PersonBto;

@ApplicationScoped
public class PersonDtoMapper {

  public void mapToDto(PersonBto bto, PersonDto dto) {
    dto.setId(bto.getId());
    dto.setCreation(bto.getCreation());
    dto.setCreationUser(bto.getCreationUser());
    dto.setLastUpdate(bto.getLastUpdate());
    dto.setLastUpdateUser(bto.getLastUpdateUser());

    dto.setName(bto.getName());
    dto.setFirstName(bto.getFirstName());
    dto.setDateOfBirth(bto.getDateOfBirth());
    dto.setGender(bto.getGender());
    dto.setIsMember(bto.isMember());

//    dto.setMemberships();
//    dto.setContacts();
  }

  public PersonDto toDto(PersonBto bto) {
    if (bto == null) {
      return null;
    }
    PersonDto dto = new PersonDto();
    mapToDto(bto, dto);
    return dto;
  }

  public void mapDtoToBto(PersonDto dto, PersonBto bto) {
    bto.setId(dto.getId());
    bto.setCreation(dto.getCreation());
    bto.setCreationUser(dto.getCreationUser());
    bto.setLastUpdate(dto.getLastUpdate());
    bto.setLastUpdateUser(dto.getLastUpdateUser());

    bto.setName(dto.getName());
    bto.setFirstName(dto.getFirstName());
    bto.setDateOfBirth(dto.getDateOfBirth());
    bto.setGender(dto.getGender());
    bto.setIsMember(dto.isMember());

//    bto.setMemberships();
//    bto.setContacts();
  }

  public PersonBto toBto(PersonDto dto) {
    if (dto == null) {
      return null;
    }
    PersonBto bto = new PersonBto();
    mapDtoToBto(dto, bto);
    return bto;
  }
}
