package com.SocialNetworkBackEnd.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Job {

	//	private static final long serialVersionUID = 190898412L;
		
		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
           
		int jobId;
		String jobProfile;
		String jobDesc;
		String jobQual;
		String jobStatus;
		Date jobDate;
		public int getJobId() {
			return jobId;
		}
		public void setJobId(int jobId) {
			this.jobId = jobId;
		}
		public String getJobProfile() {
			return jobProfile;
		}
		public void setJobProfile(String jobProfile) {
			this.jobProfile = jobProfile;
		}
		public String getJobDesc() {
			return jobDesc;
		}
		public void setJobDesc(String jobDesc) {
			this.jobDesc = jobDesc;
		}
		public String getJobQual() {
			return jobQual;
		}
		public void setJobQual(String jobQual) {
			this.jobQual = jobQual;
		}
		public String getJobStatus() {
			return jobStatus;
		}
		public void setJobStatus(String jobStatus) {
			this.jobStatus = jobStatus;
		}
		public Date getJobDate() {
			return jobDate;
		}
		public void setJobDate(Date jobDate) {
			this.jobDate = jobDate;
		}
		
}

