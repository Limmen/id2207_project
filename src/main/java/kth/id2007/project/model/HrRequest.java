package kth.id2007.project.model;

/**
 * @author mg
 *
 */
public class HrRequest {
	private int contractType;
	private int requestingDepartment;
	private String jobTitle;
	private String jobDescription;
	private long projectReferenceId;
	
	public final static String JOB_TYPES[]={"Part time","Full time","Intern"};
	

	public HrRequest(long projectReferenceId, int contractType, int requestingDepartment, String jobTitle, String jobDescription) {
		this.projectReferenceId = projectReferenceId;
		this.contractType = contractType;
		this.requestingDepartment = requestingDepartment;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
	}
	
	/**
	 * @return
	 */
	public int getContractType() {
		return contractType;
	}
	
	/**
	 * @param contractType
	 */
	public void setContractType(int contractType) {
		this.contractType = contractType;
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
	public String getJobTitle() {
		return jobTitle;
	}
	/**
	 * @param jobTitle
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	/**
	 * @return
	 */
	public String getJobDescription() {
		return jobDescription;
	}
	/**
	 * @param jobDescription
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public long getProjectReferenceId() {
		return projectReferenceId;
	}

	public void setProjectReferenceId(long projectReferenceId) {
		this.projectReferenceId = projectReferenceId;
	}
}
