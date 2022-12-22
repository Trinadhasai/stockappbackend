package com.example.demo.Dao;

import java.util.List;

import com.example.demo.Model.User;

public interface IUserService {
	
	public List<User> getAllUsers();
	
	public User addUser(User user);
	
	public boolean validateUser(String username,String password);
}
	
