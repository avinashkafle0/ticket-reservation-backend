package com.ticketreservation.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "app_user")
public class AppUser extends AbstractPrimaryKey {

	@NotEmpty
	@Column(name = "first_name", length = 100)
	private String firstName;

	@NotEmpty
	@Column(name = "last_name", length = 100)
	private String lastName;

	@Email
	@Column(name = "email")
	private String email;

	@Positive
	@Digits(integer = 15, fraction = 0)
	@Column(name = "phn_number", length = 15)
	private String phnNumber;

	@Column(name = "is_active")
	private boolean active = true;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "appUser")
	private Set<Role> roles;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhnNumber() {
		return phnNumber;
	}

	public void setPhnNumber(String phnNumber) {
		this.phnNumber = phnNumber;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
