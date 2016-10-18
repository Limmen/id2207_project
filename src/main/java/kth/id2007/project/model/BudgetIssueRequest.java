package kth.id2007.project.model;

/**
 * Class for holding information about budget issue.
 * 
 * 
 */
public class BudgetIssueRequest {
	private int requestingDepartment;
	private long projectReferenceId;
	private int amount;
	private String reason;
	
	/**
	 * @param requestingDepartment
	 * @param projectReferenceId
	 * @param amount
	 * @param reason
	 */
	public BudgetIssueRequest(int requestingDepartment, long projectReferenceId, int amount, String reason) {
		super();
		this.requestingDepartment = requestingDepartment;
		this.projectReferenceId = projectReferenceId;
		this.amount = amount;
		this.reason = reason;
	}
	
	/**
	 * @return The requesting department
	 */
	public int getRequestingDepartment() {
		return requestingDepartment;
	}
	/**
	 * @param requestingDepartment 
	 */
	public void setRequestingDepartment(int requestingDepartment) {
		this.requestingDepartment = requestingDepartment;
	}
	/**
	 * @return reference to the project
	 */
	public long getProjectReferenceId() {
		return projectReferenceId;
	}
	/**
	 * @param projectRefrenceId to be set
	 */
	public void setProjectRefrenceId(long projectRefrenceId) {
		this.projectReferenceId = projectRefrenceId;
	}
	/**
	 * @return the budget issue amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param the budget issue amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return reason of budget issue
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason of budget issue
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
}
