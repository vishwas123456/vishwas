package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenerationTime;

@Entity
public class Authorities {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int authoritiesid;
	private String username;
	private String authority;
	public int getAuthorityid() {
		return authoritiesid;
	}
	public void setAuthorityid(int authorityid) {
		this.authoritiesid = authorityid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
