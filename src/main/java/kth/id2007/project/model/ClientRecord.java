package kth.id2007.project.model;

import java.util.Date;

public class ClientRecord {
	private String clientName;
	private String clientEmail;
	private String clientPhoneNumber;
	private String history;
	private Date creationDate;
	public ClientRecord(String clientName, String clientEmail, String clientPhoneNumber, String history) {
		super();
		this.clientName = clientName;
		this.clientEmail = clientEmail;
		this.clientPhoneNumber = clientPhoneNumber;
		this.history = history;
		this.creationDate = new Date();
	}
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getClientPhoneNumber() {
		return clientPhoneNumber;
	}
	public void setClientPhoneNumber(String clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}
	public String getClientHistory() {
		return history;
	}
	public void setClientHistory(String history) {
		this.history = history;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
}
