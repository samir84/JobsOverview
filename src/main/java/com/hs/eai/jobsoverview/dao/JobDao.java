package com.hs.eai.jobsoverview.dao;

import java.util.List;

import com.hs.eai.jobsoverview.dto.JobDto;
import com.hs.eai.jobsoverview.model.Job;

public interface JobDao {

	List<Job> findAll();
	List<Job> loadLazyJobsOrderByTimeStamp(Integer page, Integer maxResult);
	List<JobDto> loadLazyJobsDtoOrderByTimeStamp(Integer page, Integer maxResult);
	List<Job> fullTextjobHdrSearchWildcard(String searchTerm);
	Integer countAlle();
}
