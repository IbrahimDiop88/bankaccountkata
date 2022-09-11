package com.bankaccountkata.ws;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankaccountkata.dto.CustomerOperationDto;
import com.bankaccountkata.dto.OperationDto;
import com.bankaccountkata.service.CustomerOperationService;

@RestController
@RequestMapping(value = "/operations")
public class CustomerOperationApi {

	@Autowired
	private CustomerOperationService customerOperationService;

	@GetMapping("/{customerName}/{customerPhone}/{accountType}")
	public List<OperationDto> search(@PathVariable("customerName") String customerName,
			@PathVariable("customerPhone") String customerPhone, @PathVariable("accountType") String accountType) {
		return customerOperationService.searchOperation(customerName, customerPhone, accountType);
	}

	@PostMapping(path = "/deposit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OperationDto> depositOperation(@RequestBody CustomerOperationDto customerOperationDto)
			throws ServerException {
		OperationDto operationDto = customerOperationService.makeDepositInAccount(customerOperationDto);
		if (operationDto == null) {
			throw new ServerException("");
		} else {
			return new ResponseEntity<>(operationDto, HttpStatus.CREATED);
		}
	}

	@PostMapping(path = "/wihtdraw", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OperationDto> wihtdrawOperation(@RequestBody CustomerOperationDto customerOperationDto)
			throws ServerException {
		OperationDto operation = customerOperationService.makeWihtdrawalFromAccount(customerOperationDto);
		if (operation == null) {
			throw new ServerException("");
		} else {
			return new ResponseEntity<>(operation, HttpStatus.CREATED);
		}
	}

}
