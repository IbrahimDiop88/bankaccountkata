package com.bankaccountkata.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankaccountkata.entity.Account;
import com.bankaccountkata.entity.Customer;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

	Optional<Account> findByCustomerAndType(Customer customer, String type);
	
}
