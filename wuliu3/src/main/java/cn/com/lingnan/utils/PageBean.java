package cn.com.lingnan.utils;
import java.util.List;


public class PageBean {
	private int page;//当前页码
	private int pageSize;//每页显示的记录数
	private long total;//总记录数
	private List rows;//当前页需要展示的数据集合

	
	
	

	public PageBean(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}




	public long getTotal() {
		return total;
	}


	public void setTotal(long total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "PageBean [page=" + page + ", pageSize=" + pageSize + ", total=" + total + ", rows=" + rows + "]";
	}
	
	
	
}
