package cn.edu.haut.service;

import java.util.List;

import cn.edu.haut.entity.User;

public interface UserService {
	
	List<User> findUserLists(User user);
	
	List<User> findAll();
	
	User findUser(User user);
	
	int add(User user);
	
	int update(User user);
	
	int delete(int id);
	//登录校验
	//void login(String userName,String userPwd);
	
	//用户注册
	//void regist(User user);
	
	//用户登录
	//void login(String name, String password);

}
