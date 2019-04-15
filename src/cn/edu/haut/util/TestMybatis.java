package cn.edu.haut.util;

import static org.hamcrest.CoreMatchers.endsWith;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.edu.haut.entity.NewsInfo;
import cn.edu.haut.entity.User;

/**
 * 
 * @Title:  TestMybatis     
 * @Description: mybatis入门测试类 
 * @author: xb    
 * @date:   2018年9月19日 下午2:19:27   
 * @version V1.0
 */
public class TestMybatis {
	@Test
	public void testInsert() throws IOException{
		//1.mybatis的配置文件
		String resource="mybatis/sqlMapConfig.xml";
		//2.得到配置文件的文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//3.创建会话工厂,传入mybatis配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//4.通过SqlsessionFactory得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.通过SqlSession操作数据库
		User u1=new User();
		u1.setUserName("令狐冲");
		u1.setUserPwd("000");
		// 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		sqlSession.insert("user.insert", u1);
		//提交更新至数据库
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void testUpdate() throws IOException{
		String resource="mybatis/sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User u=new User();
		u.setId(1);
		u.setUserName("东方不败");
		u.setUserPwd("666");
		sqlSession.update("user.update", u);
		
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void testDelete() throws IOException{
		String resource="mybatis/sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.delete("user.delete", 4);
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void testFindUser1() throws IOException{
		String resource="mybatis/sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//使用resultType时，数据库表字段名和实体类属性名不一致的列无法映射
		List<User> lists = sqlSession.selectList("user.findUser1");
		for(User u:lists){
			System.out.println("id:"+u.getId()+" "+"name:"+u.getUserName()+" "+"pwd:"+u.getUserPwd());
		}
		sqlSession.close();
	}
	@Test
	public void testFindUser2() throws IOException{
		String resource="mybatis/sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user=new User();
		user.setUserName("李四");
		//输出映射类型为resultMap
		List<User> lists = sqlSession.selectList("user.findUser2",user);
		for(User u:lists){
			System.out.println("id:"+u.getId()+" "+"name:"+u.getUserName()+
					" "+"pwd:"+u.getUserPwd());
		}
		sqlSession.close();
	}
	@Test
	public void testFindUser3() throws IOException{
		String resource="mybatis/sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user=new User();
//		user.setUserName("李四");
		user.setUserPwd("123");
		//输出映射类型为resultMap
		List<User> lists = sqlSession.selectList("user.findUser3",user);
		for(User u:lists){
			System.out.println("id:"+u.getId()+" "+"name:"+u.getUserName()+" "+"pwd:"+u.getUserPwd());
		}
		sqlSession.close();
	}
	@Test
	public void testFindNews() throws IOException{
		String resource="mybatis/sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<NewsInfo> newsLists = sqlSession.selectList("newsinfo.findNews");
		for(NewsInfo news:newsLists){
			System.out.println("news_id:"+news.getId()+" "+"news_title:"+
			news.getTitle()+"  "+"栏目名称："+news.getColumnName());
		}
	}
	/**
	 * 查询新闻关联查询用户信息
	 * @throws IOException
	 */
	@Test
	public void testFindNews2() throws IOException{
		String resource="mybatis/sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<NewsInfo> newsLists = sqlSession.selectList("newsinfo.findNews2");
		for(NewsInfo news:newsLists){
			System.out.println("news_id:"+news.getId()+" "+"news_title:"+
			news.getTitle()+"  "+"用户id:"+news.getUser().getId()+" 用户名："+
			news.getUser().getUserName()+" 用户密码："+news.getUser().getUserPwd());
		}
	}
	/**
	 * 多表关联查询
	 * @throws IOException
	 */
	@Test
	public void testFindNews3() throws IOException{
		String resource="mybatis/sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<NewsInfo> newsLists = sqlSession.selectList("newsinfo.findNews3");
		for(NewsInfo news:newsLists){
			System.out.println("news_id:"+news.getId()+" "+"news_title:"+
			news.getTitle()+"  "+"用户id:"+news.getUser().getId()+" 用户名："+
			news.getUser().getUserName()+" 用户密码："+
			news.getUser().getUserPwd()+" 所属栏目: "+news.getColumnName());
		}
		sqlSession.close();
	}
}
