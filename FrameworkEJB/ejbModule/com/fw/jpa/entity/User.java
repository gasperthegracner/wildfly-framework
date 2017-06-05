package com.fw.jpa.entity;

import java.io.Serializable;
import java.lang.String;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.persistence.*;

import com.fw.ejb.security.Hashing;
import com.sun.istack.internal.NotNull;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@NamedQuery(name="User.getAll", query="SELECT s FROM User s")
public class User implements Serializable {
	   
	@Id 
	@NotNull
	private String id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private String role;
	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
		this.id = UUID.randomUUID().toString();
	}   
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		try {
			this.password = Hashing.hashSHA256(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
   
}
