package com.SocialNetworkRestApp.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SocialNetworkBackEnd.Dao.FriendDao;
import com.SocialNetworkBackEnd.Model.Friend;



@RestController
public class FriendController {
	@Autowired
    FriendDao frienddao;
   
	@RequestMapping(value="/addFriend")
    public ResponseEntity<String> saveblog(@RequestBody Friend b)
    {
	 b.setStatus("R");
      if(frienddao.createFriend(b))
      {
	    System.out.println(b);
        return new ResponseEntity<String>("Friend added",HttpStatus.OK);
      }
      else
      {
	   return new ResponseEntity<String>(" error Friend added",HttpStatus.INTERNAL_SERVER_ERROR);	
      }
    }

}
