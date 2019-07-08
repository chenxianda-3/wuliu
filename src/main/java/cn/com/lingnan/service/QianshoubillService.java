package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Qianshoubill;
import cn.com.lingnan.pojo.Chukudetails;
import cn.com.lingnan.pojo.Combinedetails;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.utils.PageBean;

public interface QianshoubillService {


	public void deleteBatch(String ids);


	public int update(Qianshoubill qianshoubill);

	void pageQuery(PageBean pageBean, Qianshoubill qianshoubill, String station);


	List<Qianshoubill> findAll();



	Qianshoubill findById(String id, User user);




	void save(String workorderIds, User user, String type);




	boolean saveQuick(Qianshoubill qianshoubill, User user);

}
