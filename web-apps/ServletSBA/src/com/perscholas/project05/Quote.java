package com.perscholas.project05;

import java.util.Date;

public class Quote {
	private int quoteId, homeId;
	private double yearlyPremium;
	private Date startDate, expiration;
	private boolean isActive;
	
	public Quote() {
		super();
	}

	public Quote(int quoteId, int homeId, double yearlyPremium, Date startDate, Date expiration, boolean isActive) {
		super();
		this.quoteId = quoteId;
		this.homeId = homeId;
		this.yearlyPremium = yearlyPremium;
		this.startDate = startDate;
		this.expiration = expiration;
		this.isActive = isActive;
	}

	public int getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}

	public int getHomeId() {
		return homeId;
	}

	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}

	public double getYearlyPremium() {
		return yearlyPremium;
	}

	public void setYearlyPremium(double yearlyPremium) {
		this.yearlyPremium = yearlyPremium;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Quote [quoteId=" + quoteId + ", homeId=" + homeId + ", yearlyPremium=" + yearlyPremium + ", startDate="
				+ startDate + ", expiration=" + expiration + ", isActive=" + isActive + "]";
	}
	
	
}
