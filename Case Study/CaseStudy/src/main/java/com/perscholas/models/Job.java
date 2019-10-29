package com.perscholas.models;

public class Job {
	private int jobId;
	private String companyName, alumEmail;
	
	public Job() {
	}

	public Job(int jobId, String companyName, String alumEmail) {
		this.jobId = jobId;
		this.companyName = companyName;
		this.alumEmail = alumEmail;
	}

	public int getJobId() {
		return jobId;
	}

	public void setCompanyId(int companyId) {
		this.jobId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAlumEmail() {
		return alumEmail;
	}

	public void setAlumEmail(String alumEmail) {
		this.alumEmail = alumEmail;
	}
	
	
}
