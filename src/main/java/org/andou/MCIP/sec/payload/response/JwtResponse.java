package org.andou.MCIP.sec.payload.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String matricule;
	private String email;
	private List<String> roles;

	public JwtResponse(String accessToken, Long id, String matricule, String email, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.matricule = matricule;
		this.email = email;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return matricule;
	}

	public void setUsername(String username) {
		this.matricule = username;
	}

	public List<String> getRoles() {
		return roles;
	}

}
