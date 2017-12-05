package SocialNetworkRest.SocialNetworkBackEnd.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

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
//import com.SocialNetworkBackEnd.Dao.UserDao;
import com.SocialNetworkBackEnd.Model.Blog;
//import com.SocialNetworkBackEnd.Model.UserDetail;

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
		
		
		//@Ignore
		@Test
		public void addBlogTest()
		{
			Blog blog=new Blog();
		//	blog.setBlogId(1001);
			blog.setBlogName("Core Java");
			blog.setBlogContent("It is based on Simple Java Concept");
			blog.setUserid(2);
			blog.setStatus("A");
			blog.setLikes(3);
			blog.setCreateDate(new java.util.Date());
			System.out.println("Check");
			assertTrue("Problem in Inserting Blog",blogdao.addBlog(blog));
			System.out.println("Check2");

		}
		
		@Ignore
		@Test
		public void updateblogTest()
		{
			Blog b=blogdao.getblogbyid(4);
			b.setBlogName("About angular framework");
			b.setBlogContent("explaining angular concept");
			b.setStatus("A");
			b.setLikes(500);
			//b.setUserId(21);
			b.setCreateDate(new Date());
			assertTrue("Problem in updating blog",blogdao.updateblog(b));
		}
		@Ignore
		@Test
		public void getblogbyidTest()
		{
			Blog b=blogdao.getblogbyid(4);
			System.out.println("getblogbyid() method invoked");
			System.out.println("blogstatus = "+b.getStatus());
		}
		@Ignore
		@Test
		public void deleteblogTest()
		{
			Blog b=blogdao.getblogbyid(5);
			assertTrue("problem in deleting blog",blogdao.deleteblog(b));
		}
		@Ignore
		@Test
		public void getallblogTest()
		{
			List<Blog> l=blogdao.getallblogs();
			for(Blog b:l)
			{
				System.out.println(b.getBlogId());
			}
		}
		@Ignore
		@Test
		public void approveblogTest()
		{
		Blog b=blogdao.getblogbyid(26);
		System.out.println("status before change"+b.getStatus());
		b.setStatus("A");
		assertTrue("problem in approving blog id",blogdao.approveblog(b));
		}
		@Ignore
		@Test
		public void rejectblogTest()
		{
			Blog b=blogdao.getblogbyid(27);
			b.setStatus("N");
			assertTrue("problem in rejecting  blog id",blogdao.rejectblog(b));	
		}

		

}
