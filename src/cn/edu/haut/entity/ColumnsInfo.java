package cn.edu.haut.entity;

/**
 * 
 * @ClassName:  ColumnsInfo     
 * @Description:  栏目表实体类
 * @author: xb    
 * @date:   2018年9月25日 上午10:24:35   
 * @version V1.0
 */
public class ColumnsInfo {
	private int id;
	private String columnName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
}
