package com.web.exceptionhandling;

import java.util.Date;
import java.util.List;

/**
 * Error Details Class
 * 
 * @author Muhammad Tariq
 *
 */
public class ErrorDetails {

	private Date timestamp;
	private String message;
	private int totalErrors;
	private List<Object> details;

	public ErrorDetails(Date timestamp, String message, int totalErrors, List<Object> details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.totalErrors = totalErrors;
		this.details = details;
	}

	public int getTotalErrors() {
		return totalErrors;
	}

	public void setTotalErrors(int totalErrors) {
		this.totalErrors = totalErrors;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public List<Object> getDetails() {
		return details;
	}

	public void setDetails(List<Object> details) {
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
