package com.hs.eai.jobsoverview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hs.eai.jobsoverview.common.GenericDaoImpl;
import com.hs.eai.jobsoverview.dao.JobDao;
import com.hs.eai.jobsoverview.dao.JobRemarkDao;
import com.hs.eai.jobsoverview.dto.JobDto;
import com.hs.eai.jobsoverview.model.Job;

@Service
public class JobDaoServiceImpl  implements JobService{

	@Autowired
	JobDao jobDao;
	@Autowired
	JobRemarkDao jobRemarkDao;
	
	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return jobDao.findAll();
	}

	@Override
	public List<Job> loadLazyJobs(Integer page, Integer maxResult) {
		// TODO Auto-generated method stub
		List<Job> jobs = jobDao.loadLazyJobsOrderByTimeStamp(page, maxResult);
		return jobs;
		
	}

	@Override
	public List<Job> fullTextjobHdrSearchWildcard(String searchTerm) {
		// TODO Auto-generated method stub
		return jobDao.fullTextjobHdrSearchWildcard( searchTerm);
	}

	@Override
	public Integer countAll() {
		// TODO Auto-generated method stub
		return jobDao.countAlle();
	}

	@Override
	public List<JobDto> loadLazyJobsDto(Integer page, Integer maxResult) {
		// TODO Auto-generated method stub
		List<JobDto> jobs = jobDao.loadLazyJobsDtoOrderByTimeStamp(page, maxResult);
		return jobs;
	}

}
