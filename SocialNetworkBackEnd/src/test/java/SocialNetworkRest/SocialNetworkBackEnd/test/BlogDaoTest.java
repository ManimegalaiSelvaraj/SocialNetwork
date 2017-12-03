package SocialNetworkRest.SocialNetworkBackEnd.test;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.SocialNetworkBackEnd.Config.ApplicationContextConfig;
import com.SocialNetworkBackEnd.Dao.BlogDao;
import com.SocialNetworkBackEnd.Dao.UserDao;
import com.SocialNetworkBackEnd.Model.Blog;
import com.SocialNetworkBackEnd.Model.UserDetail;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ApplicationContextConfig.class})
@WebAppConfiguration
@Transactional

public class BlogDaoTest {

	 @Autowired
	  BlogDao blogdao;
		@Autowired
	    public Blog blog;
		
		@Autowired
		SessionFactory sessionFactory;
		
		
		@Ignore
		@Test
		public void addTest()
		{
			Blog blog=new Blog();
			blog.setBlogId(1001);
			blog.setBlogName("Core Java");
			blog.setBlogContent("It is based on Simple Java Concept");
			blog.setUsername("sunil");
			blog.setStatus("A");
			blog.setLikes(3);
			blog.setCreateDate(new java.util.Date());
			System.out.println("Check");
			assertTrue("Problem in Inserting Blog",blogdao.addBlog(blog));
			System.out.println("Check2");

		}

}
