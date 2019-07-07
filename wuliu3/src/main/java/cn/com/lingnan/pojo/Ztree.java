package cn.com.lingnan.pojo;

public class Ztree {
	
	private   String id;
	private String pId;
	private  String name;
	private  String page;
	public Ztree(String id, String pId, String name, String page) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.page = page;
	}
	public Ztree() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "Ztree [id=" + id + ", pId=" + pId + ", name=" + name + ", page=" + page + "]";
	}
	
	

}
