package com.SocialNetworkBackEnd.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.SocialNetworkBackEnd.Model.Job;

public class JobDaoImpl implements JobDao {

	//SessionFactory sessionfactory;
	@Autowired
	SessionFactory sessionfactory;

	public JobDaoImpl(SessionFactory sessionfactory) {
		 this.sessionfactory=sessionfactory;
		}
	@Transactional
	public boolean addjob(Job jobs) {
		try {
			sessionfactory.getCurrentSession().save(jobs);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
		}
		return false;

	}

	@Transactional
	//@Override
	public boolean deletejob(Job jobs) {
		try {
			sessionfactory.getCurrentSession().delete(jobs);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
		}
		return false;

	}

	@Transactional
	//@Override
	public boolean updatejob(Job jobs) {
		try {
			sessionfactory.getCurrentSession().update(jobs);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
		}
		return false;

	}

	@Transactional
	//@Override
	public Job getjob(int jobId) {
		Session session = (Session) sessionfactory.openSession();
		Job jobs = (Job) ((org.hibernate.Session) session).get(Job.class, new Integer(jobId));
		return jobs;

	}

	@Transactional
	//@Override
	public List<Job> getalljob() {
		return sessionfactory.getCurrentSession().createQuery("from Jobs").list();
	}

}
