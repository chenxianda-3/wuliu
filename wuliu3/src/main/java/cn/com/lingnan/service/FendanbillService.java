package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Fendanbill;
import cn.com.lingnan.pojo.Rukudetails;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.utils.PageBean;

public interface FendanbillService {

	public void save(Fendanbill fendanbill) ;

	public void deleteBatch(String ids, User user);


	public int update(Fendanbill fendanbill);

	void pageQueryOfFendaned(PageBean pageBean, Fendanbill fendanbill);


	List<Fendanbill> findAll();


	public void pageQueryOfNoFendan(PageBean pageBean, Rukudetails rukudetails, String operateunit);





	Fendanbill findByIdAndStation(String id, String station);

	void handFendan(String workorderIds, String deliveryunitId, User user);

	public void findFendanedToDeliveryunit(PageBean pageBean, Fendanbill fendanbill, User user);



}
