package cn.edu.haut.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.haut.entity.ColumnsInfo;
import cn.edu.haut.entity.NewsInfo;
import cn.edu.haut.entity.User;
import cn.edu.haut.service.ColumnsService;
import cn.edu.haut.service.NewsInfoService;

@Controller
public class NewsInfoController {
	
	@Autowired
	private NewsInfoService newsInfoService;
	@Autowired
	private ColumnsService columnsService;
	
	@RequestMapping("findNewsList")
	public ModelAndView findNewsList(NewsInfo newsInfo){
		ModelAndView modelAndView=new ModelAndView();
		List<NewsInfo> newsList=newsInfoService.find(newsInfo);
		
		//System.out.println(newsList);
		
		List<ColumnsInfo> columnsList=columnsService.findColumns(null);
		modelAndView.addObject("columnsList", columnsList);
		
		modelAndView.addObject("newsList", newsList);
		modelAndView.setViewName("page/NewsList.jsp");
		
		return modelAndView;
	}
	@RequestMapping("setNewsTop")
	public String updateTopState(NewsInfo newsInfo){
		
		int num=newsInfoService.updateTopState(newsInfo);
		System.out.println("置顶/取消置顶了"+num+"条新闻");
		return "findNewsList";
	}
	
	@RequestMapping("toNewsAdd")
	public ModelAndView toAdd(){
		ModelAndView modelAndView=new ModelAndView();
		List<ColumnsInfo> columnsList=columnsService.findColumnsWithoutLimit();
		modelAndView.addObject("columnsList", columnsList);
		modelAndView.setViewName("page/NewsManagement.jsp");
		return modelAndView;
	}
	@RequestMapping("addNews")
	public String addNews(NewsInfo newsInfo,HttpSession session){
		
		User user=(User) session.getAttribute("user");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		newsInfo.setCreateTime(sdf.format(new Date()));
		
		newsInfo.setCreateUserId(user.getId());
		if(newsInfo.getType()!=null && newsInfo.getType().equals("1")){
			newsInfo.setSetTopTime(sdf.format(new Date()));
		} 
		newsInfoService.add(newsInfo);
		return "findNewsList";
	}
}
