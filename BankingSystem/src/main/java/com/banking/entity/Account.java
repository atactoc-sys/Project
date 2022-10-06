package com.banking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Account 
{
	@Id
	private long accountNo;
	
	@Column(length = 8, nullable = false)
	private String accountPassword;
	
	@Column(length = 10, nullable = false)
	private String accountType;
	
	@Column(nullable = false)
	private boolean accountActivStatus;
	
	@Column(length = 10, nullable = false)
	private double accountBalance;
	
	@Column(length = 10, nullable = false)
	private double widrawnAmmount;
	
	@Column(length = 10, nullable = false)
	private double depositedAmount;

}
