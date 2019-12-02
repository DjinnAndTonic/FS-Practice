package com.bnguyen.respository;

import com.bnguyen.models.Score;

public interface ScoreRepository {
	void addScore(Score s);
	Score getScore(int userId);
}
