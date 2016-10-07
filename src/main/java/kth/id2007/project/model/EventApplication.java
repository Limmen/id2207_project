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
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
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


	
	
}
