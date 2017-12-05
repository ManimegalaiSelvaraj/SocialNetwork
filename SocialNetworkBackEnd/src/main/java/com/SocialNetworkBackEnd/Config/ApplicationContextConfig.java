package com.SocialNetworkBackEnd.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.SocialNetworkBackEnd.Dao.BlogDao;
import com.SocialNetworkBackEnd.Dao.BlogDaoImpl;
import com.SocialNetworkBackEnd.Dao.ForumDao;
import com.SocialNetworkBackEnd.Dao.ForumDaoImpl;
import com.SocialNetworkBackEnd.Dao.JobDao;
import com.SocialNetworkBackEnd.Dao.JobDaoImpl;
//import com.SocialNetworkBackEnd.Dao.ForumDaoImpl;
//import com.SocialNetworkBackEnd.Dao.BlogDao;
//import com.SocialNetworkBackEnd.Dao.BlogDaoImpl;
import com.SocialNetworkBackEnd.Dao.UserDao;
import com.SocialNetworkBackEnd.Dao.UserDaoImpl;
import com.SocialNetworkBackEnd.Model.Blog;
//import com.SocialNetworkBackEnd.Model.Blog;
import com.SocialNetworkBackEnd.Model.UserDetail;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.SocialNetworkBackEnd.*")
@EnableWebMvc
public class ApplicationContextConfig 
{
	   //1.Creating a DataSource Object which is used for LocalSessionFactory
	    @Autowired
	    @Bean(name="Datasource")
		public DataSource getOracleDataSource()
		{
			DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
			driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			driverManagerDataSource.setUsername("System");
			driverManagerDataSource.setPassword("Mani123#");
		//	System.out.println("1");
			return driverManagerDataSource;
		}
		
		//2.Creating Hibernate Properties which is used by LocalSessionFactory
	    @Autowired
	    @Bean(name="Properties")
		public Properties getHibernateProperties()
		{
			Properties properties=new Properties();
			properties.setProperty("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
			return properties;
		}
		@Autowired
		@Bean(name="sessionFactory")
		public SessionFactory getSessionFactory()
		{
			LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getOracleDataSource());
			localSessionFactoryBuilder.addProperties(getHibernateProperties());
		    localSessionFactoryBuilder.scanPackages("com.SocialNetworkBackEnd.Model");
			//localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
			System.out.println("SessionFactory Bean Created");
			//System.out.println("SessionFactory Bean Created");
			return localSessionFactoryBuilder.buildSessionFactory();
		}
		@Autowired
		@Bean(name="TransactionManager")
		public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
		{
			return new HibernateTransactionManager(sessionFactory);
		}
		
		@Autowired
		@Bean(name="userdao")
		public UserDao getUserDAO(SessionFactory sessionFactory)
		{
			System.out.println("User DAO Created");
			return new UserDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean(name="blogdao")
		public BlogDao getBlogDAO(SessionFactory sessionFactory)
		{
			System.out.println("Blog DAO Created");
			return new BlogDaoImpl(sessionFactory);
		}
		
		@Autowired
		@Bean(name="forumdao")
		public ForumDao getForumDAO(SessionFactory sessionFactory)
		{
			System.out.println("Forum DAO Created");
			return new ForumDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean(name="jobdao")
		public JobDao getJobDAO(SessionFactory sessionFactory)
		{
			System.out.println("Job DAO Created");
			return new JobDaoImpl(sessionFactory);
		}
}