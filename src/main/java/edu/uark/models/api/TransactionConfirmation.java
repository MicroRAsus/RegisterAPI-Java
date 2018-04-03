package edu.uark.models.api;

import java.time.LocalDateTime;

public class TransactionConfirmation {
	private int recordID;
	private LocalDateTime createdOn;
	
	public int getRecordID() {
		return this.recordID;
	}
	public TransactionConfirmation setRecordID(int recordID) {
		this.recordID = recordID;
		return this;
	}
	
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public TransactionConfirmation setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	
	public TransactionConfirmation() {
		this.recordID = 0;
		this.createdOn = LocalDateTime.now();
	}
	
	public TransactionConfirmation(int recordID, LocalDateTime createdOn) {
		this.recordID = recordID;
		this.createdOn = createdOn;
	}
}
