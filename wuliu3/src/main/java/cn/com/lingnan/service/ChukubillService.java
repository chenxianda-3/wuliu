package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Chukubill;
import cn.com.lingnan.pojo.Chukudetails;
import cn.com.lingnan.pojo.Combinedetails;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.utils.PageBean;

public interface ChukubillService {


	public void deleteBatch(String ids);

	public Chukubill findById(String id);

	public int update(Chukubill chukubill);

	void pageQuery(PageBean pageBean, Chukubill chukubill, String station);


	List<Chukubill> findAll();



	void save(Chukubill chukubill, String workorderIds, User user);

	List<Chukudetails> findChukudetailsByid(String id);

}
