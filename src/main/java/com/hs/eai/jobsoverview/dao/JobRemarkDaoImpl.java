package com.hs.eai.jobsoverview.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hs.eai.jobsoverview.model.JobRemark;
import com.sun.xml.ws.api.tx.at.Transactional;

@Repository
public class JobRemarkDaoImpl implements JobRemarkDao{

	private static final Logger logger = LoggerFactory.getLogger(JobRemarkDaoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public JobRemark findJobRemarkByJobId(Integer jobId) {
		
		JobRemark jobRemark = null;
		
		logger.debug("Find JobRemark By job id {} ", jobId, ".");
		try{
			Query query = entityManager.createNamedQuery("JobRemark.JobByJobId");
			query.setParameter("jobId", jobId);
			jobRemark =  (JobRemark) query.getSingleResult();
		}catch(Exception ex){
			
			logger.error("Find JobRemark By job id {} faild cause {} ", ex.getMessage(), ".");
		}
		return jobRemark;
	}

}
