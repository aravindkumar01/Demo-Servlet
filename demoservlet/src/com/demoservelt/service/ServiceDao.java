package com.demoservelt.service;

import java.util.List;

import com.demoservelt.model.User;

public interface ServiceDao {
 public boolean checkLogin(String uname,String password);
 public List<User> findAll();
 public void addDiv();
}
