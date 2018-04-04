package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;

public class TransactionEntity extends BaseEntity<TransactionEntity> {
	private int recordid;
	private String cashierid;
	private double amount;
	private String transtype;
	private int referenceid;

	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.recordid = rs.getInt(TransactionFieldNames.RECORD_ID);
		this.cashierid = rs.getString(TransactionFieldNames.CASHIER_ID);
		this.amount = rs.getDouble(TransactionFieldNames.AMOUNT);
		this.transtype = rs.getString(TransactionFieldNames.TRANS_TYPE);
		this.referenceid = rs.getInt(TransactionFieldNames.REFERENCE_ID);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TransactionFieldNames.RECORD_ID, this.recordid);
		record.put(TransactionFieldNames.CASHIER_ID, this.cashierid);
		record.put(TransactionFieldNames.AMOUNT, this.amount);
		record.put(TransactionFieldNames.TRANS_TYPE, this.transtype);
		if (this.referenceid > 0) {   //transactions cannot be less than 1, 0 and below are reserved for null value, which means this transaction record is a sell, so no reference id is provided.
			record.put(TransactionFieldNames.REFERENCE_ID, this.referenceid);
		}
		
		return record;
	}

	public int getRecordID() {
		return this.recordid;
	}
	public String getCashierID() {
		return this.cashierid;
	}
	public double getAmount() {
		return this.amount;
	}
	public String getTransType() {
		return this.transtype;
	}
	public int getReferenceID() {
		return this.referenceid;
	}
	
	public TransactionEntity setRecordID(int recordid) {
		if (recordid != this.recordid) {
			this.recordid = recordid;
			this.propertyChanged(TransactionFieldNames.RECORD_ID);
		}
		
		return this;
	}
	
	public TransactionEntity setCashierID(String cashierid) {
		if (!StringUtils.equals(this.cashierid, cashierid)) {
			this.cashierid = cashierid;
			this.propertyChanged(TransactionFieldNames.CASHIER_ID);
		}
		
		return this;
	}
	
	public TransactionEntity setAmount(double amount) {
		if (this.amount != amount) {
			this.amount = amount;
			this.propertyChanged(TransactionFieldNames.AMOUNT);
		}
		
		return this;
	}
	
	public TransactionEntity setTransType(String transtype) {
		if (!StringUtils.equals(this.transtype, transtype)) {
			this.transtype = transtype;
			this.propertyChanged(TransactionFieldNames.TRANS_TYPE);
		}
		
		return this;
	}
	
	public TransactionEntity setReferenceID(int referenceid) {
		if (this.referenceid != referenceid) {
			this.referenceid = referenceid;
			this.propertyChanged(TransactionFieldNames.REFERENCE_ID);
		}
		
		return this;
	}
	
	public Transaction synchronize(Transaction apiTransaction) {
		this.setCashierID(apiTransaction.getCashierID());
		this.setAmount(apiTransaction.getAmount());
		this.setTransType(apiTransaction.getTransType());
		this.setReferenceID(apiTransaction.getReferenceID());

		return apiTransaction;
	}
	
	public TransactionEntity() {
		super(DatabaseTable.TRANSACTION);
		
		this.recordid = 0;
		this.cashierid = StringUtils.EMPTY;
		this.amount = 0.0;
		this.transtype= StringUtils.EMPTY;
		this.referenceid = 0;
	}
	
	public TransactionEntity(Transaction apiTransaction) {
		super(DatabaseTable.TRANSACTION);
		
		this.recordid = 0;
		this.cashierid = apiTransaction.getCashierID();
		this.amount = apiTransaction.getAmount();
		this.transtype = apiTransaction.getTransType();
		this.referenceid = apiTransaction.getReferenceID();
	}
}