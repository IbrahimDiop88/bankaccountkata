package com.bankaccountkata.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bankaccountkata.dto.OperationDto;
import com.bankaccountkata.entity.Operation;

@Mapper
public interface OperationMapper {

	OperationMapper INSTANCE = Mappers.getMapper(OperationMapper.class);

	OperationDto toDto(Operation operation);

	Operation toEntity(OperationDto operationDto);
}
