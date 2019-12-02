package com.bnguyen.models;

import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;

public class Score {
	@Id
	private int userId, courseId, moduleId;
	
	@DecimalMin("0.0")
	private double kbaScore, sbaScore;
	
	
}
