package com.example.kafka_producer.model;

public class Customer {
	
	private String custId;
	
	private String custName;
	
	private String custAddress;
	
	private Integer phNumber;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public Integer getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(Integer phNumber) {
		this.phNumber = phNumber;
	}

}
