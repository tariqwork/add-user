package com.web.dao;

import org.springframework.dao.DuplicateKeyException;

import com.web.model.User;

/**
 * Interface for DAO
 * 
 * @author Muhammad Tariq
 *
 */
public interface AddUserDao {
	public void  addUser(User input) throws Exception;
}
