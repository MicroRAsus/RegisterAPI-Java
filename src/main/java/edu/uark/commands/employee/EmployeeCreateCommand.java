package edu.uark.commands.employee;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import java.util.Random;
import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.ConflictException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeCreateCommand implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		if (StringUtils.isBlank(this.employee.getEmployeeID())) {
			throw new UnprocessableEntityException("Employee ID");
		}
		if (employeeIDExist(this.employee.getEmployeeID())) {
			throw new ConflictException("Employee ID " + this.employee.getEmployeeID());
		}
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
		EmployeeEntity employeeEntity = this.employeeRepository.byEmployeeID(employeeID);
		if (employeeEntity != null) {
			return true;
		}
		return false;
	}
	
	private Employee employee;
	public Employee getEmployee() {
		return this.employee;
	}
	public EmployeeCreateCommand setEmployee(Employee employee) {
		this.employee = employee;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeCreateCommand setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeCreateCommand() {
		this.employeeRepository = new EmployeeRepository();
	}
}
