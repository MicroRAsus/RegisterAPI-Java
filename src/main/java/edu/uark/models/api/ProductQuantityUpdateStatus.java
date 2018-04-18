package edu.uark.models.api;

public class ProductQuantityUpdateStatus {
	private boolean status;
	
	public boolean getStatus() {
		return this.status;
	}
	public ProductQuantityUpdateStatus setStatus(boolean status) {
		this.status = status;
		return this;
	}
	
	public ProductQuantityUpdateStatus() {
		this.status = false;
	}
	
	public ProductQuantityUpdateStatus(boolean status) {
		this.status = status;
	}
}