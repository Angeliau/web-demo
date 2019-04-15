package cn.edu.haut.service;

import java.util.List;

import cn.edu.haut.entity.ColumnsInfo;

public interface ColumnsService {
	
	List<ColumnsInfo> findColumns(ColumnsInfo columnsInfo);
	
	List<ColumnsInfo> findColumnsWithoutLimit();
	
	int add(ColumnsInfo columnsInfo);
	
	int update(ColumnsInfo columnsInfo);
	
	int deleteColumn(int id);
	
}
