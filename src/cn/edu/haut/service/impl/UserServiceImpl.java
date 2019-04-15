package cn.edu.haut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.haut.dao.UserDao;
import cn.edu.haut.entity.User;
import cn.edu.haut.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	/**
	 * 校验用户登录
	 */
	@Override
	public User findUser(User user) {
		
		System.out.println("2.Service方法...");
		
		return userDao.findUser(user);
		
	}

	/**
	 * 查询用户列表
	 */
	@Override
	public List<User> findUserLists(User user) {
		
		return userDao.findUserLists(user);
	}

	/**
	 * 添加用户
	 */
	@Override
	public int add(User user) {
		
		return userDao.add(user);
		
	}

	/**
	 * 查询全部用户列表
	 */
	@Override
	public List<User> findAll() {
	
		return userDao.findAll();
		
	}

	@Override
	public int update(User user) {
		
		return userDao.update(user);
	}

	@Override
	public int delete(int id) {
		
		return userDao.delete(id);
	}
	
}
