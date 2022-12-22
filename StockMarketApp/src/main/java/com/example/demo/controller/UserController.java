package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.IUserService;
import com.example.demo.Model.User;

@RestController
@RequestMapping("api/v1")

public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("getAllUsers")
	public ResponseEntity<?> getAllUsers()
	{
		List<User> userList=userService.getAllUsers();
		
		if(userList!=null)
		{
			return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
		}
		return new ResponseEntity<String>("List is Empty",HttpStatus.NO_CONTENT);
	}
	
	
//	@PostMapping("/addUser")
//	public ResponseEntity<?> addUser(@RequestBody User user)
//	{
//		User user1 = userService.addUser(user);
//		if(user1!=null)
//		{
//			return new ResponseEntity<String>("User is added", HttpStatus.CREATED);
//		}
//		else
//			return new ResponseEntity<String>("User cannot be added", HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user)
	{
		User user1 = userService.addUser(user);
		if(user1!=null)
		{
			return new ResponseEntity<String>("User is added", HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<String>("User cannot be added", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
