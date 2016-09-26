package com.hs.eai.jobsoverview.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hs.eai.jobsoverview.common.GenericDaoImpl;
import com.hs.eai.jobsoverview.dto.JobDto;
import com.hs.eai.jobsoverview.model.Job;
import com.hs.eai.jobsoverview.model.JobRemark;


@Repository
public class JobDaoImpl extends GenericDaoImpl<Job> implements JobDao{

	private static final Logger logger = LoggerFactory.getLogger(JobDaoImpl.class);
	
	//@PersistenceContext
	//private EntityManager entityManager;
	
	/** Hibernate Full Text Entity Manager. */
	private FullTextEntityManager ftem;
	
	/**
	 * Convenience method to get Full Test Entity Manager. Protected scope to
	 * assist mocking in Unit Tests.
	 * 
	 * @return Full Text Entity Manager.
	 */
	protected FullTextEntityManager getFullTextEntityManager() {
		if (ftem == null) {
			ftem = Search.getFullTextEntityManager(em);
		}
		return ftem;
	}

	
	@Override
	public List<Job> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public List<Job> loadLazyJobsOrderByTimeStamp(Integer page, Integer maxResult) {
		// TODO Auto-generated method stub
		return super.Pagination(page, maxResult ,"timestamp");
	}

	@Override
	public List<Job> fullTextjobHdrSearchWildcard(String searchTerm) {
		
		logger.debug("Searching Jobs  for phrase {}" , searchTerm , ".");
		List<Job> jobs = null;
		try {
			// Create a Query Builder
			QueryBuilder qb = getFullTextEntityManager().getSearchFactory().buildQueryBuilder().forEntity(Job.class)
					.get();
			getFullTextEntityManager().createIndexer().startAndWait();
			
			org.apache.lucene.search.Query luceneQuery = qb.bool()
					.should(qb.keyword().wildcard().onField("reference").matching(searchTerm).createQuery())
					
			//.should(qb.keyword().wildcard().onField("jobStatus.description").matching(searchTerm).createQuery())
			//.should(qb.keyword().wildcard().onField("jobStatus.code").matching(searchTerm).createQuery())
			//.should(qb.keyword().wildcard().onField("code").matching(searchTerm).createQuery())
			//.should(qb.keyword().wildcard().onField("reference").matching(searchTerm).createQuery())
			///.should(qb.keyword().wildcard().onField("timestamp").matching(searchTerm).createQuery())
			//.should(qb.keyword().wildcard().onField("xrefJobPartStatusJobs").matching(searchTerm).createQuery())
			
			.createQuery();
			
			Query fullTextQuery = getFullTextEntityManager().createFullTextQuery(luceneQuery, Job.class);

			// Run Query and print out results to console
			jobs = (List<Job>) fullTextQuery.getResultList();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (getFullTextEntityManager() != null) {
				ftem.close();
			}
			ftem = null;
		}

		return jobs;
	}


	@Override
	public Integer countAlle() {
		// TODO Auto-generated method stub
		return (int) super.countAll();
	}


	@Override
	public List<JobDto> loadLazyJobsDtoOrderByTimeStamp(Integer page, Integer maxResult) {
		
		List<JobDto> jobsDto = new ArrayList<JobDto>() ;
		logger.debug("Lazy loding  Jobs inner join job remark starting loading from {} ",page," maxResult {}",maxResult);
		
		try{
			
			String queryString = "select j , jr from  Job j , JobRemark jr  where j.id = jr.jobId order by j.timestamp desc";
			Query query = this.em.createQuery(queryString.toString());
			
			if(page == 1){
				query.setFirstResult(0);
			}else{
				query.setFirstResult(maxResult * (page-1));
				
			}
			query.setMaxResults(maxResult);
			
			
			List<JobDto[]>  objects = query.getResultList();

			for(Object[] obj : objects){

				Job job = (Job) obj[0];
				JobRemark jobRemark = (JobRemark) obj[1];
				
				JobDto jobDto = new JobDto();
				jobDto.setJob(job);
				jobDto.setRemark(jobRemark.getRemark());
				jobsDto.add(jobDto);
				
			}
		}catch(Exception ex){
			logger.error("Lazy loding  Jobs inner join job remark starting loading from {} ",page," maxResult {}",maxResult ,
					" is faild cause {}",ex.getMessage());
			ex.printStackTrace();
		}
		
		return jobsDto;
	}
	
	


}
