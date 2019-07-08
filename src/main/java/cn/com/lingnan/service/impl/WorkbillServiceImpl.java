package cn.com.lingnan.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.rules.DisableOnDebug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.lingnan.mapper.WorkbillMapper;
import cn.com.lingnan.pojo.Decidedzone;
import cn.com.lingnan.pojo.Noticebill;
import cn.com.lingnan.pojo.Workbill;
import cn.com.lingnan.pojo.Workbill;
import cn.com.lingnan.pojo.WorkbillExample;
import cn.com.lingnan.pojo.Workbill;
import cn.com.lingnan.pojo.WorkbillExample;
import cn.com.lingnan.pojo.WorkbillExample.Criteria;
import cn.com.lingnan.service.DecidedzoneService;
import cn.com.lingnan.service.NoticebillService;
import cn.com.lingnan.service.WorkbillService;
import cn.com.lingnan.utils.PageBean;
import cn.com.lingnan.utils.UUIDUtils;

@Service(value="workbillService")
public class WorkbillServiceImpl  implements WorkbillService{
	@Autowired
	private  WorkbillMapper workbillMapper;
	
	@Resource(name = "decidedzoneService")
	private DecidedzoneService decidedzoneService;
	
	@Resource(name = "noticebillService")
	private NoticebillService noticebillService;

	@Override
	public void save(Workbill workbill)  {
	
	workbillMapper.insertSelective(workbill);
	
		
	}


	@Override
	public void delete(String id) {
		workbillMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public Workbill findById(String id) {
		
		return workbillMapper.selectWorkbillById(id);
	}
	
	
	@Override
	public List<Workbill> findAll() {
		WorkbillExample workbillExample = new WorkbillExample();
		return workbillMapper.selectByExample(workbillExample);
	}

	@Transactional
	@Override
	public void update(Workbill workbill) {
		Decidedzone decidedzone = decidedzoneService.findByDecidedzoneName(workbill.getPickaddress());
		if (decidedzone==null) {
			workbill.setStaffId(null);
		}else{
			workbill.setStaffId(decidedzone.getStaffId());
		}
			
		
		Workbill findById = findById(workbill.getId());
		//如果地址发生改变，改变对应的分区就重新生成工单
		if (null!=decidedzone &&!decidedzone.getStaffId().equals(findById.getStaffId())) {
			//将之前的工单销单
			Workbill workbill2 = new Workbill();
			workbill2.setId(workbill.getId());
			workbill2.setType(Workbill.DELETE_BILL);
			 workbillMapper.updateByPrimaryKeySelective(workbill2);
			//生成新的工单
			 Workbill workbill3 = findById;
			 workbill3.setPickaddress(workbill.getPickaddress());
			 workbill3.setPicktime(workbill.getPicktime());
			 workbill3.setAttachbilltimes(0);//追单次数
			 workbill3.setBuildtime(new Timestamp(System.currentTimeMillis()));//创建时间，当前系统时间
			 workbill3.setPickstate(Workbill.PICKSTATE_QUEREN);
			 workbill3.setId(UUIDUtils.getId());
			 workbill3.setRemark(workbill.getRemark());
			 workbill3.setStaffId(decidedzone.getStaffId());
			 save(workbill3);
			 
			
		}
		//如果没发生改变就更新工单即可
		else{
			System.out.println("yyy");
			findById.setBuildtime(new Timestamp(System.currentTimeMillis()));
			findById.setPickaddress(workbill.getPickaddress());
			findById.setPicktime(workbill.getPicktime());
			findById.setStaffId(workbill.getStaffId());
			findById.setRemark(workbill.getRemark());
			workbillMapper.updateByPrimaryKey(findById);		}
		
		 //改变业务受理单
		Noticebill noticebill = workbill.getNoticebill();
		noticebill.setRemark(workbill.getRemark());
		 noticebillService.update(noticebill);
		
	}
	
	
	@Override
	public   void  diaoDu(String ids){
		String[] split = ids.split(",");
		for (int i = 0; i < split.length; i++) {
			String string = split[i];
			Workbill workbill = findById(string);
			Decidedzone decidedzone = decidedzoneService.findByDecidedzoneName(workbill.getPickaddress());
			if (decidedzone==null) {
				workbill.setStaffId(null);
			}else{
				workbill.setStaffId(decidedzone.getStaffId());
			}
			workbillMapper.updateByPrimaryKey(workbill);
		}
		
	}

	@Override
	public String attachBill(String id){
		Workbill workbill = workbillMapper.selectByPrimaryKey(id);
		if (Workbill.DELETE_BILL.equals(workbill.getType()) || Workbill.PICKSTATE_QUJIAN.equals(workbill.getPickstate())) {
			return "noallow";
		}
		workbill.setAttachbilltimes(workbill.getAttachbilltimes()+1);
		workbill.setType(Workbill.ATTACH_BILL);
		workbillMapper.updateByPrimaryKeySelective(workbill);
		return  "true";
	}

	@Override
	public String deleteBatch(String ids) {
		int j=0;
		WorkbillExample workbillExample = new WorkbillExample();
		Criteria createCriteria = workbillExample.createCriteria();
		String[] split = ids.split(",");
		for (int i = 0; i < split.length; i++) {
			String string = split[i];
			System.out.println(findById(string).getPickstate());
			if(Workbill.PICKSTATE_QUJIAN.equals(findById(string).getPickstate())){
				System.out.println("hhh");
				continue;
			}
			createCriteria.andIdEqualTo(string);
			Workbill workbill = new Workbill();
			workbill.setType(Workbill.DELETE_BILL);
			workbillMapper.updateByExampleSelective(workbill, workbillExample)	;	
			j++;
		}
		if (j==split.length) {
			return "true";
		}else{
			return "noallow";
		}
		
	}


	@Override
	public void pageQuery(PageBean pageBean, Workbill workbill) {
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Workbill> workbills = workbillMapper.selectWorkbill(workbill);
		if (!workbills.isEmpty()) {
			pageBean.setRows(workbills);
		} else {
			pageBean.setRows(new ArrayList<Workbill>());
		}
		pageBean.setTotal(page.getTotal());
		
	}

	

	@Override
	public int saveBatch(List<Workbill> workbillList) {
		return workbillMapper.insertBatch(workbillList);
	}


	@Override
	public void diaoDuBypage(PageBean pageBean, Workbill workbill) {
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Workbill> workbills = workbillMapper.selectDiaoDu(workbill);
		if (!workbills.isEmpty()) {
			pageBean.setRows(workbills);
		} else {
			pageBean.setRows(new ArrayList<Workbill>());
		}
		pageBean.setTotal(page.getTotal());
		
		
	}


	@Override
	public void updateStaffId(Workbill workbill) {
		workbillMapper.updateByPrimaryKeySelective(workbill);
		
	}
	

	

}
