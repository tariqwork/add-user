package com.web.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Model of user object
 * 
 * @author Muhammad Tariq
 *
 */
public class User {

	@NotNull
	@Size(min = 1, max = 50, message = "User name should not have more than 50 characters")
	private String username;

	@NotNull
	@Size(max = 50, message = "First name should not have more than 50 characters")
	private String firstname;

	@NotNull
	@Size(max = 50, message = "Last name should not have more than 50 characters")
	private String lastname;

	@NotNull
	@Positive(message = "Age should not have nagetive value or Zero")
	private int age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
