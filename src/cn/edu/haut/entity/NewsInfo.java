package cn.edu.haut.entity;

public class NewsInfo {
	private int id;
	private String title;
	private String content;
	private int columnId;
	private String createTime;
	private int createUserId;
	private String type;
	private String setTopTime;
	private String keyWord;
	//标识置顶、取消置顶
	private String tag;
	
	//新闻栏目名称
	private String columnName;
	//新闻所属栏目信息
	private ColumnsInfo columnsInfo;
	
	//创建人信息
	private User user;
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public ColumnsInfo getColumnsInfo() {
		return columnsInfo;
	}
	public void setColumnsInfo(ColumnsInfo columnsInfo) {
		this.columnsInfo = columnsInfo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getColumnId() {
		return columnId;
	}
	public void setColumnId(int columnId) {
		this.columnId = columnId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSetTopTime() {
		return setTopTime;
	}
	public void setSetTopTime(String setTopTime) {
		this.setTopTime = setTopTime;
	}
}
