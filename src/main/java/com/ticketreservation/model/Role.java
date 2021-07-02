package com.ticketreservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class Role extends AbstractPrimaryKey {

	@Column(name = "name", length = 100, unique = true)
	private String name;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "app_user_id")
	private AppUser appUser;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	@PrePersist
	public void beforeCreated() {
		this.name = "ROLE_" + this.name;
	}

}
