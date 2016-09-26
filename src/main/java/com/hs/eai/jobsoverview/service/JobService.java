package com.hs.eai.jobsoverview.service;

import java.util.List;

import com.hs.eai.jobsoverview.dto.JobDto;
import com.hs.eai.jobsoverview.model.Job;

public interface JobService {

	List<Job> findAll();

	List<Job> loadLazyJobs(Integer page, Integer maxResult);
	List<JobDto> loadLazyJobsDto(Integer page, Integer maxResult);

	List<Job> fullTextjobHdrSearchWildcard(String searchTerm);

	Integer countAll();
}
