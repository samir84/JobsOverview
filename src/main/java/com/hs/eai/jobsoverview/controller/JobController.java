package com.hs.eai.jobsoverview.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hs.eai.jobsoverview.dao.XrefJobPartStatusJobDaoImpl;
import com.hs.eai.jobsoverview.dto.JobDto;
import com.hs.eai.jobsoverview.model.Job;
import com.hs.eai.jobsoverview.model.XrefJobPartStatusJob;
import com.hs.eai.jobsoverview.service.JobService;
import com.hs.eai.jobsoverview.service.XrefJobPartStatusJobService;



@RestController
@RequestMapping("jobs")
public class JobController {

	private static final Logger logger = LoggerFactory.getLogger(JobController.class);
	
	@Autowired
	JobService jobService;
	@Autowired
	XrefJobPartStatusJobService xrefJobPartStatusJobService;
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Job>> findAllJobs(){
		
		List<Job> jobs = jobService.findAll();
		System.out.println("total Jobs: "+jobs.size());
        if(jobs.isEmpty()){
            return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
		
		
	}
	 /**
		 * Retrieve Lazy loading jobs
		 * 
		 * @param
		 * @return list jobs
		 */
		@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<JobDto>> lazyLoadjobs(
				@RequestParam(required = true, value = "startIndex") Integer startIndex,
				@RequestParam(required = true, value = "maxResult") Integer maxResult) {
			List<JobDto> jobs = jobService.loadLazyJobsDto(startIndex, maxResult);
			
			if (jobs.isEmpty()) {
				return new ResponseEntity<List<JobDto>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<JobDto>>(jobs, HttpStatus.OK);
		}
		/**
		 * Retrive job details
		 * 
		 * @param job
		 *            id
		 * @return jobDetails object
		 */
		@RequestMapping(value = "/details/{jobId}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<XrefJobPartStatusJob>> getJobDetails(@PathVariable("jobId") Integer jobId) {

			List<XrefJobPartStatusJob>  jobDetails = null;
			try {

				jobDetails  = xrefJobPartStatusJobService.findJobPartStatusByJobId(jobId);
				if (jobDetails == null) {
					logger.debug("No jobs found with id {} " ,jobId, ".");
					return new ResponseEntity<List<XrefJobPartStatusJob>>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<List<XrefJobPartStatusJob>>(jobDetails, HttpStatus.OK);

			} catch (Exception ex) {
				logger.error(ex.getMessage());
				ex.printStackTrace();
				return new ResponseEntity<List<XrefJobPartStatusJob>>(HttpStatus.BAD_REQUEST);
			}

		}
		/**
		 * Retrive job by pname
		 * 
		 * @param @any 
		 * @return job object
		 */
		@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Job>> fullTextjobsearchWildcard(@RequestParam(required = true, value = "q") String searchTerm) {

			logger.debug("Search jobs with searchTerm " + searchTerm);
			
			List<Job> jobs = jobService.fullTextjobHdrSearchWildcard(searchTerm.toLowerCase());
			if (jobs.isEmpty()) {
				logger.debug("No jobs found with search phrase " + searchTerm + " .");
				return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
		}
		/**
		 * Count All
		 */
		@RequestMapping(value = "/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Integer> countjobs() {
			Integer count = jobService.countAll();
			if (count.equals(null)) {
				return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<Integer>(count, HttpStatus.OK);
		}
	 
	}


