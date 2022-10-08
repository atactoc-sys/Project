package com.banking.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Bank 
{
	@Id
	private int bankId;
	
	@Column(length = 30, nullable = false)
	private String bankName;
	
	@Column(length = 30, nullable = false)
	private String bankBranchName;
	
	@Column(length = 30, nullable = false)
	private String bankBranchCode;
	
	@Column(length = 16, nullable = false)
	private String bankPassword;
	
	@Column(length = 30, nullable = false)
	private String bankIfcNo;
	
	@Column(length = 30, nullable = false)
	private String bankManagerName;
	
	@Column(length = 30, nullable = false)
	private String bankAddress;
	
	@Column(length = 30, nullable = false)
	private String bankEmail;
	
	@Column(length = 12, nullable = false)
	private long bankHelplinetNo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "bankId")
	private List<Customer> customers;
	

}
