package com.Foodie.App.webservice.dto;

import java.util.Date;
import java.util.Optional;

import com.Foodie.App.webservice.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

	private String message;
	private Date timestamp = new Date();
	private String status;
	private Object data;

	public ResponseDto() {}

	public ResponseDto(String message, Date timestamp, String status, Object data) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.status = status;
		this.data = data;
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
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseDto [message=" + message + ", timestamp=" + timestamp + ", status=" + status + ", data="
				+ data + "]";
	}

	
	

	
	
	
	
}