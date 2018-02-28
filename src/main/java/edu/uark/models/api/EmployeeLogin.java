package edu.uark.models.api;

public class EmployeeLogin {
	private String employeeID;
	private String passWord;
	
	public String getEmployeeID() {
		return this.employeeID;
	}
	public EmployeeLogin setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
		return this;
	}
	
	public String getPassWord() {
		return this.passWord;
	}
	public EmployeeLogin setPassWord(String passWord) {
		this.passWord = passWord;
		return this;
	}
	
	public EmployeeLogin() {
		this.employeeID = "";
		this.passWord = "";
	}
	
	public EmployeeLogin(String employeeID, String passWord) {
		this.employeeID = employeeID;
		this.passWord = passWord;
	}
}
