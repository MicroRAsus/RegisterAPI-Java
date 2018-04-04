package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import edu.uark.models.entities.ProductEntity;

public class Product {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Product setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public Product setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
		return this;
	}
	
	private int quantity;
	public int getQuantity() {
		return this.quantity;
	}
	public Product setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public Product setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	
	private double price;
	public double getPrice() {
		return this.price;
	}
	public Product setPrice(double price) {
		this.price = price;
		return this;
	}
	
	private String active;
	public String getActive() {
		return this.active;
	}
	public Product setActive(String active) {
		this.active = active;
		return this;
	}
	
	public Product() {
		this.quantity = -1;
		this.lookupCode = "";
		this.id = new UUID(0, 0);
		this.createdOn = LocalDateTime.now();
		this.price = 1.00;
		this.active = "F";
	}
	
	public Product(ProductEntity productEntity) {
		this.id = productEntity.getId();
		this.quantity = productEntity.getQuantity();
		this.createdOn = productEntity.getCreatedOn();
		this.lookupCode = productEntity.getLookupCode();
		this.price = productEntity.getPrice();
		this.active = productEntity.getActive();
	}
}
