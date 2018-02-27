package edu.uark.models.api;

public class EmployeeCount {
	private int employee_count;
	
	public int getEmployeeCount() {
		return this.employee_count;
	}
	public EmployeeCount setEmployeeCount(int employee_count) {
		this.employee_count = employee_count;
		return this;
	}
	
	public EmployeeCount() {
		this.employee_count = -1;
	}
	
	public EmployeeCount(int employee_count) {
		this.employee_count = employee_count;
	}
}
