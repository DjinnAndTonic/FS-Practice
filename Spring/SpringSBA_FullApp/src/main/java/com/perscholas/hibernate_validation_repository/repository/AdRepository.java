package com.perscholas.hibernate_validation_repository.repository;

import java.util.List;

import com.perscholas.hibernate_validation_repository.models.Ad;

public interface AdRepository {
	List<Ad> showAds();
	Integer addAd(Ad ad);
	Boolean removeAd(Integer adId);
	Boolean orderAd(Integer adId);
	Boolean cancelAd(Integer adId);
}
