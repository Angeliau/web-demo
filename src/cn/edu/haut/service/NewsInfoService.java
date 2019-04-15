package cn.edu.haut.service;

import java.util.List;

import cn.edu.haut.entity.NewsInfo;

public interface NewsInfoService {
	
	List<NewsInfo> find(NewsInfo newsInfo);
	
	//置顶功能
	int updateTopState(NewsInfo newsInfo);
	
	int add(NewsInfo newsInfo);
}
