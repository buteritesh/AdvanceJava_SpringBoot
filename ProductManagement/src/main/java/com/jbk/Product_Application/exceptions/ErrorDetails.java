package com.jbk.Product_Application.exceptions;

import java.util.Date;

public class ErrorDetails {
	
	private String errorMsg;
	private String errorDescription;
	private Date timestamp;
	public ErrorDetails(String errorMsg, String errorDescription, Date timestamp) {
		super();
		this.errorMsg = errorMsg;
		this.errorDescription = errorDescription;
		this.timestamp = timestamp;
	}
	
	
	
	public String getErrorMsg() {
		return errorMsg;
	}



	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}



	public String getErrorDescription() {
		return errorDescription;
	}



	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}



	public Date getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}



	@Override
	public String toString() {
		return "ErrorDetails [errorMsg=" + errorMsg + ", errorDescription=" + errorDescription + ", timestamp="
				+ timestamp + "]";
	}
	
	

}
