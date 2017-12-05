package com.SocialNetworkBackEnd.Dao;

import java.util.List;

import org.springframework.stereotype.Service;

//import java.util.List;

import com.SocialNetworkBackEnd.Model.UserDetail;

@Service
public interface UserDao {

     public boolean addUser(UserDetail user);
     public boolean updateOnlineStatus(UserDetail user);
	 //boolean saveUser(User user);
    //public UserDetail getuser(int userId);
     public boolean updateuser(UserDetail user);

    public List<UserDetail> getalluser();
	public UserDetail getuserbyid(int i);
	public boolean deleteuser(UserDetail ud);
	//public UserDetail getuserbyid(int i); 
    }