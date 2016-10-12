package kth.id2007.project.model;

import java.util.ArrayList;

public class EventApplication {
	//public final int EVENT_TYPE_=1,
	private static long staticRefrenceCounter=0;
	private long projectRefrenceId;
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
	 * @param budget
	 * @param discount
	 * @param eventType
	 * @param preferences
	 * @param description
	 * @param from
	 * @param to
	 * @param expectedAttendees
	 * @param budgetComments
	 * @param status
	 * @param history
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
		projectRefrenceId=staticRefrenceCounter++;
		
	}
	
	public long getBudget() {
		return budget;
	}
	public void setBudget(long budget) {
		this.budget = budget;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getPreferences() {
		return preferences;
	}
	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getExpectedAttendees() {
		return expectedAttendees;
	}
	public void setExpectedAttendees(int expectedAttendees) {
		this.expectedAttendees = expectedAttendees;
	}

	public long getProjectRefrenceId() {
		return projectRefrenceId;
	}

	public ArrayList<SubTeamTask> getSubteamTasks() {
		return subteamTasks;
	}

	public void addSubteamTasks(SubTeamTask subteamTasks) {
		this.subteamTasks.add(subteamTasks);
	}


	public String getBudgetComments() {
		return budgetComments;
	}

	public void setBudgetComments(String budgetComments) {
		this.budgetComments = budgetComments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
}
