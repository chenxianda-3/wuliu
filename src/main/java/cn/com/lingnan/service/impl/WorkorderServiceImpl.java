package cn.com.lingnan.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.lingnan.mapper.WorkorderMapper;
import cn.com.lingnan.pojo.Workorder;
import cn.com.lingnan.pojo.WorkorderExample;
import cn.com.lingnan.pojo.WorkorderExample.Criteria;
import cn.com.lingnan.service.WorkorderService;
import cn.com.lingnan.utils.PageBean;

@Service(value="workorderService")
public class WorkorderServiceImpl  implements WorkorderService{
	@Autowired
	private  WorkorderMapper workorderMapper;

	@Override
	public void save(Workorder workorder)  {
		Workorder workorder2 = workorderMapper.selectByPrimaryKey(workorder.getId());
		if(workorder2==null){
			workorderMapper.insertSelective(workorder);
		}else{
			update(workorder);
		}
		
	}

	@Override
	public void pageQuery(PageBean pageBean,Workorder workorder) {
		WorkorderExample workorderExample = new WorkorderExample();
		Criteria createCriteria = workorderExample.createCriteria();
	
		if(workorder.getSenderphone()!=null && ""!=workorder.getSenderphone()){
			createCriteria.andSenderphoneEqualTo(workorder.getSenderphone());
		}
		if(workorder.getSenderaddr()!=null && ""!=workorder.getSenderaddr()){
			createCriteria.andSenderaddrLike("%"+workorder.getSenderaddr()+"%");
		}
		if(workorder.getReceiveraddr()!=null && ""!=workorder.getReceiveraddr()){
			createCriteria.andReceiveraddrLike("%"+workorder.getReceiveraddr()+"%");
		}
		
		/*createCriteria.andStationLike("%"+workorder.getStation()+"%");*/
		
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Workorder> workorders = workorderMapper.selectByExample(workorderExample);
		if (!workorders.isEmpty()) {
			pageBean.setRows(workorders);
		}else{
			pageBean.setRows(new ArrayList<Workorder>());
		}
		pageBean.setTotal(page.getTotal());
	}

	@Override
	public void deleteBatch(String ids) {
		WorkorderExample workorderExample = new WorkorderExample();
		Criteria createCriteria = workorderExample.createCriteria();
		String[] split = ids.split(",");
		List<String> asList = Arrays.asList(split);
		createCriteria.andIdIn(asList);
		workorderMapper.deleteByExample(workorderExample);
		
	}

	@Override
	public Workorder findById(String id) {
		
		return workorderMapper.selectByPrimaryKey(id);
	}
	
	
	@Override
	public List<Workorder> findAll() {
		WorkorderExample workorderExample = new WorkorderExample();
		return workorderMapper.selectByExample(workorderExample);
	}

	@Override
	public int update(Workorder workorder) {
		return workorderMapper.updateByPrimaryKeySelective(workorder);
		
	}
	

}
