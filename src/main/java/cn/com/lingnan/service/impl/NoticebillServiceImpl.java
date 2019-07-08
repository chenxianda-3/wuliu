package cn.com.lingnan.service.impl;



import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lingnan.mapper.NoticebillMapper;
import cn.com.lingnan.pojo.Decidedzone;
import cn.com.lingnan.pojo.Noticebill;
import cn.com.lingnan.pojo.Workbill;
import cn.com.lingnan.service.DecidedzoneService;
import cn.com.lingnan.service.NoticebillService;
import cn.com.lingnan.service.WorkbillService;
import cn.com.lingnan.utils.UUIDUtils;

@Service(value="noticebillService")
public class NoticebillServiceImpl  implements NoticebillService{
	@Autowired
	private  NoticebillMapper noticebillMapper;
	
	@Resource(name = "decidedzoneService")
	private DecidedzoneService decidedzoneService;
	
	@Resource(name = "workbillService")
	private WorkbillService workbillService;

	@Transactional
	@Override
	public void save(Noticebill noticebill)  {
		Decidedzone decidedzone = decidedzoneService.findByDecidedzoneName(noticebill.getPickaddress());
		//查询到相关的定区就自动分单成功,否则失败转人工调度
		if (decidedzone != null) {
			noticebill.setStaffId(decidedzone.getStaffId());
			noticebill.setOrdertype(Noticebill.ORDERTYPE_AUTO);
		}else{
			noticebill.setOrdertype(Noticebill.ORDERTYPE_MAN);
		}
		noticebillMapper.insertSelective(noticebill);
		//自动生成工作单
		Workbill workbill = new Workbill();
		workbill.setId(UUIDUtils.getId());
		workbill.setAttachbilltimes(0);//追单次数
		workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));//创建时间，当前系统时间
		workbill.setNoticebillId(noticebill.getId());
		workbill.setPickstate(Workbill.PICKSTATE_QUEREN);
		workbill.setRemark(noticebill.getRemark());//备注信息
		workbill.setPicktime(noticebill.getPickdate());
		workbill.setPickaddress(noticebill.getPickaddress());
		workbill.setStation(noticebill.getStation());
		
		if (decidedzone != null) {
			workbill.setStaffId(decidedzone.getStaffId());
		}
		workbill.setType(Workbill.NEW_BILL);
		workbillService.save(workbill);
		//保存业务受理单
	
		
		
	}
	
	
	@Override
	public int update(Noticebill noticebill) {
		return noticebillMapper.updateByPrimaryKeySelective(noticebill);
		
	}

}
