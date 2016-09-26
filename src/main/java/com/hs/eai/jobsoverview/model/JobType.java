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
import javax.persistence.Transient;

import org.hibernate.search.annotations.DocumentId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Job_type")
@NamedQueries({
	@NamedQuery(name = "JobType.findAll", query = "SELECT j FROM JobType j")
	
})
public class JobType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5204916092936772401L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@DocumentId
	@Column(name="ID",columnDefinition="numeric")
	private Integer id;
	private String code;
	private String description;
	private int country_id;
	private boolean active;
	@Transient
	private Set<JobTypeDependancy> jobTypeDependanciesForJobTypeIdPrerequisite = new HashSet<JobTypeDependancy>(0);
	@Transient
	private Set<JobTypeDependancy> jobTypeDependanciesForJobTypeId = new HashSet<JobTypeDependancy>(0);
	@OneToMany
	@JoinColumn(name = "job_type_id")
	@JsonIgnore
	private Set<Job> jobs = new HashSet<Job>(0);
	@OneToMany
	@JoinColumn(name = "job_type_id")
	@JsonIgnore
	private Set<JobPart> jobParts = new HashSet<JobPart>(0);

	public JobType() {
	}

	public JobType(int id, String code, String description, int country_id, boolean active) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.country_id = country_id;
		this.active = active;
	}

	public JobType(int id, String code, String description, int country_id, boolean active,
			Set<JobTypeDependancy> jobTypeDependanciesForJobTypeIdPrerequisite,
			Set<JobTypeDependancy> jobTypeDependanciesForJobTypeId, Set<Job> jobs, Set<JobPart> jobParts) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.country_id = country_id;
		this.active = active;
		this.jobTypeDependanciesForJobTypeIdPrerequisite = jobTypeDependanciesForJobTypeIdPrerequisite;
		this.jobTypeDependanciesForJobTypeId = jobTypeDependanciesForJobTypeId;
		this.jobs = jobs;
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

	public int getCountryId() {
		return this.country_id;
	}
	
	public void setCountryId(int country_id) {
		this.country_id = country_id;
	}
	
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<JobTypeDependancy> getJobTypeDependanciesForJobTypeIdPrerequisite() {
		return this.jobTypeDependanciesForJobTypeIdPrerequisite;
	}

	public void setJobTypeDependanciesForJobTypeIdPrerequisite(
			Set<JobTypeDependancy> jobTypeDependanciesForJobTypeIdPrerequisite) {
		this.jobTypeDependanciesForJobTypeIdPrerequisite = jobTypeDependanciesForJobTypeIdPrerequisite;
	}

	public Set<JobTypeDependancy> getJobTypeDependanciesForJobTypeId() {
		return this.jobTypeDependanciesForJobTypeId;
	}

	public void setJobTypeDependanciesForJobTypeId(
			Set<JobTypeDependancy> jobTypeDependanciesForJobTypeId) {
		this.jobTypeDependanciesForJobTypeId = jobTypeDependanciesForJobTypeId;
	}

	public Set<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	public Set<JobPart> getJobParts() {
		return this.jobParts;
	}

	public void setJobParts(Set<JobPart> jobParts) {
		this.jobParts = jobParts;
	}

}
