package edu.uark.models.api;

import edu.uark.models.entities.TransactionEntity;

public class TransactionINFO {
	private int recordID;
	private double amount;
	private String transtype;
	
	public int getRecordID() {
		return this.recordID;
	}
	public TransactionINFO setRecordID(int recordID) {
		this.recordID = recordID;
		return this;
	}

	public double getAmount() {
		return this.amount;
	}
	public TransactionINFO setAmount(double amount) {
		this.amount = amount;
		return this;
	}

	public String getTransType() {
		return this.transtype;
	}
	public TransactionINFO setTransType(String transtype) {
		this.transtype = transtype;
		return this;
	}

	public TransactionINFO() {
		this.recordID = 0;
		this.amount = 0.0;
		this.transtype = "";
	}
	
	public TransactionINFO(TransactionEntity transactionEntity) {
		this.recordID = transactionEntity.getRecordID();
		this.amount = transactionEntity.getAmount();
		this.transtype = transactionEntity.getTransType();
	}
}