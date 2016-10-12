package kth.id2007.project.model;

public class SubTeamTask {
	private long projectRefrenceId;
	private String description;
	private String assignedTo;
	private int priority;
	
	/**
	 * @param projectRefrenceId
	 * @param description
	 * @param assignedTo
	 * @param priority
	 */
	public SubTeamTask(long projectRefrenceId, String description, String assignedTo, int priority) {
		super();
		this.projectRefrenceId = projectRefrenceId;
		this.description = description;
		this.assignedTo = assignedTo;
		this.priority = priority;
	}

	/**
	 * @return
	 */
	public long getProjectRefrenceId() {
		return projectRefrenceId;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return
	 */
	public String getAssignedTo() {
		return assignedTo;
	}

	/**
	 * @param assignedTo
	 */
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	/**
	 * @return
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
}
