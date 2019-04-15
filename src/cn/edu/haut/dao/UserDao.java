package cn.edu.haut.dao;

import java.util.List;

//import org.apache.ibatis.annotations.Param;

import cn.edu.haut.entity.User;

public interface UserDao {
	//查询用户列表,方法名称和mapper.xml文件的sql语句id一致
	List<User> findUserLists(User user);//带限定条件的查询
	
	List<User> findAll();//不带限定条件的查询
	
	//登录校验
	User findUser(User user);

	//添加用户
	int add(User user);
	
	//更新账户
	int update(User user);
	
	//删除账户
	int delete(int id);
		
	//根据用户名和密码查询用户
	//注解的两个参数会自动封装成map集合，括号内即为键
	//public void findUserByNameAndPwd(@Param("name")String name, @Param("password")String password);

}
