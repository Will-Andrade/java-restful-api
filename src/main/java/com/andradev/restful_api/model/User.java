package com.andradev.restful_api.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private String name;
	
	// when an user is deleted, the account is deleted as well
	@OneToOne(cascade = CascadeType.ALL)
	private Account account;
	
	// Whenever I get an user, I'll want this property as well
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Feature> features;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Card card;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<News> news;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public List<Feature> getFeatures() {
		return features;
	}
	
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
	
	public Card getCard() {
		return card;
	}
	
	public void setCard(Card card) {
		this.card = card;
	}
	
	public List<News> getNews() {
		return news;
	}
	
	public void setNews(List<News> news) {
		this.news = news;
	}
}
