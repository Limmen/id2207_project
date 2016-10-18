package kth.id2007.project.model;

/**
 * Class representing a HrRequest
 *
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
	
	/** Returns the contract type
	 * @return contract type
	 */
	public int getContractType() {
		return contractType;
	}
	
	/**
	 * @param contractType to be set
	 */
	public void setContractType(int contractType) {
		this.contractType = contractType;
	}
	/**
	 * @return the requesting department
	 */
	public int getRequestingDepartment() {
		return requestingDepartment;
	}
	/** Sets the requesting department
	 * @param requestingDepartment
	 */
	public void setRequestingDepartment(int requestingDepartment) {
		this.requestingDepartment = requestingDepartment;
	}
	/** Get the title of the job
	 * @return the title
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	/** Sets job title
	 * @param jobTitle
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	/** returns the job description
	 * @return job description
	 */
	public String getJobDescription() {
		return jobDescription;
	}
	/** sets the job description
	 * @param jobDescription
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	/**
	 * @return a reference to the project
	 */
	public long getProjectReferenceId() {
		return projectReferenceId;
	}

	/**Sets the project reference id
	 * @param projectReferenceId
	 */
	public void setProjectReferenceId(long projectReferenceId) {
		this.projectReferenceId = projectReferenceId;
	}
}
