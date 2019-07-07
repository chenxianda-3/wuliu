package cn.com.lingnan.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntToDoubleFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.lingnan.exception.MyException;
import cn.com.lingnan.mapper.StaffMapper;
import cn.com.lingnan.mapper.UserMapper;
import cn.com.lingnan.pojo.Staff;
import cn.com.lingnan.pojo.StaffExample;
import cn.com.lingnan.pojo.StaffExample.Criteria;
import cn.com.lingnan.service.StaffService;
import cn.com.lingnan.utils.PageBean;

@Service(value="staffService")
public class StaffServiceImpl  implements StaffService{
	@Autowired
	private  StaffMapper staffMapper;

	@Override
	public void save(Staff staff)  {
		Staff staff2 = staffMapper.selectByPrimaryKey(staff.getId());
		if(staff2==null){
			staffMapper.insertSelective(staff);
		}else{
			update(staff);
		}
		
	}

	@Override
	public void pageQuery(PageBean pageBean,Staff staff) {
		StaffExample staffExample = new StaffExample();
		Criteria createCriteria = staffExample.createCriteria();
		if(staff.getId()!=null && ""!=staff.getId() ){
			createCriteria.andIdLike(staff.getId()+"%");
		}
		if(staff.getName()!=null && ""!=staff.getName()){
			createCriteria.andNameLike("%"+staff.getName()+"%");
		}
		if(staff.getTelephone()!=null && ""!=staff.getTelephone()){
			createCriteria.andTelephoneEqualTo(staff.getTelephone());
		}
		createCriteria.andDeltagEqualTo("0");
		
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Staff> staffs = staffMapper.selectByExample(staffExample);
		if (!staffs.isEmpty()) {
			pageBean.setRows(staffs);
		}else{
			pageBean.setRows(new ArrayList<Staff>());
		}
		pageBean.setTotal(page.getTotal());
	}

	@Override
	public void deleteBatch(String ids) {
		StaffExample staffExample = new StaffExample();
		Criteria createCriteria = staffExample.createCriteria();
		String[] split = ids.split(",");
		List<String> asList = Arrays.asList(split);
		createCriteria.andIdIn(asList);
		Staff staff = new Staff();
		staff.setDeltag("1");
		staffMapper.updateByExampleSelective(staff, staffExample);
		
	}

	@Override
	public Staff findById(String id) {
		
		return staffMapper.selectByPrimaryKey(id);
	}
	
	
	@Override
	public List<Staff> findAll() {
		StaffExample staffExample = new StaffExample();
		return staffMapper.selectByExample(staffExample);
	}

	@Override
	public int update(Staff staff) {
		return staffMapper.updateByPrimaryKeySelective(staff);
		
	}
	
	@Override
	public  int  saveBatch(List<Staff> staffList){
		return staffMapper.insertBatch(staffList);
	}
	

}
