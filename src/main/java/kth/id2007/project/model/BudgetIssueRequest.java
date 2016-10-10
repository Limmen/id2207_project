package kth.id2007.project.model;

public class BudgetIssueRequest {
	private int requestingDepartment;
	private long projectRefrenceId;
	private int amount;
	private String reason;
	
	public BudgetIssueRequest(int requestingDepartment, long projectRefrenceId, int amount, String reason) {
		super();
		this.requestingDepartment = requestingDepartment;
		this.projectRefrenceId = projectRefrenceId;
		this.amount = amount;
		this.reason = reason;
	}
	
	public int getRequestingDepartment() {
		return requestingDepartment;
	}
	public void setRequestingDepartment(int requestingDepartment) {
		this.requestingDepartment = requestingDepartment;
	}
	public long getProjectRefrenceId() {
		return projectRefrenceId;
	}
	public void setProjectRefrenceId(long projectRefrenceId) {
		this.projectRefrenceId = projectRefrenceId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
}
