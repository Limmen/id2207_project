package kth.id2007.project.model;

import java.util.Date;

/**
 * Class for holding information about a client
 * 
 * @author mg
 */
public class ClientRecord {
	private String clientName;
	private String clientEmail;
	private String clientPhoneNumber;
	private String history;
	private Date creationDate;
	
	/**
	 * Class constructor. Initializes a new ClientRecord
	 *
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
	 * getClientName
	 *
	 * @return name of the client
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * Updates the name of the client
	 *
	 * @param clientName new name of the client
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * getClientEmail
	 *
	 * @return email of the client
	 */
	public String getClientEmail() {
		return clientEmail;
	}

	/**
	 * Updates the email of the client
	 *
	 * @param clientEmail new email of the client
	 */
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	/**
	 * getClientPhoneNumber
	 *
	 * @return phone number of the client
	 */
	public String getClientPhoneNumber() {
		return clientPhoneNumber;
	}

	/**
	 * Updates the phone number of the client
	 *
	 * @param clientPhoneNumber new phone number of the client
	 */
	public void setClientPhoneNumber(String clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}

	/**
	 * getClientHistory
	 *
	 * @return client history
	 */
	public String getClientHistory() {
		return history;
	}

	/**
	 * Updates the history of the client
	 *
	 * @param history new history of the client
	 */
	public void setClientHistory(String history) {
		this.history = history;
	}

	/**
	 * getCreationDate
	 *
	 * @return creationDate of the client-record
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Updates the creationDate of the client
	 *
	 * @param creationDate new creationDate
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
}
