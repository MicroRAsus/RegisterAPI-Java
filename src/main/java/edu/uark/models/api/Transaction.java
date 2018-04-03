package edu.uark.models.api;

import edu.uark.models.entities.TransactionEntity;

public class Transaction {
	private String cashierid;
	private double amount;
	private String transtype;
	private int referenceid;
	
	public String getCashierID() {
		return this.cashierid;
	}
	public Transaction setCashierID(String cashierid) {
		this.cashierid = cashierid;
		return this;
	}

	public double getAmount() {
		return this.amount;
	}
	public Transaction setAmount(double amount) {
		this.amount = amount;
		return this;
	}

	public String getTransType() {
		return this.transtype;
	}
	public Transaction setTransType(String transtype) {
		this.transtype = transtype;
		return this;
	}

	public int getReferenceID() {
		return this.referenceid;
	}
	public Transaction setReferenceID(int referenceid) {
		this.referenceid = referenceid;
		return this;
	}

	public Transaction() {
		this.cashierid = "";
		this.amount = 0.0;
		this.transtype = "";
		this.referenceid = 0;
	}

	public Transaction(TransactionEntity transactionEntity) { //Copy constructor
		this.cashierid = transactionEntity.getCashierID();
		this.amount = transactionEntity.getAmount();
		this.transtype = transactionEntity.getTransType();
		this.referenceid = transactionEntity.getReferenceID();
	}
}