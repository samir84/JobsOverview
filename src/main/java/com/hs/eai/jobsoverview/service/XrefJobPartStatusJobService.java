package com.hs.eai.jobsoverview.service;

import java.util.List;

import com.hs.eai.jobsoverview.model.XrefJobPartStatusJob;

public interface XrefJobPartStatusJobService {

	List<XrefJobPartStatusJob> findJobPartStatusByJobId(Integer jobId);
}
