package kth.id2007.project.model;

import java.util.Date;

/**Class for holding information about a client
 * 
 * @author mg
 *
 */
public class ClientRecord {
	private String clientName;
	private String clientEmail;
	private String clientPhoneNumber;
	private String history;
	private Date creationDate;
	
	/**Creates a client
	 * @param clientName
	 * @param clientEmail
	 * @param clientPhoneNumber
	 * @param history
	 */
	public ClientRecord(String clientName, String clientEmail, String clientPhoneNumber, String history) {
		super();
		this.clientName = clientName;
		this.clientEmail = clientEmail;
		this.clientPhoneNumber = clientPhoneNumber;
		this.history = history;
		this.creationDate = new Date();
	}
	
	/**
	 * @return
	 */
	public String getClientName() {
		return clientName;
	}
	/**
	 * @param clientName
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	/**
	 * @return
	 */
	public String getClientEmail() {
		return clientEmail;
	}
	/**
	 * @param clientEmail
	 */
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	/**
	 * @return
	 */
	public String getClientPhoneNumber() {
		return clientPhoneNumber;
	}
	/**
	 * @param clientPhoneNumber
	 */
	public void setClientPhoneNumber(String clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}
	/**
	 * @return
	 */
	public String getClientHistory() {
		return history;
	}
	/**
	 * @param history
	 */
	public void setClientHistory(String history) {
		this.history = history;
	}
	/**
	 * @return
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
}
