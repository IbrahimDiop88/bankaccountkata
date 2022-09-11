package com.bankaccountkata.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name= "account")
public class Account implements Serializable {

	private static final long serialVersionUID = 7521456781522064842L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "account_id", nullable = false, updatable = false)
	private String id;
	
	@Column(name = "type", nullable = false, updatable = false)
	private String type;

	@Column(name = "creation_date", nullable = false, updatable = false)
	private LocalDateTime creationDate;

	@Column(name = "update_date", nullable = false, updatable = false)
	private LocalDateTime updateDate;

	@Column(name = "balance", nullable = false, updatable = false)
	private BigDecimal balance;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	
	@OneToMany(mappedBy = "account")
	private List<Operation> operationList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Operation> getOperationList() {
		if (operationList == null) {
			return new ArrayList<>();
		}
		return operationList;
	}

	public void setOperationList(List<Operation> operationList) {
		this.operationList = operationList;
	}


	@PrePersist
	void onCreate() {
		this.creationDate = LocalDateTime.now();
		this.updateDate = this.creationDate;
	}

	@PreUpdate
	void onUpdate() {
		this.updateDate = LocalDateTime.now();
	}
}
