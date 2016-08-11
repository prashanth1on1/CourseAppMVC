package com.course.app;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "course")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courseid;
	private String cname;
	private String cdescription;
	private LocalDateTime createdtime;
	private LocalDateTime updatedtime;
	private String author;

//	public Course(int courseid, String cname, String cdescription, LocalDateTime createdtime,
//			LocalDateTime updatedtime, String author) {
//		super();
//		this.courseid = courseid;
//		this.cname = cname;
//		this.cdescription = cdescription;
//		this.createdtime = createdtime;
//		this.updatedtime = updatedtime;
//		this.author = author;
//	}
//	
	public enum Skilllevel
	{
		BEGINEER,INTERMEDIATE,ADVANCED;
	}
	
	@Enumerated(javax.persistence.EnumType.STRING)
	private Skilllevel skilllevel;
	
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "user_course", joinColumns = @JoinColumn(name = "user_name", referencedColumnName = "user_name"), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "cid"))
	private List<User> users= new ArrayList<>();

	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL, mappedBy = "course")
	private List<Topic>topics= new ArrayList<>();

	public Long getCourseid() {
		return courseid;
	}

	public Skilllevel getSkilllevel() {
		return skilllevel;
	}

	public void setSkilllevel(Skilllevel skilllevel) {
		this.skilllevel = skilllevel;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public void setCourseid(Long courseid) {
		this.courseid = courseid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCdescription() {
		return cdescription;
	}

	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}

	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
		result = prime * result + ((courseid == null) ? 0 : courseid.hashCode());
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
		Course other = (Course) obj;
		if (courseid == null) {
			if (other.courseid != null)
				return false;
		} else if (!courseid.equals(other.courseid))
			return false;
		return true;
	}

	
	
}
