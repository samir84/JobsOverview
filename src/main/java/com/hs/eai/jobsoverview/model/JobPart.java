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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.search.annotations.DocumentId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Job_part")
@NamedQueries({
	@NamedQuery(name = "JobPart.findAll", query = "SELECT j FROM JobPart j")
	
})
public class JobPart implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5204916092936772401L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@DocumentId
	@Column(name="ID",columnDefinition="numeric")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "job_type_id" ,nullable=false)
	private JobType jobType;
	@ManyToOne
	@JoinColumn(name = "job_part_type_id" ,nullable=false)
	private JobPartType jobPartType;
	@Column(name = "next_job_part_id")
	private Integer nextJobPartId;
	private String description;
	private boolean active;
	@Transient
	private Set<JobPartMonitor> jobPartMonitors = new HashSet<JobPartMonitor>(0);
	@OneToMany
	@JoinColumn(name = "job_part_id")
	@JsonIgnore
	private Set<XrefJobPartStatusJob> xrefJobPartStatusJobs = new HashSet<XrefJobPartStatusJob>(0);

	public JobPart() {
	}

	public JobPart(int id, JobType jobType,
			JobPartType jobPartType, String description, boolean active) {
		this.id = id;
		this.jobType = jobType;
		this.jobPartType = jobPartType;
		this.description = description;
		this.active = active;
	}

	public JobPart(int id, JobType jobType,
			JobPartType jobPartType, Integer nextJobPartId,
			String description, boolean active, Set<JobPartMonitor> jobPartMonitors,
			Set<XrefJobPartStatusJob> xrefJobPartStatusJobs) {
		this.id = id;
		this.jobType = jobType;
		this.jobPartType = jobPartType;
		this.nextJobPartId = nextJobPartId;
		this.description = description;
		this.active = active;
		this.jobPartMonitors = jobPartMonitors;
		this.xrefJobPartStatusJobs = xrefJobPartStatusJobs;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JobType getJobType() {
		return this.jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public JobPartType getJobPartType() {
		return this.jobPartType;
	}

	public void setJobPartType(JobPartType jobPartType) {
		this.jobPartType = jobPartType;
	}

	public Integer getNextJobPartId() {
		return this.nextJobPartId;
	}

	public void setNextJobPartId(Integer nextJobPartId) {
		this.nextJobPartId = nextJobPartId;
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

	public Set<JobPartMonitor> getJobPartMonitors() {
		return this.jobPartMonitors;
	}

	public void setJobPartMonitors(Set<JobPartMonitor> jobPartMonitors) {
		this.jobPartMonitors = jobPartMonitors;
	}

	public Set<XrefJobPartStatusJob> getXrefJobPartStatusJobs() {
		return this.xrefJobPartStatusJobs;
	}

	public void setXrefJobPartStatusJobs(Set<XrefJobPartStatusJob> xrefJobPartStatusJobs) {
		this.xrefJobPartStatusJobs = xrefJobPartStatusJobs;
	}

}
