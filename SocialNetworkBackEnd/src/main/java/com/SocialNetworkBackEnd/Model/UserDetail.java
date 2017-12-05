package com.SocialNetworkBackEnd.Model;

//import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
public class UserDetail {

	//	private static final long serialVersionUID = 190898412L;
		
		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		private int userId;
		private String userName;
		private String password;
		private String emailId;
		private String isOnline;
		private String role;
		
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getIsOnline() {
			return isOnline;
		}
		public void setIsOnline(String isOnline) {
			this.isOnline = isOnline;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		
	}


