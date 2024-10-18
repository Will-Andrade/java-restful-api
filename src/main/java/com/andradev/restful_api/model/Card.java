package com.andradev.restful_api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "tb_card")
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(unique = true)
	private String number;
	
	@Column(name = "available_limit", nullable = false, precision = 2, scale = 13)
	private BigDecimal limit;
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public BigDecimal getLimit() {
		return limit;
	}
	
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
}
