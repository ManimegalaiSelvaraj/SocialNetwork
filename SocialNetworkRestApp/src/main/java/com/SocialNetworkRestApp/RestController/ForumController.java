package com.SocialNetworkRestApp.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SocialNetworkBackEnd.Dao.ForumDao;
import com.SocialNetworkBackEnd.Model.Blog;
import com.SocialNetworkBackEnd.Model.Forum;



@RestController
public class ForumController {
	@Autowired
   ForumDao forumdao;
   
	@PostMapping(value="/addForum")
    public ResponseEntity<String> saveblog(@RequestBody Forum b)
    {
      if(forumdao.addforum(b))
      {
	    System.out.println(b);
        return new ResponseEntity<String>("Forum added",HttpStatus.OK);
      }
      else
      {
	   return new ResponseEntity<String>(" error Forum added",HttpStatus.INTERNAL_SERVER_ERROR);	
      }
    }
	@RequestMapping(value="/getAllForum")
	public ResponseEntity<ArrayList<Forum>> getAllBlogs()
	{
		ArrayList<Forum> listBlogs = (ArrayList<Forum>)forumdao.getallforums();
		return new ResponseEntity<ArrayList<Forum>>(listBlogs,HttpStatus.OK);
	}
		
}
