package com.SocialNetworkBackEnd.Dao;

	import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

import com.SocialNetworkBackEnd.Model.Blog;

	

	@Repository("blogDao")
	public class BlogDaoImpl implements BlogDao 
	{
		@Autowired
		SessionFactory sessionFactory;
		
		public BlogDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory=sessionFactory;
		}

			
		@Transactional
		//@Override
		public boolean addBlog(Blog blog) 
		{
			try
			{
				Session session=sessionFactory.openSession();
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

		//@Override
		public boolean updateBlog(Blog blog) {
			// TODO Auto-generated method stub
			return false;
		}

		//@Override
		public boolean deleteBlog(Blog blog) {
			// TODO Auto-generated method stub
			return false;
		}

		//@Override
		public Blog getBlog(int blogId) {
			// TODO Auto-generated method stub
			return null;
		}

		//@Override
		public List<Blog> getAllBlogs() {
			// TODO Auto-generated method stub
			return null;
		}

		//@Override
		public boolean approveBlog(Blog blog) {
			// TODO Auto-generated method stub
			return false;
		}

	}

