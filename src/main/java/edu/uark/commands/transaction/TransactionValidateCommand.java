package edu.uark.commands.transaction;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;
import edu.uark.models.api.TransactionINFO;
import edu.uark.models.entities.TransactionEntity;

public class TransactionValidateCommand implements ResultCommandInterface<TransactionINFO> {
	@Override
	public TransactionINFO execute() {
		TransactionEntity transactionEntity;
		if ((transactionEntity = this.transactionRepository.byRecordID(this.transactionID, "RECORD_ID")) != null && this.transactionRepository.byRecordID(this.transactionID, "REFERENCE_ID") == null) {
			return new TransactionINFO(transactionEntity); //if transaction id is found in record id column (transaction exists) but not in reference id column (not returned), return the transaction info for client to proceed the return.
		}
		
		return new TransactionINFO(); //return transaction info with transaction id = 0 for invalid transaction id.
	}
	
	private int transactionID;
	public int getTransactionID() {
		return this.transactionID;
	}
	public TransactionValidateCommand setTransactionID(int transactionID) {
		this.transactionID = transactionID;
		return this;
	}
	
	private TransactionRepositoryInterface transactionRepository;
	public TransactionRepositoryInterface getTransactionRepository() {
		return this.transactionRepository;
	}
	public TransactionValidateCommand setTransactionRepository(TransactionRepositoryInterface transactionRepository) {
		this.transactionRepository = transactionRepository;
		return this;
	}
	
	public TransactionValidateCommand() {
		this.transactionRepository = new TransactionRepository();
	}
}
