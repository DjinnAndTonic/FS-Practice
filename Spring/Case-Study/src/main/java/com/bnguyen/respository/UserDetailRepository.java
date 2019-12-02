package com.bnguyen.respository;

import com.bnguyen.models.UserDetail;

public interface UserDetailRepository {
	void addUserDetail(UserDetail ud);
	UserDetail getUserDetail(String email);
}
