package com.course.app;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "user")
public class User {

	@Email(message = "Expecting email for user")
	@NotBlank(message = "Username should not be blank")
	private String user_name;
	@NotBlank(message = "password should not be blank")
	//@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])[a-zA-Z0-9!@#$%&*]{6,20})", message = "password should have one upper case, one lowercase one digit and one symbol")
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,10})", message="Password should have atleast 1 digit, 1 lowercase, 1 uppercase and with a min length of 6 and max length of 10")
	private String password;
	private LocalDateTime createdtime;
	private LocalDateTime updatedtime;
	@NotBlank(message = "firstname should not be blank")
	private String firstname;
	@NotBlank(message = "middlename should not be blank")
	private String middlename;
	@NotBlank(message = "lastname should not be blank")
	private String lastname;
	private int age;
	private String company;
	private String phonenumber;

//	public User(String user_name, String password, LocalDateTime createdtime, LocalDateTime updatedtime,
//			String firstname, String middlename, String lastname, int age, String company, String phonenumber) {
//		super();
//		this.user_name = user_name;
//		this.password = password;
//		this.createdtime = createdtime;
//		this.updatedtime = updatedtime;
//		this.firstname = firstname;
//		this.middlename = middlename;
//		this.lastname = lastname;
//		this.age = age;
//		this.company = company;
//		this.phonenumber = phonenumber;
//	}

	@JsonIgnore
	@ManyToMany(mappedBy = "users")
	private List<Course> courses=new ArrayList<>();
	
		public List<Course> getCourses() {
		return courses;
	}

		public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

		public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(LocalDateTime createdtime) {
		this.createdtime = createdtime;
	}

	public LocalDateTime getUpdatedtime() {
		return updatedtime;
	}

	public void setUpdatedtime(LocalDateTime updatedtime) {
		this.updatedtime = updatedtime;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [user_name=" + user_name + ", password=" + password + ", createdtime=" + createdtime
				+ ", updatedtime=" + updatedtime + ", firstname=" + firstname + ", middlename=" + middlename
				+ ", lastname=" + lastname + ", age=" + age + ", company=" + company + ", phonenumber=" + phonenumber
				+ ", courses=" + courses + "]";
	}

	
	}


