package com.bnguyen.respository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bnguyen.models.UserDetail;
import com.bnguyen.respository.UserDetailRepository;


@Repository("mariaDbUserDetailRepository")
public class MariaDbUserDetailRepository implements UserDetailRepository{
	
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;

	@Override
	public void addUserDetail(UserDetail ud) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("firstName", ud.getFirstName());
		params.addValue("middleName", ud.getMiddleName());
		params.addValue("lastName", ud.getLastName());
		params.addValue("preferredName", ud.getPreferredName());
		params.addValue("gender", ud.getGender());
		params.addValue("genderPronoun", ud.getGenderPronoun());
		params.addValue("email", ud.getEmail());
		params.addValue("address1", ud.getAddress1());
		params.addValue("address2", ud.getAddress2());
		params.addValue("city", ud.getCity());
		params.addValue("state", ud.getState());
		params.addValue("zip", ud.getZip());
//		params.addValue("dob", new java.sql.Date(ud.getDob().getTime()));
		
		String addQuery = "INSERT INTO userdetails (firstName, middleName, lastName, preferredName, gender, "
				+ "genderPronoun, email, address1, address2, city, state, zip) VALUES "
				+ "(:firstName, :middleName, :lastName, :preferredName, :gender, :genderPronoun,"
				+ ":email, :address1, :address2, :city, :state, :zip)";
		
		Integer createResult = mariaDbJdbcTemplate.update(addQuery, 
				params);
		
		if (createResult > 0) {
			System.out.println("Error adding UserDetail to DB.");
		}
		
		return;
	}

	@Override
	public UserDetail getUserDetail(String email) {
		UserDetail ud = null;
		String query = "SELECT * FROM userdetails WHERE email = :email";
		Map<String, Object> params = new HashMap<>();
		params.put("email", email);
		
		try {
			ud = (UserDetail)mariaDbJdbcTemplate.queryForObject(
					query, params, new UserDetailMapper());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return ud;
	}
	
	private final class UserDetailMapper implements RowMapper<UserDetail>{

		@Override
		public UserDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserDetail ud = new UserDetail();
			ud.setFirstName(rs.getString("firstName"));
			ud.setMiddleName(rs.getString("middleName"));
			ud.setLastName(rs.getString("lastName"));
			ud.setPreferredName(rs.getString("preferredName"));
			ud.setGender(rs.getString("gender"));
			ud.setGenderPronoun(rs.getString("genderPronoung"));
			ud.setEmail(rs.getString("email"));
			ud.setAddress1(rs.getString("address1"));
			ud.setAddress2(rs.getString("address2"));
			ud.setCity(rs.getString("city"));
			ud.setState(rs.getString("state"));
			ud.setZip(rs.getInt("zip"));
//			ud.setDob(new java.util.Date(rs.getDate("dob").getTime()));
			
			return ud;
		}
		
	}
	
}
	