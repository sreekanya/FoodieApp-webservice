package com.Foodie.App.webservice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDto {

	private String message;
	private Date timestamp = new Date();
	private String status;
	private String error;
	
	public ExceptionResponseDto() {}
	
	public ExceptionResponseDto(String message, Date timestamp, String status, String error) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ExceptionResponseDto [message=" + message + ", timestamp=" + timestamp + ", status=" + status
				+ ", error=" + error + "]";
	}
	
}

