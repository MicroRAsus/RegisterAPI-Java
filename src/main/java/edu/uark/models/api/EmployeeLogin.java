package edu.uark.models.api;

public class EmployeeLogin {
	private String employeeID;
	private String password;
	
	public String getEmployeeID() {
		return this.employeeID;
	}
	public EmployeeLogin setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
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
		this.employeeID = "";
		this.password = "";
	}
	
	public EmployeeLogin(String employeeID, String password) {
		this.employeeID = employeeID;
		this.password = password;
	}
}
