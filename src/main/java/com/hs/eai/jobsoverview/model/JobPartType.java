package com.hs.eai.jobsoverview.model;

// Generated 2-jul-2012 15:30:42 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.search.annotations.DocumentId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Job_part_type")
@NamedQueries({
	@NamedQuery(name = "JobPartType.findAll", query = "SELECT j FROM JobPartType j")
	
})

public class JobPartType implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@DocumentId
	@Column(name="ID",columnDefinition="numeric")
	private int id;
	private String code;
	private String description;
	private boolean active;
	@OneToMany
	@JoinColumn(name = "job_part_type_id")
	@JsonIgnore
	private Set<JobPart> jobParts = new HashSet<JobPart>(0);

	public JobPartType() {
	}

	public JobPartType(int id, String code, String description, boolean active) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.active = active;
	}

	public JobPartType(int id, String code, String description, boolean active,
			Set<JobPart> jobParts) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.active = active;
		this.jobParts = jobParts;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<JobPart> getJobParts() {
		return this.jobParts;
	}

	public void setJobParts(Set<JobPart> jobParts) {
		this.jobParts = jobParts;
	}

}
