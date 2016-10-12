package kth.id2007.project.model;

/**
 * @author mg
 *
 */
public class BudgetIssueRequest {
	private int requestingDepartment;
	private long projectRefrenceId;
	private int amount;
	private String reason;
	
	/**
	 * @param requestingDepartment
	 * @param projectRefrenceId
	 * @param amount
	 * @param reason
	 */
	public BudgetIssueRequest(int requestingDepartment, long projectRefrenceId, int amount, String reason) {
		super();
		this.requestingDepartment = requestingDepartment;
		this.projectRefrenceId = projectRefrenceId;
		this.amount = amount;
		this.reason = reason;
	}
	
	/**
	 * @return
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
	 * @return
	 */
	public long getProjectRefrenceId() {
		return projectRefrenceId;
	}
	/**
	 * @param projectRefrenceId
	 */
	public void setProjectRefrenceId(long projectRefrenceId) {
		this.projectRefrenceId = projectRefrenceId;
	}
	/**
	 * @return
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
}
