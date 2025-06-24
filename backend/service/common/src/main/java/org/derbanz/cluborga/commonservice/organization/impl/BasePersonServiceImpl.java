package org.derbanz.cluborga.commonservice.organization.impl;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import org.derbanz.cluborga.commonservice.organization.BasePersonService;
import org.derbanz.cluborga.commonservice.organization.dto.PersonDto;
import org.derbanz.cluborga.commonservice.organization.util.PersonDtoMapper;
import org.derbanz.cluborga.domain.model.organization.transfer.PersonBto;
import org.derbanz.cluborga.logic.organization.PersonLogic;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BasePersonServiceImpl implements BasePersonService {

    @Inject
    PersonLogic logic;
    @Inject
    PersonDtoMapper dtoMapper;

    @Override
    public void validate(PersonDto dto) throws ValidationException {
        PersonBto bto = dtoMapper.toBto(dto);
        Set<ConstraintViolation<PersonBto>> validationResult = logic.validate(bto);
        if (!validationResult.isEmpty()) {
            String message = validationResult.stream()
                    .map(val -> String.valueOf(val.getPropertyPath()).concat(": ").concat(val.getMessage())).collect(Collectors.joining("\n"));
            throw new ValidationException(message);
        }
    }

    @Override
    @Transactional
    public String save(PersonDto dto) throws ValidationException {
        PersonBto bto = dtoMapper.toBto(dto);
        logic.save(bto);
        dto.setId(bto.getId());
        return dto.getId();
    }

    @Override
    public PersonDto get(String id) {
        PersonBto bto = logic.get(id);
        return dtoMapper.toDto(bto);
    }

    @Override
    public List<PersonDto> getList(List<String> ids) {
        return logic.getList(ids).stream().map(dtoMapper::toDto).toList();
    }

    @Override
    public List<PersonDto> getAll() {
        return logic.getAll().stream().map(dtoMapper::toDto).toList();
    }

    @Override
    @Transactional
    public boolean delete(String id) {
        return logic.delete(id);
    }
}
