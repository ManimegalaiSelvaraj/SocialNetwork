package SocialNetworkRest.SocialNetworkBackEnd.test;

import static org.junit.Assert.*;

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
import com.SocialNetworkBackEnd.Dao.UserDao;
import com.SocialNetworkBackEnd.Model.UserDetail;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ApplicationContextConfig.class})
@WebAppConfiguration
@Transactional
public class UserDaoTest {
  
   @Autowired
  UserDao userdao;
	@Autowired
    public UserDetail user;
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Ignore
	@Test
	public void addTest()
	{
		//UserDao userdao=new UserDaoImpl(sessionFactory);
		UserDetail user=new UserDetail();
		//user.setUserId(13);
		user.setUserName("mani");
		user.setRole("user");
		user.setEmailId("mani@gmail.com");
		user.setIsOnline("N");
		user.setPassword("mani");
		System.out.println("check1");
		System.out.println(userdao);
		assertTrue("Problem in Inserting User",userdao.addUser(user));
		System.out.println("check2");
	
	}
   //@Ignore
   @Test
   public void getallTest()
   {
	   List<UserDetail> udetail=userdao.getalluser();
	   System.out.println(udetail);
	   assertNotNull("User list not found",udetail.get(0));
	   
	   for(UserDetail userd:udetail)
	   {
		   System.out.println("UserID:"+userd.getUserId()+"Name:"+userd.getUserName()+"Role:"+userd.getRole()+"Email:"+userd.getEmailId()+"online"+userd.getIsOnline()+"Password"+userd.getPassword());
	   }
   }
   
}
