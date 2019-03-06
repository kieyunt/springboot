package com.ky.springboot.studentservice.exception;

import java.util.Date;

public class ErrorDetails {

	private Date timestamp;
	private String message;
	private String details;
	private String zone;
	
	public ErrorDetails(Date timestamp, String message, String details, String zone) {
		super();
		this.setTimestamp(timestamp);
		this.setMessage(message);
		this.setDetails(details);
		this.setZone(zone);
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
}
