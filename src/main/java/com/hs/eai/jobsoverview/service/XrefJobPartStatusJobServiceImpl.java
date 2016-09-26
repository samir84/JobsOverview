package com.hs.eai.jobsoverview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.eai.jobsoverview.dao.XrefJobPartStatusJobDao;
import com.hs.eai.jobsoverview.model.XrefJobPartStatusJob;

@Service
public class XrefJobPartStatusJobServiceImpl implements XrefJobPartStatusJobService {

	@Autowired
	XrefJobPartStatusJobDao xrefJobPartStatusJobDao;
	
	@Override
	public List<XrefJobPartStatusJob> findJobPartStatusByJobId(Integer jobId) {
		// TODO Auto-generated method stub
		return xrefJobPartStatusJobDao.findJobPartStatusByJobId(jobId);
	}

}
