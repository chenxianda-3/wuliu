package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Peizaiinfo;
import cn.com.lingnan.pojo.Rukudetails;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.utils.PageBean;

public interface PeizaiinfoService {

	public void save(Peizaiinfo peizaiinfo) ;

	public void deleteBatch(String ids, User user);


	public int update(Peizaiinfo peizaiinfo);

	void pageQueryOfPeizaied(PageBean pageBean, Peizaiinfo peizaiinfo);


	List<Peizaiinfo> findAll();


	public void pageQueryOfNoPeizai(PageBean pageBean, Rukudetails rukudetails, String operateunit);


	void autoPeizai(String operateunit);


	void handPeizai(String workorderIds, String lineId, String operateunit);

	Peizaiinfo findByIdAndStation(String id, String station);


}
