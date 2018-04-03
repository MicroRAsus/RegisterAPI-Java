package edu.uark.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.employee.EmployeeCountQuery;
import edu.uark.commands.employee.EmployeeLoginQuery;
import edu.uark.commands.employee.EmployeeCreateCommand;
import edu.uark.models.api.Employee;
import edu.uark.models.api.EmployeeCount;
import edu.uark.models.api.EmployeeLogin;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeRestController {
	@RequestMapping(value = "/EmployeeCount", method = RequestMethod.GET)  //2.4 task: check number of existing employee records - tested works
	public EmployeeCount getEmployeeCount() {
		return (new EmployeeCountQuery()).execute();
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public Employee verifyEmployeeLogin(@RequestBody EmployeeLogin employeeLoginINFO) { //2.3
		return (new EmployeeLoginQuery()).
				setEmployeeLogin(employeeLoginINFO).
				execute();
	}
	
	@RequestMapping(value = "/EmployeeCreate", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) {  //2.5 create employee endpoint
		return (new EmployeeCreateCommand()).
			setEmployee(employee).
			execute();
	}

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (EmployeeRestController)";
	}
}