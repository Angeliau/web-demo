package cn.edu.haut.dao;

import java.util.List;

import cn.edu.haut.entity.NewsInfo;

public interface NewsInfoDao {
	//新闻列表展示
	List<NewsInfo> find(NewsInfo newsInfo);
	
	//置顶功能
	int updateTopState(NewsInfo newsInfo);
	
	int add(NewsInfo newsInfo);
	
}
