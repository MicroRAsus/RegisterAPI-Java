package edu.uark.commands.employee;

import org.apache.commons.codec.digest.DigestUtils;
import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.PassWordNotMatchException;
import edu.uark.models.api.Employee;
import edu.uark.models.api.EmployeeLogin;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeLoginQuery implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		EmployeeEntity employeeEntity = this.employeeRepository.byEmployeeID(this.employeeLoginINFO.getEmployeeID());
		if (employeeEntity != null) {
			if(employeeEntity.getPassWord().equals(DigestUtils.sha1Hex(this.employeeLoginINFO.getPassWord()))) {
				return new Employee(employeeEntity);
			}
			else {
				throw new PassWordNotMatchException("Password" + DigestUtils.sha1Hex(this.employeeLoginINFO.getPassWord()));
			}
		} else {
			throw new NotFoundException("Employee ID " + this.employeeLoginINFO.getEmployeeID());
		}
	}

	private EmployeeLogin employeeLoginINFO;
	public EmployeeLogin getEmployeeLogin() {
		return this.employeeLoginINFO;
	}
	public EmployeeLoginQuery setEmployeeLogin(EmployeeLogin employeeLoginINFO) {
		this.employeeLoginINFO = employeeLoginINFO;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeLoginQuery setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeLoginQuery() {
		this.employeeRepository = new EmployeeRepository();
	}
}