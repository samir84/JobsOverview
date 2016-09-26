package com.hs.eai.jobsoverview.model;

// Generated 2-jul-2012 15:30:42 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Job")
@NamedQueries({
	@NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j")
	
})
@Indexed
public class Job implements java.io.Serializable {

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
	@JoinColumn(name = "job_status_id" ,nullable=false)
	//@IndexedEmbedded
	private JobStatus jobStatus;
	@Field
	private String reference;
	//@Field
	@Column(name="timestamp" ,columnDefinition="timestamp")
	private Date timestamp;
	@OneToMany
	@JoinColumn(name = "job_id")
	@JsonIgnore
	private Set<XrefJobPartStatusJob> xrefJobPartStatusJobs = new HashSet<XrefJobPartStatusJob>(0);

	public Job() {
	}

	public Job(int id, JobType jobType, String reference) {
		this.id = id;
		this.jobType = jobType;
		this.reference = reference;
	}

	public Job(int id, JobType jobType, String reference,
			Set<XrefJobPartStatusJob> xrefJobPartStatusJobs) {
		this.id = id;
		this.jobType = jobType;
		this.reference = reference;
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

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Set<XrefJobPartStatusJob> getXrefJobPartStatusJobs() {
		return this.xrefJobPartStatusJobs;
	}

	public void setXrefJobPartStatusJobs(Set<XrefJobPartStatusJob> xrefJobPartStatusJobs) {
		this.xrefJobPartStatusJobs = xrefJobPartStatusJobs;
	}

	public JobStatus getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(JobStatus jobStatus) {
		this.jobStatus = jobStatus;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
