package com.bankaccountkata.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bankaccountkata.dto.AccountDto;
import com.bankaccountkata.entity.Account;

@Mapper
public interface AccountMapper {

	AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

	AccountDto toDto(Account account);

	Account toEntity(AccountDto accountDto);

}
