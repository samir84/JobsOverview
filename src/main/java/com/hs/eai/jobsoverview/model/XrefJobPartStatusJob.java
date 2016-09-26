package com.hs.eai.jobsoverview.model;

// Generated 10-jul-2012 9:36:12 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.search.annotations.DocumentId;

@Entity
@Table(name="xref_job_part_status_job")
@NamedQueries({
	@NamedQuery(name = "XrefJobPartStatusJob.findAll", query = "SELECT xref FROM XrefJobPartStatusJob xref "),
	@NamedQuery(name = "XrefJobPartStatusJob.findJobPartStatusByJobId", query = "SELECT xref FROM XrefJobPartStatusJob xref WHERE xref.job=:job order by id desc")
	
})
public class XrefJobPartStatusJob implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5204916092936772401L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@DocumentId
	@Column(name="ID",columnDefinition="numeric")
	private Integer id;
	private Date timestamp;
	@ManyToOne
	@JoinColumn(name = "job_id" ,nullable=false)
	private Job job;
	@ManyToOne
	@JoinColumn(name = "job_part_id" ,nullable=false)
	private JobPart jobPart;
	@ManyToOne
	@JoinColumn(name = "job_status_id" ,nullable=false)
	private JobStatus jobStatus;
	@Column(name="recordcount", columnDefinition="int")
	private Integer recordcount;

	public XrefJobPartStatusJob() {
	}

	public XrefJobPartStatusJob(int id, Job job, JobPart jobPart,
			JobStatus jobStatus) {
		this.id = id;
		this.job = job;
		this.jobPart = jobPart;
		this.jobStatus = jobStatus;
	}

	public XrefJobPartStatusJob(int id, Job job, JobPart jobPart,
			JobStatus jobStatus, Integer recordcount) {
		this.id = id;
		this.job = job;
		this.jobPart = jobPart;
		this.jobStatus = jobStatus;
		this.recordcount = recordcount;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public JobPart getJobPart() {
		return this.jobPart;
	}

	public void setJobPart(JobPart jobPart) {
		this.jobPart = jobPart;
	}

	public JobStatus getJobStatus() {
		return this.jobStatus;
	}

	public void setJobStatus(JobStatus jobStatus) {
		this.jobStatus = jobStatus;
	}

	public Integer getRecordcount() {
		return this.recordcount;
	}

	public void setRecordcount(Integer recordcount) {
		this.recordcount = recordcount;
	}

}
