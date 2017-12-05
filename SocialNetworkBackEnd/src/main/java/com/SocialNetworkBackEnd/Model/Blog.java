package com.SocialNetworkBackEnd.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Blog 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	int blogId;
	
	String blogName;
	String blogContent;
	int userid;
	String status;
	int likes;
	
	Date createDate;
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getBlogId() 
	{
		return blogId;
	}
	public void setBlogId(int blogId) 
	{
		this.blogId = blogId;
	}
	public String getBlogName() 
	{
		return blogName;
	}
	public void setBlogName(String blogName) 
	{
		this.blogName = blogName;
	}
	public String getBlogContent() 
	{
		return blogContent;
	}
	public void setBlogContent(String blogContent) 
	{
		this.blogContent = blogContent;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
	
}

