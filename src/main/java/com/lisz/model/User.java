package com.lisz.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
	private Integer id;
	private String name;
	private String job;
	private Date birthDate;
	private byte[] profile;
	private String email;
	private Double score;
	private Date createdAt;
	private Date modifiedAt;
	private Long version = 0L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public byte[] getProfile() {
		return profile;
	}

	public void setProfile(byte[] profile) {
		this.profile = profile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", job='" + job + '\'' +
				", birthDate=" + birthDate +
				", profile=" + Arrays.toString(profile) +
				", email='" + email + '\'' +
				", score=" + score +
				", createdAt=" + createdAt +
				", modifiedAt=" + modifiedAt +
				", version=" + version +
				'}';
	}
}
