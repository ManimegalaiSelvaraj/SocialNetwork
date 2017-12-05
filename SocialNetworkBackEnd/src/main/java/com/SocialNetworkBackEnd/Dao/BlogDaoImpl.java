package com.SocialNetworkBackEnd.Dao;

	import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.SocialNetworkBackEnd.Model.Blog;

	
@Repository
@Transactional
	
	public class BlogDaoImpl implements BlogDao 
	{
		@Autowired
		SessionFactory sessionfactory;
		
		public BlogDaoImpl(SessionFactory sessionfactory) {
			this.sessionfactory=sessionfactory;
		}

			
		@Transactional
		//@Override
		public boolean addBlog(Blog blog) 
		{
			try
			{
				Session session=sessionfactory.openSession();
				Transaction transaction=session.getTransaction();
				transaction.begin();
				session.save(blog);
				transaction.commit();
				session.close();
				/*System.out.println("1");
			    System.out.println(sessionfactory);

				sessionfactory.getCurrentSession().save(user);*/
				return true;
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return false;
		}

		@Transactional
		public Blog getblogbyid(int blogId) 
		{
			
		    Session session=sessionfactory.openSession();
		    Transaction transaction=session.getTransaction();
		    transaction.begin();
		    Blog b=session.get(Blog.class,new Integer(blogId));
		       session.flush();
		       transaction.commit();
		       session.close();
			return b;
			 
		}
	@Transactional
	public boolean updateblog(Blog b)
	{
	try
		{
		 Session session=sessionfactory.openSession();
		Transaction transaction=session.getTransaction();
		transaction.begin(); 
		session.saveOrUpdate(b);
         session.flush();
         transaction.commit();
		 
         session.close();
		 System.out.println("updated successfully");
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;	
	}
	}
	@Transactional
	public boolean deleteblog(Blog b)
	{
	try
		{
		Session session=sessionfactory.openSession();
		Transaction transaction=session.getTransaction();
		transaction.begin();
		session.delete(b);
		session.flush();
		transaction.commit();
		session.close();
		 System.out.println("deleted successfully");
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;	
	}
	}
	@Transactional
	public List<Blog> getallblogs()
	{
		Session session=sessionfactory.openSession();
		Transaction transaction=session.getTransaction();
		transaction.begin();
		String hql="from blog";
		Query query=session.createQuery(hql);
		return query.list();
	}
	@Transactional
	public boolean approveblog(Blog b)
	{
		try
		{
			Session session=sessionfactory.openSession();
			Transaction transaction=session.getTransaction();
			transaction.begin(); 
			session.saveOrUpdate(b);
	   		 session.flush();
	   	     transaction.commit();
	   		 session.close();
	//	sessionfactory.getCurrentSession().saveOrUpdate(b);
		System.out.println("appoved blog");
		return true;
	}
		catch(Exception e)
		{
			System.out.println(e);
			return false;	
		}
	}
	@Transactional
	public boolean rejectblog(Blog b) {
		try
		{
			Session session=sessionfactory.openSession();
			Transaction transaction=session.getTransaction();
			transaction.begin(); 
			session.saveOrUpdate(b);
	        // transaction.commit();
			 session.flush();
		     transaction.commit();
			 session.close();
		//sessionfactory.getCurrentSession().saveOrUpdate(b);
		System.out.println("rejected blog");
		return true;
	}
		catch(Exception e)
		{
			System.out.println(e);
			return false;	
		}
	}


	}

