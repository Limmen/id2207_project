package kth.id2007.project.model;

/**
 * @author mg
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
	public long getProjectReferenceId() {
		return projectReferenceId;
	}
	/**
	 * @param projectRefrenceId
	 */
	public void setProjectRefrenceId(long projectRefrenceId) {
		this.projectReferenceId = projectRefrenceId;
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
