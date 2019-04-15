package cn.edu.haut.entity;

/**
 * 
 * @ClassName:  User     
 * @Description:  
 * @author: xb    
 * @date:   2018年9月20日 上午11:07:36   
 * @version V1.0
 */
public class User {
	private int id;
	//对应表单中的name属性值，提交表单时会自动将表单内容封装到User中
	private String userName;
	private String userPwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
}
