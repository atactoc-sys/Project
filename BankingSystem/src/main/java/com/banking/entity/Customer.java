package com.banking.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Customer 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerNo;
	
	@Column(length = 30, nullable = false)
	private String customerFirstName;
	
	@Column(length = 30, nullable = false)
	private String customerLastName;
	
	@Column(length = 30, nullable = false)
	private String customerIdProofNo;
	
	@Column(length = 30, nullable = false)
	private String customerIdType;
	
	@Column(length = 30, nullable = false)
	private String customerAddress;
	
	@Column(length = 30, nullable = false)
	private String customerDob;
	
	@Column(length = 30, nullable = false)
	private String customerEmwail;
	
	@Column(length = 30, nullable = false)
	private long customerContactNo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerNo")
	private List<Account> accounts;
	
}
