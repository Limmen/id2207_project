package kth.id2007.project.model;

import java.util.ArrayList;

/**
 * Class representing an event application in the system
 */
public class EventApplication {
	//public final int EVENT_TYPE_=1,
	public static long staticReferenceCounter =0;
	private long projectReferenceId;
	private long budget;
	private int discount = 0;
	private String eventType;
	private String preferences;
	private String description;
	private String from,to;
	private int expectedAttendees;
	private ArrayList subteamTasks=new ArrayList<SubTeamTask>();
	private String budgetComments;
	private String status;
	private String history;
	private boolean approved = false;
	
	/**
     * Class constructor. Initializes class attributes.
     *
	 * @param budget budget of the event application
	 * @param discount discount of the event application
	 * @param eventType event-type of the event application
	 * @param preferences preferences of the event application
	 * @param description description of the event application
	 * @param from date where the event of the application starts
	 * @param to date where the event of the application ends
	 * @param expectedAttendees expected number of attendees of the event.
	 * @param budgetComments budget-comments of the event application
	 * @param status status of the event application
	 * @param history history of the event application
	 */
	public EventApplication(long budget, int discount, String eventType, String preferences, String description, String from,
							String to, int expectedAttendees, String budgetComments, String status, String history) {
		super();
		this.budget = budget;
		this.discount = discount;
		this.eventType = eventType;
		this.preferences = preferences;
		this.description = description;
		this.from = from;
		this.to = to;
		this.expectedAttendees = expectedAttendees;
		this.budgetComments = budgetComments;
		this.status = status;
		this.history = history;
		projectReferenceId = staticReferenceCounter++;
		
	}
	
	/**
     * getBudget
     *
	 * @return budget
	 */
	public long getBudget() {
		return budget;
	}

	/**
     * Updates the budget of the event applicaton
     *
	 * @param budget new budget
	 */
	public void setBudget(long budget) {
		this.budget = budget;
	}

	/**
     * getDiscount
     *
	 * @return discount
	 */
	public int getDiscount() {
		return discount;
	}

	/**
     * Updates the discount of the event appliction
     *
	 * @param discount new discount
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	/**
     * getEventType
     *
	 * @return eventType
	 */
	public String getEventType() {
		return eventType;
	}

	/**
     * Updates event type of the event
     *
	 * @param eventType new event-type
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
     * getPreferences
     *
	 * @return preferences
	 */
	public String getPreferences() {
		return preferences;
	}

	/**
     * Updates the preferences of the event application
     *
	 * @param preferences preferences
	 */
	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	/**
     * getDescription
     *
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
     * Updates description of the event application
     *
	 * @param description new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

    /**
     * getFrom
     *
     * @return from-date
     */
	public String getFrom() {
		return from;
	}

    /**
     * Updates date from where the event starts
     *
     * @param from new from-date
     */
	public void setFrom(String from) {
		this.from = from;
	}

    /**
     * getTo
     *
     * @return to-date
     */
	public String getTo() {
		return to;
	}

    /**
     * Updates date where the event ends
     *
     * @param to new to-date
     */
	public void setTo(String to) {
		this.to = to;
	}

	/**
     * getExpectedAttendees
     *
	 * @return expectedAttendees
	 */
	public int getExpectedAttendees() {
		return expectedAttendees;
	}

    /**
     * Updates the expected attendees for the event
     *
     * @param expectedAttendees new number of expected attendees
     */
	public void setExpectedAttendees(int expectedAttendees) {
		this.expectedAttendees = expectedAttendees;
	}

	/**
     * getProjectReferenceId
     *
	 * @return projectReferenceId
	 */
	public long getProjectReferenceId() {
		return projectReferenceId;
	}

	/**
     * getSubTeamTasks
     *
	 * @return list of subteam-tasks
	 */
	public ArrayList<SubTeamTask> getSubteamTasks() {
		return subteamTasks;
	}

	/**
     * Adds a subteam-task to the event
     *
	 * @param subteamTasks subteam-task to add
	 */
	public void addSubteamTasks(SubTeamTask subteamTasks) {
		this.subteamTasks.add(subteamTasks);
	}

    /**
     * getBudgetComments
     *
     * @return budget-comments of the event
     */
	public String getBudgetComments() {
		return budgetComments;
	}

    /**
     * Updates budgetCommens of the event
     *
     * @param budgetComments new budgetComments
     */
	public void setBudgetComments(String budgetComments) {
		this.budgetComments = budgetComments;
	}

    /**
     * getStatus
     *
     * @return status
     */
	public String getStatus() {
		return status;
	}

    /**
     * Updates status of the event
     *
     * @param status new status of the event
     */
	public void setStatus(String status) {
		this.status = status;
	}

    /**
     * getHistory
     *
     * @return history
     */
	public String getHistory() {
		return history;
	}

    /**
     * Updates the history of the event
     *
     * @param history new history
     */
	public void setHistory(String history) {
		this.history = history;
	}

    /**
     * Checks wether the application have been approved by the AdministrationManager or not
     *
     * @return boolean approved
     */
	public boolean isApproved() {
		return approved;
	}

    /**
     * Approves or disapproves the application
     *
     * @param approved
     */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
}
