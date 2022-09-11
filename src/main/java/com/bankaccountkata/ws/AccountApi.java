package com.bankaccountkata.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankaccountkata.dto.AccountDto;
import com.bankaccountkata.service.AccountService;

@RestController
@RequestMapping(value = "/account")
public class AccountApi {

	@Autowired
	private AccountService accountService;
	
    @PostMapping("/")
    public void createAccount(@RequestBody AccountDto accountDto) {
    	accountService.saveAccount(accountDto);
    }

}
