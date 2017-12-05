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
		user.setUserName("aa");
		user.setRole("user");
		user.setEmailId("aa@gmail.com");
		user.setIsOnline("N");
		user.setPassword("aa");
		System.out.println("check1");
		System.out.println(userdao);
		assertTrue("Problem in Inserting User",userdao.addUser(user));
		System.out.println("check2");
	
	}
	//@Ignore
	@Test
	public void updateTest()
	{
		//UserDao userdao=new UserDaoImpl(sessionFactory);
		//UserDetail user=new UserDetail();
		UserDetail user=userdao.getuserbyid(2);
		//user.setUserId(13);
		user.setUserName("aa");
		user.setRole("user");
		user.setEmailId("aa@gmail.com");
		user.setIsOnline("N");
		user.setPassword("bb");
		System.out.println("check1");
		System.out.println(userdao);
		assertTrue("Problem in Updating User",userdao.updateuser(user));
		System.out.println("check2");
	
	}
   @Ignore
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
   @Ignore
   @Test
   public void getuserbyidTest()
   {
       UserDetail ud=userdao.getuserbyid(1);
       System.out.println("getuserbyid() method invoked");
       System.out.println("username = "+ud.getUserName());
   }
   @Ignore
   @Test
   public void deleteuserTest()
   {
       UserDetail ud=userdao.getuserbyid(1);
       assertTrue("problem in deleting user",userdao.deleteuser(ud));
   }
   
   @Ignore
   @Test
   public void changeonlinestatus()
   {
       UserDetail u=userdao.getuserbyid(2);
       u.setIsOnline("y");
       assertTrue("problem in changing the  user online status",userdao.updateOnlineStatus(u));
       
   }
}
