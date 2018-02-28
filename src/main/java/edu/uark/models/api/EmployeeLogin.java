package edu.uark.models.api;

public class EmployeeLogin {
	private String employee_id;
	private String password;
	
	public String getEmployeeID() {
		return this.employee_id;
	}
	public EmployeeLogin setEmployeeID(String employee_id) {
		this.employee_id = employee_id;
		return this;
	}
	
	public String getPassWord() {
		return this.password;
	}
	public EmployeeLogin setPassWord(String password) {
		this.password = password;
		return this;
	}
	
	public EmployeeLogin() {
		this.employee_id = "";
		this.password = "";
	}
	
	public EmployeeLogin(String employee_id, String password) {
		this.employee_id = employee_id;
		this.password = password;
	}
}
