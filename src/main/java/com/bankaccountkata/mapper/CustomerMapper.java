package com.bankaccountkata.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bankaccountkata.dto.CustomerDto;
import com.bankaccountkata.entity.Customer;

@Mapper
public interface CustomerMapper {

	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

	CustomerDto toDto(Customer customer);

	Customer toEntity(CustomerDto customerDto);
}
