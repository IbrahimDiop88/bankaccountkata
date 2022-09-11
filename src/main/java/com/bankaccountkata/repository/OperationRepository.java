package com.bankaccountkata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankaccountkata.entity.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, String> {


}
