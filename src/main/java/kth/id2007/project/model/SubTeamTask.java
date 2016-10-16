package kth.id2007.project.model;

/**
 * Class representing a SubTeamTask
 */
public class SubTeamTask {
	private long projectReferenceId;
	private String description;
	private String assignedTo;
	private int priority;

    /**
     * Class constructor. Initializes class attributes.
     *
     * @param projectReferenceId projectReferenceId of the SubTeamTask
     * @param description description of the SubTeamTask
     * @param assignedTo person/team that the task is assigned to
     * @param priority priority of the task
     */
	public SubTeamTask(long projectReferenceId, String description, String assignedTo, int priority) {
		this.projectReferenceId = projectReferenceId;
		this.description = description;
		this.assignedTo = assignedTo;
		this.priority = priority;
	}

    /**
     * getProjectReferenceId
     *
     * @return projectReferenceId of the task
     */
	public long getProjectReferenceId() {
		return projectReferenceId;
	}

	/**
     * getDescription
     *
	 * @return description of the task
	 */
	public String getDescription() {
		return description;
	}

	/**
     * Updates the description of the task
     *
	 * @param description new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
     * getAssignedTo
     *
	 * @return person/team that the task is assigned to
	 */
	public String getAssignedTo() {
		return assignedTo;
	}

	/**
     * Updates the person/team that the task is assigned to
     *
	 * @param assignedTo new person/team to assign the task to
	 */
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	/**
     * getPriority
     *
	 * @return priority of the task
	 */
	public int getPriority() {
		return priority;
	}

	/**
     * Updates the priority of the task
     *
	 * @param priority new priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
}
