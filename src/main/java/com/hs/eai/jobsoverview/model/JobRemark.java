package com.hs.eai.jobsoverview.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.search.annotations.DocumentId;

@Entity
@Table(name="Job_remark")
@NamedQueries({
	@NamedQuery(name = "JobRemark.findALL", query = "SELECT j FROM JobRemark j"),
	@NamedQuery(name = "JobRemark.JobByJobId", query = "SELECT j FROM JobRemark j WHERE j.jobId=:jobId")
	
})
public class JobRemark {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5204916092936772401L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@DocumentId
	@Column(name="ID",columnDefinition="numeric")
	private Integer id;
	@Column(name="timestamp" ,columnDefinition="timestamp")
	private Date timestamp;
	@Column(name="job_id" ,columnDefinition="int" , insertable = false, updatable = false,nullable=false)
	private Integer jobId;
	@Column(name="remark" ,columnDefinition="nvarchar")
	private String remark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
