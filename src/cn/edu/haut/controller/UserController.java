package cn.edu.haut.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.haut.entity.User;
import cn.edu.haut.service.UserService;

/**
 * @ClassName: UserController
 * @Description: 用户功能管理模块
 * @author: xb
 * @date: 2018年9月21日 上午10:58:11
 * @version V1.0
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 登录功能
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user, HttpSession session) {

		if ( user.getUserName() != null && !(user.getUserName().equals("")) && user.getUserPwd() != null
				&& !(user.getUserPwd().equals("")) ) {
			System.out.println("1.登录方法...");
			System.out.println("用户名为:" + user.getUserName() + ",密码为:" + user.getUserPwd() + "正在登录");

			User u = userService.findUser(user);

			System.out.println(user.getUserName() + "登录成功");

			session.setAttribute("user", u);
			return "index.jsp";
			
		}else{
			System.out.println("用户"+user.getUserName()+"登录失败");
			return "login.jsp";
		}
	}

	/**
	 * 注销
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login.jsp";
	}
	
	/**
	 * 搜素框查询
	 * @param user
	 * @return
	 */
	@RequestMapping("/findUser")
	public ModelAndView findUser(User user) {

		List<User> userLists = userService.findUserLists(user);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userLists", userLists);
		modelAndView.setViewName("page/AccountManagement.jsp");

		return modelAndView;
	}

	/**
	 * 查询全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public ModelAndView findUserLists() {

		List<User> userLists = userService.findAll();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userLists", userLists);
		modelAndView.setViewName("page/AccountManagement.jsp");

		return modelAndView;
	}

	/**
	 * 添加用户后跳转至全部列表页面
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(User user) {
		int num = userService.add(user);

		System.out.println("添加了" + num + "条记录");

		return "findAll";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(User user){
		int num = userService.update(user);
		System.out.println("更新了"+num+"条数据");
		return "findAll";
	}
	
	/**
	 * 删除用户账户(一条或多条记录)
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(String ids){
		
		if(ids != null && ids.length()>0){
			
			String str[] = ids.split(",");
			
			if(str != null && str.length>0){
				
				for(int i = 0;i<str.length;i++){
					
					int id =Integer.parseInt(str[i]);
					int num = userService.delete(id);
					System.out.println("删除的记录id为"+id+"删除了"+num+"条数据");
					
				}
			}
		}
		return "findAll";
	}

}
