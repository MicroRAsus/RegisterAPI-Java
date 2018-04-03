package edu.uark.commands.transaction;

import org.apache.commons.lang3.StringUtils;

//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.codec.digest.DigestUtils;
//import java.util.Random;
import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.InvalidCredentialException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Transaction;
import edu.uark.models.repositories.TransactionRepository;
import edu.uark.models.repositories.interfaces.TransactionRepositoryInterface;
import edu.uark.models.api.TransactionConfirmation;
import edu.uark.models.entities.EmployeeEntity;
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
		if (this.transaction.getReferenceID() > 0)
			//check reference id in transaction table.
			
		//generate next record id using new created count on transaction. fill in record id, then save.
		//grab record id and created on and return them in confirmation class.
		
		if (!StringUtils.isNumeric(this.employee.getEmployeeID())) {
			Random rand = new Random();
			int newEmployeeID = rand.nextInt(10000);
			while (employeeIDExist(Integer.toString(newEmployeeID))) {
				newEmployeeID = rand.nextInt(10000);
			}
			this.employee.setEmployeeID(Integer.toString(newEmployeeID));
		}
		
		EmployeeEntity employeeEntity = new EmployeeEntity(employee);
		employeeEntity.setPassWord(DigestUtils.sha1Hex(employeeEntity.getPassWord()));
		employeeEntity.save();
		
		this.employee.setId(employeeEntity.getId());
		this.employee.setCreatedOn(employeeEntity.getCreatedOn());

		return this.employee;
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
	
	public EmployeeCreateCommand() {
		this.employeeRepository = new EmployeeRepository();
	}
}
