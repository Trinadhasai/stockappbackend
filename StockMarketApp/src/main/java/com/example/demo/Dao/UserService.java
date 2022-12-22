package com.example.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
@Service
public class UserService implements IUserService{

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		List<User> userList=userRepository.findAll();
		if(userList!=null && userList.size()>0)
		{
			System.out.println(userList);
			return userList;
		}
		else
		return null;
	}

	@Override
	public User addUser(User user) {
	
		return userRepository.saveAndFlush(user);
	}

	@Override
	public boolean validateUser(String username, String password) {
		User user=userRepository.validateUser(username, password);
		
		if(user!=null)
		{
			return true;
		}
		else
			return false;
	}

}
