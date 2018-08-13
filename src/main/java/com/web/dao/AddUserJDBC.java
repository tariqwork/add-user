package com.web.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.web.model.User;

/**
 * JDBC implementation for DAO
 * 
 * @author Muhammad Tariq
 *
 */
@Repository
public class AddUserJDBC implements AddUserDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void addUser(User input) throws Exception {
		try {
			String sql = "INSERT INTO world.user (username,firstname,lastname,age) VALUES (:userName,:firstName,:lastName,:age)";
			Map<String,Object> sqlParam = new HashMap<>();
			sqlParam.put("userName", input.getUsername());
			sqlParam.put("firstName", input.getFirstname());
			sqlParam.put("lastName",input.getLastname());
			sqlParam.put("age",  input.getAge());
			jdbcTemplate.update(sql, sqlParam);
		}catch (DuplicateKeyException e) {
			e.printStackTrace();
			throw new DuplicateKeyException("Duplicate entry found for primary key");
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Application internal Error");
		}
		
	}
}
