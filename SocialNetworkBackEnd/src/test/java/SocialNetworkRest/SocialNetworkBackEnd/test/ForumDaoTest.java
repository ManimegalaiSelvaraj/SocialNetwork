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
import com.SocialNetworkBackEnd.Dao.ForumDao;
//import com.SocialNetworkBackEnd.Dao.UserDao;
import com.SocialNetworkBackEnd.Model.Forum;
//import com.SocialNetworkBackEnd.Model.UserDetail;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ApplicationContextConfig.class})
@WebAppConfiguration
@Transactional
public class ForumDaoTest {

	@Autowired
    ForumDao forumdao;
	@Autowired
    public Forum forum;
	
	@Autowired
	SessionFactory sessionFactory;
	//@Ignore
	@Test
	public  void addForumTest() {
		Forum forum = new Forum();
	    forum.setForumContent("good");
	    forum.setUserId(1);
	    forum.setForumName("forum1");
	    forum.setUsername("AA");
	    forum.setStatus("A");
	    forum.setCreateDate(new java.util.Date());
	    System.out.println("1");
		assertEquals("Failed to add user!",forumdao.addforum(forum));
		System.out.println("2");
	} 
	
	@Ignore
	@Test
	public void getForumTest(){
		
		Forum forum = forumdao.getforumbyid(1);
		assertNotEquals("forum Not Found", forum);
		
		System.out.println("Forum Name:"+forum.getForumName());
		System.out.println("Blog Content"+forum.getForumContent());
	}
	@Ignore
	@Test
	public void getAllForumTest(){
		
	    
		List<Forum> forumList=(List<Forum>)forumdao.getallforums();
		assertNotNull("Forum List Not Found", forumList.get(0));
		for(Forum forum:forumList)
			
		{
			System.out.println("Forum ID"+forum.getForumId()+"::"+"Forum Name:"+forum.getForumName());
			assertTrue("Problem in Deletion", forumdao.deleteforum(forum));
		}
	}
	@Ignore
	@Test
	public void updateForumTest(){
	
		Forum forum = forumdao.getforumbyid(1);
		forum.setForumContent("welldonw");
		forum.setForumName("nice");
		assertTrue("Problem in updation",forumdao.updateforum(forum));
	}
	


}
