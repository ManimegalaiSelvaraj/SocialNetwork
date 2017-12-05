package com.SocialNetworkBackEnd.Dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SocialNetworkBackEnd.Model.Job;
//import com.SocialNetworkBackEnd.Model.UserDetail;

@Service
public interface JobDao {
 
	public boolean addjob(Job job);
	 public boolean updatejob(Job job);
	 public Job getjob(int jobId);
		public boolean deletejob(Job ud);
	    public List<Job> getalljob();
}
