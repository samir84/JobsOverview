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

import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Job_status")
@NamedQueries({
	@NamedQuery(name = "JobStatus.findAll", query = "SELECT j FROM JobStatus j")
	
})
//@Indexed  
public class JobStatus implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5204916092936772401L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@DocumentId
	@Column(name="ID",columnDefinition="numeric")
	private Integer id;
	@Transient
	private Color color;
	//@Field
	private String description;
	//@Field
	private String code;
	private boolean active;
	@Column(name="block_dispatcher_ext")
	private boolean blockDispatcherExt;
	@Transient
	private Set<JobPartMonitor> jobPartMonitors = new HashSet<JobPartMonitor>(0);
	@OneToMany
	@JoinColumn(name = "job_status_id")
	@JsonIgnore
	private Set<Job> jobs = new HashSet<Job>(0);
	@OneToMany
	@JoinColumn(name = "job_status_id")
	@JsonIgnore
	private Set<XrefJobPartStatusJob> xrefJobPartStatusJobs = new HashSet<XrefJobPartStatusJob>(0);

	public JobStatus() {
	}

	public JobStatus(int id, String description, boolean active, boolean blockDispatcherExt) {
		this.id = id;
		this.description = description;
		this.active = active;
		this.blockDispatcherExt = blockDispatcherExt;
	}

	public JobStatus(int id, Color color, String description, String code, boolean active, boolean blockDispatcherExt, Set<JobPartMonitor> jobPartMonitors, Set<Job> jobs, Set<XrefJobPartStatusJob> xrefJobPartStatusJobs) {
		this.id = id;
		this.color = color;
		this.description = description;
		this.code = code;
		this.active = active;
		this.blockDispatcherExt = blockDispatcherExt;
		this.jobPartMonitors = jobPartMonitors;
		this.jobs = jobs;
		this.xrefJobPartStatusJobs = xrefJobPartStatusJobs;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isBlockDispatcherExt() {
		return this.blockDispatcherExt;
	}

	public void setBlockDispatcherExt(boolean blockDispatcherExt) {
		this.blockDispatcherExt = blockDispatcherExt;
	}
	
	public Set<JobPartMonitor> getJobPartMonitors() {
		return this.jobPartMonitors;
	}

	public void setJobPartMonitors(Set<JobPartMonitor> jobPartMonitors) {
		this.jobPartMonitors = jobPartMonitors;
	}

	public Set<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	public Set<XrefJobPartStatusJob> getXrefJobPartStatusJobs() {
		return this.xrefJobPartStatusJobs;
	}

	public void setXrefJobPartStatusJobs(Set<XrefJobPartStatusJob> xrefJobPartStatusJobs) {
		this.xrefJobPartStatusJobs = xrefJobPartStatusJobs;
	}
}