package cn.edu.haut.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.haut.entity.User;

/**
 * @ClassName:  LoginController     
 * @Description:  测试类
 * @author: xb    
 * @date:   2018年9月20日 下午3:31:46   
 * @version V1.0
 */
@Controller
public class LoginController {
//	@RequestMapping("login")
//	public String login1(){
//		System.out.println("跳转至登录页");
//		return "login.jsp";
//	}
	/**
	 * 参数传递使用user实体类封装
	 * @param user
	 * @return
	 */
	@RequestMapping("login2")
	public String login2(User user){
		System.out.println("userName"+user.getUserName());
		System.out.println("userPwd"+user.getUserPwd());
		return "index.jsp";
	}
	/**
	 * 使用jsp内置对象request传递参数
	 * @param request
	 * @return
	 */
	@RequestMapping("login3")
	public String login3(HttpServletRequest request){
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("userPwd");
		System.out.println("userName:"+userName+" "+"pwd:"+pwd);
		return "index.jsp";
	}
	/**
	 * 使用“同名”参数传值
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	@RequestMapping("login4")
	public String login4(String userName,String userPwd){
		System.out.println("username:"+userName+" "+"userpwd:"+userPwd);
		return "index.jsp";
	}
	/**
	 * 返回类型为modelandview,后台数据传给前端页面显示
	 * @return
	 */
	@RequestMapping("findUserList")
	public ModelAndView findUserList(){
		List<User> userList = new ArrayList<User>();
		
		//手动静态填充数据，应从数据库查
		User user1 = new User();
		user1.setId(1);
		user1.setUserName("张三");
		user1.setUserPwd("123");
		
		User user2 = new User();
		user2.setId(2);
		user2.setUserName("李四");
		user2.setUserPwd("123");
		
		User user3 = new User();
		user3.setId(3);
		user3.setUserName("王五");
		user3.setUserPwd("123");
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userList", userList);
		modelAndView.setViewName("userList.jsp");
		
		return modelAndView;
	}
}
