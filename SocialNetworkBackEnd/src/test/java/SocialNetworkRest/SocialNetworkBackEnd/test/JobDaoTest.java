package SocialNetworkRest.SocialNetworkBackEnd.test;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.SocialNetworkBackEnd.Config.ApplicationContextConfig;
import com.SocialNetworkBackEnd.Dao.JobDao;
//import com.SocialNetworkBackEnd.Dao.JobDao;
import com.SocialNetworkBackEnd.Model.Job;
//import com.SocialNetworkBackEnd.Model.Job;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ApplicationContextConfig.class})
@WebAppConfiguration
@Transactional

public class JobDaoTest {
	@Autowired
	  JobDao jobdao;
		@Autowired
	    public Job job;
		
		@Autowired
		SessionFactory sessionFactory;
		
		
		//@Ignore
		@Test
		public void addjobTest()
		{
			Job job =new Job();
		//	job.setjobId(1001);
			//;
			job.setJobProfile("Hai");
			//job.setUserid(2);
		    job.setJobDesc("Good");
		    job.setJobQual("High");
		    job.setJobStatus("N");
			job.setJobDate(new java.util.Date());
			System.out.println("Check");
			assertTrue("Problem in Inserting job",jobdao.addjob(job));
			System.out.println("Check2");

		}
		

}
