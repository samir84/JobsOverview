package com.hs.eai.jobsoverview.dao;

import com.hs.eai.jobsoverview.model.JobRemark;

public interface JobRemarkDao {

	public JobRemark findJobRemarkByJobId(Integer jobId);
}
