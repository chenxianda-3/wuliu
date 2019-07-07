package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Combinebill;
import cn.com.lingnan.pojo.Combinedetails;
import cn.com.lingnan.utils.PageBean;

public interface CombinebillService {


	public void deleteBatch(String ids);

	public Combinebill findById(String id);

	public int update(Combinebill combinebill);

	void pageQuery(PageBean pageBean, Combinebill combinebill);


	List<Combinebill> findAll();

	void save(Combinebill combinebill, String ids);

	public List<Combinedetails> findCombinedetailsByid(String id);

}
