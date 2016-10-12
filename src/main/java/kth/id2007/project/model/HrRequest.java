package kth.id2007.project.model;

public class HrRequest {
	private int contractType;
	private int requestingDepartment;
	private String jobTitle;
	private String jobDescription;
	private long projectReferenceId;
	
	public final static String JOB_TYPES[]={"Part time","Full time","Intern"};
	
		
	public int getContractType() {
		return contractType;
	}
	public HrRequest(long projectReferenceId, int contractType, int requestingDepartment, String jobTitle, String jobDescription) {
		this.projectReferenceId = projectReferenceId;
		this.contractType = contractType;
		this.requestingDepartment = requestingDepartment;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
	}
	
	public void setContractType(int contractType) {
		this.contractType = contractType;
	}
	public int getRequestingDepartment() {
		return requestingDepartment;
	}
	public void setRequestingDepartment(int requestingDepartment) {
		this.requestingDepartment = requestingDepartment;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
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
