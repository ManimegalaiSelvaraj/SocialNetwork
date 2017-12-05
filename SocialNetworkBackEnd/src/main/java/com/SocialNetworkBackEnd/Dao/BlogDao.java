package com.SocialNetworkBackEnd.Dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SocialNetworkBackEnd.Model.Blog;

@Service
public interface BlogDao {

    public boolean addBlog(Blog blog);
	public boolean updateblog(Blog blog);
	public boolean deleteblog(Blog blog);
	public Blog getblogbyid(int blogId);
	public List<Blog> getallblogs();
	public boolean approveblog(Blog blog);
	public boolean rejectblog(Blog b);
}
