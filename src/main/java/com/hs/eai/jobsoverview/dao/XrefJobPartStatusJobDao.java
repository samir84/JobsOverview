package com.hs.eai.jobsoverview.dao;

import java.util.List;

import com.hs.eai.jobsoverview.model.XrefJobPartStatusJob;

public interface XrefJobPartStatusJobDao {

	List<XrefJobPartStatusJob> findJobPartStatusByJobId(Integer jobId);
}
