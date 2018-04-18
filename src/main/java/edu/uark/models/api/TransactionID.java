package edu.uark.models.api;

public class TransactionID {
	private int recordID;
	
	public int getRecordID() {
		return this.recordID;
	}
	public TransactionID setRecordID(int recordID) {
		this.recordID = recordID;
		return this;
	}

	public TransactionID() {
		this.recordID = 0;
	}
}