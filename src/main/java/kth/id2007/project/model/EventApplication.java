package kth.id2007.project.model;

import java.util.ArrayList;
import java.util.Date;

public class EventApplication {
	//public final int EVENT_TYPE_=1,
	private static long staticRefrenceCounter=0;
	private long projectRefrenceId;
	private long budget;
	private int discount = 0;
	private String eventType;
	private String preferences;
	private String description;
	private Date from,to;
	private int expectedAttendees;
	private ArrayList subteamTasks=new ArrayList<SubTeamTask>();
	
	/**
	 * @param budget
	 * @param discount
	 * @param eventType
	 * @param preferences
	 * @param description
	 * @param from
	 * @param to
	 * @param expectedAttendees
	 */
	public EventApplication(long budget, int discount, String eventType, String preferences, String description, Date from,
			Date to, int expectedAttendees) {
		super();
		this.budget = budget;
		this.discount = discount;
		this.eventType = eventType;
		this.preferences = preferences;
		this.description = description;
		this.from = from;
		this.to = to;
		this.expectedAttendees = expectedAttendees;
		projectRefrenceId=staticRefrenceCounter++;
		
	}
	
	/**
	 * @return
	 */
	public long getBudget() {
		return budget;
	}
	/**
	 * @param budget
	 */
	/**
	 * @param budget
	 */
	public void setBudget(long budget) {
		this.budget = budget;
	}
	/**
	 * @return
	 */
	public int getDiscount() {
		return discount;
	}
	/**
	 * @param discount
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	/**
	 * @return
	 */
	public String getEventType() {
		return eventType;
	}
	/**
	 * @param eventType
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	/**
	 * @return
	 */
	public String getPreferences() {
		return preferences;
	}
	/**
	 * @param preferences
	 */
	public void setPreferences(String preferences) {
		this.preferences = preferences;
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
	public Date getFrom() {
		return from;
	}
	/**
	 * @param from
	 */
	public void setFrom(Date from) {
		this.from = from;
	}
	/**
	 * @return
	 */
	public Date getTo() {
		return to;
	}
	/**
	 * @param to
	 */
	public void setTo(Date to) {
		this.to = to;
	}
	/**
	 * @return
	 */
	public int getExpectedAttendees() {
		return expectedAttendees;
	}
	/**
	 * @param expectedAttendees
	 */
	public void setExpectedAttendees(int expectedAttendees) {
		this.expectedAttendees = expectedAttendees;
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
	public ArrayList<SubTeamTask> getSubteamTasks() {
		return subteamTasks;
	}

	/**
	 * @param subteamTasks
	 */
	public void addSubteamTasks(SubTeamTask subteamTasks) {
		this.subteamTasks.add(subteamTasks);
	}


	
	
}
