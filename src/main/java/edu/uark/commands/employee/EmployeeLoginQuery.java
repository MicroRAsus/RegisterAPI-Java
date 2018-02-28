package edu.uark.commands.employee;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.controllers.exceptions.PassWordNotMatchException;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeLoginQuery implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		if (StringUtils.isBlank(this.employee_id)) {
			throw new UnprocessableEntityException("employee_id");
		}
		
		EmployeeEntity employeeEntity = this.employeeRepository.byEmployeeID(this.employee_id);
		if (employeeEntity != null) {
			if(employeeEntity.getPassWord() == this.password) {  //TODO this.password need to be hashed here
				return new Employee(employeeEntity);
			}
			else {
				throw new PassWordNotMatchException("Password");
			}
		} else {
			throw new NotFoundException("Employee ID " + this.employee_id);
		}
	}

	private String employee_id;
	public String getEmployeeID() {
		return this.employee_id;
	}
	public EmployeeLoginQuery setEmployeeID(String employee_id) {
		this.employee_id = employee_id;
		return this;
	}
	
	private String password;
	public String getPassWord() {
		return this.password;
	}
	public EmployeeLoginQuery setPassWord(String password) {
		this.password = password;
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