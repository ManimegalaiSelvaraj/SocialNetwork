package com.SocialNetworkBackEnd.Dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SocialNetworkBackEnd.Model.Forum;
//import com.SocialNetworkBackEnd.Model.Forum;

@Service
public interface ForumDao {
	public boolean addforum(Forum Forum);
	public boolean updateforum(Forum Forum);
	public boolean deleteforum(Forum Forum);
	public Forum getforumbyid(int ForumId);
	public List<Forum> getallforums();
	public boolean approveforum(Forum Forum);
	public boolean rejectforum(Forum b);
}
