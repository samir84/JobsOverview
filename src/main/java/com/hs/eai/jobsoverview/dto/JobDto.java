package com.hs.eai.jobsoverview.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hs.eai.jobsoverview.model.Job;

public class JobDto implements java.io.Serializable{

	@Override
	public String toString() {
		return "JobDto [job=" + job + ", countryCode=" + countryCode + ", remark=" + remark + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Job job;
	private String countryCode;
	private String remark;
	
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	
}
