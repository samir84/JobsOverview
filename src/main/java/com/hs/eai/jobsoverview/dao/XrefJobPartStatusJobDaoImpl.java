package com.hs.eai.jobsoverview.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hs.eai.jobsoverview.common.GenericDaoImpl;
import com.hs.eai.jobsoverview.model.Job;
import com.hs.eai.jobsoverview.model.XrefJobPartStatusJob;
import com.sun.xml.ws.api.tx.at.Transactional;



@Repository
public class XrefJobPartStatusJobDaoImpl extends GenericDaoImpl<XrefJobPartStatusJob> implements XrefJobPartStatusJobDao{

	private static final Logger logger = LoggerFactory.getLogger(XrefJobPartStatusJobDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<XrefJobPartStatusJob> findJobPartStatusByJobId(Integer jobId) {
		
		logger.debug("Find findJobPartStatus By JobId {} ",jobId," .");
		List<XrefJobPartStatusJob> jobDetails = null ;
		try{
			Job job = entityManager.find(Job.class, jobId);
			Query query = entityManager.createNamedQuery("XrefJobPartStatusJob.findJobPartStatusByJobId");
			query.setParameter("job", job);
			jobDetails = (List<XrefJobPartStatusJob>) query.getResultList();
		}catch(Exception ex){
			logger.error("Error Find findJobPartStatus By JobId {} ",jobId," error is: ",ex.getMessage());
			ex.printStackTrace();
		}
		return jobDetails;
	}

	
	

}
