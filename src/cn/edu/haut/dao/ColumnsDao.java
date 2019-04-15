package cn.edu.haut.dao;

import java.util.List;

import cn.edu.haut.entity.ColumnsInfo;

public interface ColumnsDao {
	//栏目列表查询
	List<ColumnsInfo> findColumns(ColumnsInfo columnsInfo);
	
	//全部列表查询
	List<ColumnsInfo> findColumnsWithoutLimit();
	
	//添加栏目
	int add(ColumnsInfo columnsInfo);
	
	//编辑栏目信息
	int update(ColumnsInfo columnsInfo);
	
	//删除栏目
	int deleteColumn(int id);
}
