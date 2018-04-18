package edu.uark.commands.transaction;

import org.apache.commons.lang3.StringUtils;
import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.InvalidCredentialException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Transaction;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;
import edu.uark.models.api.TransactionConfirmation;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.entities.TransactionEntity;
import edu.uark.models.repositories.EmployeeRepository;

public class TransactionCreateCommand implements ResultCommandInterface<TransactionConfirmation> {
	@Override
	public TransactionConfirmation execute() {
		if (!StringUtils.equals(this.transaction.getTransType(), "S") && !StringUtils.equals(this.transaction.getTransType(), "R"))
			throw new UnprocessableEntityException("Transaction type");
		
		if (StringUtils.isBlank(this.transaction.getCashierID())) {
			throw new UnprocessableEntityException("Cashier ID");
		}
		if (!employeeIDExist(this.transaction.getCashierID())) {
			throw new InvalidCredentialException("Cashier ID");
		}
		if (this.transaction.getReferenceID() > 0) { //check reference id in transaction table.
			if (this.transactionRepository.byRecordID(this.transaction.getReferenceID(), "RECORD_ID") == null) {
				throw new UnprocessableEntityException("Reference ID");
			}
		}
		
		//generate next record id using new created count on transaction. fill in record id, then save.
		//grab record id and created on and return them in confirmation class.
		int recordID = this.transactionRepository.countTransaction() + 1;
		TransactionEntity transactionEntity = new TransactionEntity(this.transaction);
		transactionEntity.setRecordID(recordID);
		transactionEntity.save();
		
		TransactionConfirmation transactionConfirmation = new TransactionConfirmation(recordID, transactionEntity.getCreatedOn());
		
		return transactionConfirmation;
	}
	
	private boolean employeeIDExist(String employeeID) {
		EmployeeEntity employeeEntity = (new EmployeeRepository()).byEmployeeID(employeeID);
		if (employeeEntity != null) {
			return true;
		}
		return false;
	}
	
	private Transaction transaction;
	public Transaction getTransaction() {
		return this.transaction;
	}
	public TransactionCreateCommand setTransaction(Transaction transaction) {
		this.transaction = transaction;
		return this;
	}
	
	private TransactionRepositoryInterface transactionRepository;
	public TransactionRepositoryInterface getTransactionRepository() {
		return this.transactionRepository;
	}
	public TransactionCreateCommand setTransactionRepository(TransactionRepositoryInterface transactionRepository) {
		this.transactionRepository = transactionRepository;
		return this;
	}
	
	public TransactionCreateCommand() {
		this.transactionRepository = new TransactionRepository();
	}
}
