package com.course.app;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "topics")
public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int tid;
	private int cid;
	private String topic_name;
	private Timestamp topic_duration;

	@ManyToOne
	private Course course;
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	public Timestamp getTopic_duration() {
		return topic_duration;
	}

	public void setTopic_duration(Timestamp topic_duration) {
		this.topic_duration = topic_duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cid;
		result = prime * result + tid;
		result = prime * result + ((topic_duration == null) ? 0 : topic_duration.hashCode());
		result = prime * result + ((topic_name == null) ? 0 : topic_name.hashCode());
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
		Topic other = (Topic) obj;
		if (cid != other.cid)
			return false;
		if (tid != other.tid)
			return false;
		if (topic_duration == null) {
			if (other.topic_duration != null)
				return false;
		} else if (!topic_duration.equals(other.topic_duration))
			return false;
		if (topic_name == null) {
			if (other.topic_name != null)
				return false;
		} else if (!topic_name.equals(other.topic_name))
			return false;
		return true;
	}

}
