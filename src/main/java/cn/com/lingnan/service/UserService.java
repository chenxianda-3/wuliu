package cn.com.lingnan.service;


import cn.com.lingnan.pojo.User;

public interface UserService {

	public User login(User user);

	boolean updateByID(User user);

/*	public void editPassword(String id, String password);

	public void save(User user, String[] roleIds);*/



}
