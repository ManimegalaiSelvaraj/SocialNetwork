package com.SocialNetworkBackEnd.Dao;

import java.util.List;

//import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
//import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.SocialNetworkBackEnd.Model.UserDetail;

@Repository
@Transactional
public class UserDaoImpl  implements UserDao{
    
	@Autowired
	public SessionFactory sessionfactory;
	
	public UserDaoImpl(SessionFactory sessionfactory) {
	 this.sessionfactory=sessionfactory;
	}

	/* (non-Javadoc)
	 * @see com.SocialNetworkBackEnd.Dao.UserDao#addUser(com.SocialNetworkBackEnd.Model.UserDetail)
	 */
	@Transactional
//	@Override
	public boolean addUser(UserDetail user) {
		try
		{
			Session session=sessionfactory.openSession();
			Transaction transaction=session.getTransaction();
			transaction.begin();
			session.save(user);
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
public boolean updateuser(UserDetail user)
{
try
{
Session session=sessionfactory.openSession();
Transaction transaction=session.getTransaction();
transaction.begin();
session.saveOrUpdate(user);
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
public boolean deleteuser(UserDetail user)
{
try
{
	Session session=sessionfactory.openSession();
	Transaction transaction=session.getTransaction();
	transaction.begin();
session.delete(user);
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
public boolean updateOnlineStatus(UserDetail user)
{
try
{
user.setIsOnline(user.getIsOnline());
Session session=sessionfactory.openSession();
Transaction transaction=session.getTransaction();
transaction.begin();
session.saveOrUpdate(user);
transaction.commit();
session.close();
System.out.println("online status updated");
return true;
}
catch(Exception e)
{
   System.out.println(e);
   return false;    
}
}	

	public List<UserDetail> getalluser() {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Transaction transaction=session.getTransaction();
		transaction.begin();
		Query query=session.createQuery("from UserDetail");
		//System.out.println("****"+query);
		List<UserDetail> userdetail=query.list();
		
		//List<UserDetail> userdetail=session.createQuery("from UserDetail").list();
	//	System.out.println("@@:"+userdetail);
	    
		//session.close();
	    return userdetail;
	}

	    public UserDetail getuserbyid(int userId) 
	    {
	        
	        Session session=sessionfactory.openSession();
	        Transaction transaction=session.getTransaction();
	        transaction.begin();
	        UserDetail ud=session.get(UserDetail.class,new Integer(userId));
	        session.flush();
	        transaction.commit();
	        session.close();
	        return ud;
	         
	    }

	}

	


	

