package edu.msstudio.pys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    private Long id;
	
	@Column(name="username",nullable=false)
	private String username;
	
	@Column(name = "password", nullable = false)
    @JsonIgnore
    private String userPass;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
}
