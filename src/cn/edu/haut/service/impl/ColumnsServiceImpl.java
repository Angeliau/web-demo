package cn.edu.haut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.haut.dao.ColumnsDao;
import cn.edu.haut.entity.ColumnsInfo;
import cn.edu.haut.service.ColumnsService;

@Service
public class ColumnsServiceImpl implements ColumnsService {

	@Autowired
	private ColumnsDao columnsDao;
	
	@Override
	public List<ColumnsInfo> findColumns(ColumnsInfo columnsInfo) {
		
		return columnsDao.findColumns(columnsInfo);
		
	}

	@Override
	public int add(ColumnsInfo columnsInfo) {
		
		return columnsDao.add(columnsInfo);
	}

	@Override
	public List<ColumnsInfo> findColumnsWithoutLimit() {
		
		return columnsDao.findColumnsWithoutLimit();
	}

	@Override
	public int update(ColumnsInfo columnsInfo) {
		
		return columnsDao.update(columnsInfo);
	}

	@Override
	public int deleteColumn(int id) {
		
		return columnsDao.deleteColumn(id);
	}

}
