package cn.edu.haut.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.haut.dao.NewsInfoDao;
import cn.edu.haut.entity.NewsInfo;
import cn.edu.haut.service.NewsInfoService;

@Service
public class NewsInfoServiceImpl implements NewsInfoService {
	
	@Autowired
	private NewsInfoDao newsInfoDao;

	@Override
	public List<NewsInfo> find(NewsInfo newsInfo) {
		
		return newsInfoDao.find(newsInfo);
		
	}

	@Override
	public int updateTopState(NewsInfo newsInfo) {
		
		if(newsInfo != null){
			if(newsInfo.getTag()!=null && newsInfo.getTag().equals("0")){
				//取消置顶，将type值设为0
				newsInfo.setType("0");
			}else if(newsInfo.getTag()!=null && newsInfo.getTag().equals("1")){
				//置顶
				newsInfo.setType("1");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				newsInfo.setSetTopTime(sdf.format(new Date()));
			}
		}
		return newsInfoDao.updateTopState(newsInfo);
	}

	@Override
	public int add(NewsInfo newsInfo) {
		
		return newsInfoDao.add(newsInfo);
	}

	
}
