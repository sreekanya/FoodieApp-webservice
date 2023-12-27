package com.Foodie.App.webservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDto {

	private String authToken;
	private String fullName;
	private int id;
	
	public AuthResponseDto() {}
	
	public AuthResponseDto(String authToken, String fullName, int id) {
		super();
		this.authToken = authToken;
		this.fullName = fullName;
		this.id = id;
	}
	
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AuthResponseDto [authToken=" + authToken + ", fullName=" + fullName + ", id=" + id + "]";
	}
	
	
}

