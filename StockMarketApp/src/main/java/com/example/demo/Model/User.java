package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private int id;
	private String username;
	private String password;
	
//	List<String> userList=new ArrayList<String>();
//
//	
//	public List<String> getUserList() {
//		return userList;
//	}
//	public void setUserList(List<String> userList) {
//		this.userList = userList;
//	}
//	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
