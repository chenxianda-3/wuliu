package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Rukubill;
import cn.com.lingnan.pojo.Rukudetails;
import cn.com.lingnan.pojo.Combinedetails;
import cn.com.lingnan.utils.PageBean;

public interface RukubillService {


	public void deleteBatch(String ids);

	public Rukubill findById(String id);

	public int update(Rukubill rukubill);

	void pageQuery(PageBean pageBean, Rukubill rukubill, String station);


	List<Rukubill> findAll();



	void save(Rukubill rukubill, List<Rukudetails> rukudetails);

	List<Rukudetails> findRukudetailsByid(String id);

}
