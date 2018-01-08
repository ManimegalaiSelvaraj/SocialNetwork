package com.SocialNetworkRestApp.RestController;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.SocialNetworkBackEnd.Dao.BlogDao;
import com.SocialNetworkBackEnd.Dao.UserDao;
import com.SocialNetworkBackEnd.Model.Blog;
//import com.SocialNetworkBackEnd.Model.Blog;
import com.SocialNetworkBackEnd.Model.UserDetail;

@RestController
public class UserController {
	@Autowired
    UserDao userdao;
   
	@RequestMapping(value="/addUser")
    public ResponseEntity<UserDetail> saveuser(@RequestBody UserDetail b)
    {
		 b.setIsOnline("N");
		    b.setRole("User");
		  
      if(userdao.addUser(b))
      {
	    System.out.println(b);
	    System.out.println("@@@:"+b.getRole());
        return new ResponseEntity<UserDetail>(b,HttpStatus.OK);
      }
      else
      {
	   return new ResponseEntity<UserDetail>(b,HttpStatus.INTERNAL_SERVER_ERROR);	
      }
    }
    
    
	@PostMapping(value="/login")
	public ResponseEntity<UserDetail> checklogin(@RequestBody UserDetail l,HttpSession session)
	{
		if(userdao.checklogin(l))
		{
			return new ResponseEntity<UserDetail>(l,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<UserDetail>(l,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping(value="/getAllUser")
	public ResponseEntity<ArrayList<UserDetail>> getAllUsers()
	{
		ArrayList<UserDetail> listBlogs = (ArrayList<UserDetail>)userdao.getalluser();
		return new ResponseEntity<ArrayList<UserDetail>>(listBlogs,HttpStatus.OK);
	}
	@RequestMapping(value="/updateUser")
	public  ResponseEntity<String> updateUser(@RequestBody UserDetail ud)
	{
		UserDetail tempuser=userdao.getuserbyid(ud.getUserId());
	    tempuser.setUserName(ud.getUserName());
		//tempBlog.setBlogContent(ud.getBlogContent());
		if(userdao.updateuser(tempuser))
		{
			return new ResponseEntity<String>("User Update",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in USer updation",HttpStatus.SERVICE_UNAVAILABLE);
			
		}
	}
	@RequestMapping(value = "deleteUser")
	public ResponseEntity<String> deleteUser(@RequestBody UserDetail d)
	{
		UserDetail tempuser=userdao.getuserbyid(d.getUserId());
		if(userdao.deleteuser(tempuser))
		{
			return new ResponseEntity<String>("User Deleted",HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("Error in user deletion",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	@GetMapping(value="/logoutuser/{userName}")
	public ResponseEntity<UserDetail>login(@PathVariable("userName") String username)
	{
		UserDetail u=userdao.getuser(username);
		u.setIsOnline("N");
	if(userdao.updateOnlineStatus(u))
	{
	return new ResponseEntity<UserDetail>(u,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<UserDetail>(u,HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	}

	


}

