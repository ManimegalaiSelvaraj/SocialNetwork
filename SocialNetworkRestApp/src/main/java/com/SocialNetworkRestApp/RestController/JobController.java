package com.SocialNetworkRestApp.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SocialNetworkBackEnd.Dao.JobDao;
import com.SocialNetworkBackEnd.Model.Blog;
import com.SocialNetworkBackEnd.Model.Job;


@RestController
public class JobController {

	@Autowired
    JobDao jobdao;
   
	@PostMapping(value="/addjob")
    public ResponseEntity<String> saveblog(@RequestBody Job b)
    {
      if(jobdao.addjob(b))
      {
	    System.out.println(b);
        return new ResponseEntity<String>("Job added",HttpStatus.OK);
      }
      else
      {
	   return new ResponseEntity<String>(" error job added",HttpStatus.INTERNAL_SERVER_ERROR);	
      }
    }
	@RequestMapping(value="/getAllJob")
	public ResponseEntity<ArrayList<Job>> getAllJobs()
	{
		ArrayList<Job> listJob = (ArrayList<Job>)jobdao.getalljob();
		return new ResponseEntity<ArrayList<Job>>(listJob,HttpStatus.OK);
	}
	@RequestMapping(value="/updateJob")
	public  ResponseEntity<String> updateJob(@RequestBody Job j)
	{
		Job tempBlog=jobdao.getjob(j.getJobId());
	    tempBlog.setJobName(j.getJobName());
		tempBlog.setJobDesc(j.getJobDesc());
		if(jobdao.updatejob(tempBlog))
		{
			return new ResponseEntity<String>("Job Update",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Job updation",HttpStatus.SERVICE_UNAVAILABLE);
			
		}
	}
	@RequestMapping(value = "deletejob/{blogId}")
	public ResponseEntity<String> deleteBlog(@PathVariable int blogId)
	{
		//Blog tempblog=blogdao.getblogbyid(blog.getBlogId());
		if(jobdao.deletejob(blogId))
		{
		return new ResponseEntity<String>("Job Deleted",HttpStatus.OK);
		}
		else{
		return new ResponseEntity<String>("Error in Job deletion",HttpStatus.SERVICE_UNAVAILABLE);
		}
	   // blogdao.deleteblog(blogId);
	   
		
	}

}
