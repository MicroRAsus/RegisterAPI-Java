package edu.uark.commands.employee;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.models.api.EmployeeCount;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeCountQuery implements ResultCommandInterface<EmployeeCount> {
	private EmployeeRepositoryInterface employeeRepository;
	
	@Override
	public EmployeeCount execute() {
		EmployeeCount employeeCount = new EmployeeCount(this.employeeRepository.countEmployee());
		return employeeCount;
	}
	
	public EmployeeCountQuery() {
		this.employeeRepository = new EmployeeRepository();
	}
}