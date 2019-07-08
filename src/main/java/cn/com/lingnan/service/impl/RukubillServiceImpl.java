package cn.com.lingnan.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.lingnan.mapper.ChukubillMapper;
import cn.com.lingnan.mapper.RukubillMapper;
import cn.com.lingnan.mapper.RukudetailsMapper;
import cn.com.lingnan.mapper.WorkorderMapper;
import cn.com.lingnan.pojo.Chukubill;
import cn.com.lingnan.pojo.Combinedetails;
import cn.com.lingnan.pojo.CombinedetailsExample;
import cn.com.lingnan.pojo.Rukubill;
import cn.com.lingnan.pojo.RukubillExample;
import cn.com.lingnan.pojo.RukubillExample.Criteria;
import cn.com.lingnan.pojo.Rukudetails;
import cn.com.lingnan.pojo.RukudetailsExample;
import cn.com.lingnan.pojo.Workorder;
import cn.com.lingnan.service.RukubillService;
import cn.com.lingnan.utils.PageBean;

@Service(value="rukubillService")
public class RukubillServiceImpl  implements RukubillService{
	@Autowired
	private  RukubillMapper rukubillMapper;
	
	@Autowired
	private  RukudetailsMapper rukudetailsMapper;
	
	@Autowired
	private  ChukubillMapper chukubillMapper;
	
	@Autowired
	private  WorkorderMapper workorderMapper;
	


	@Transactional
	@Override
	public void save(Rukubill rukubill,List<Rukudetails> rukudetails)  {
		String chukubillId = rukudetails.get(0).getChukubillId();
		rukubill.setJiehuotime(new Timestamp(System.currentTimeMillis()));
		if (chukubillId != null && !chukubillId.isEmpty()) {
			Chukubill chukubill = chukubillMapper.selectByPrimaryKey(chukubillId);
			rukubill.setFahuostation(chukubill.getJiaohuostation());
		}
		rukubillMapper.insertSelective(rukubill);
		for (Rukudetails rukudetails2 : rukudetails) {
			Workorder workorder = new Workorder();
			workorder.setId(rukudetails2.getWorkorderId());
			workorder.setState(Workorder.PEISONG);
			workorderMapper.updateByPrimaryKeySelective(workorder);
			
			rukudetails2.setRukubillId(rukubill.getId());
			rukudetails2.setChukubillId(null);
			rukudetailsMapper.insertSelective(rukudetails2);
		}
		
	}

	@Override
	public void pageQuery(PageBean pageBean,Rukubill rukubill,String station) {
		RukubillExample rukubillExample = new RukubillExample();
		Criteria createCriteria = rukubillExample.createCriteria();
		if(rukubill.getId()!=null && ""!=rukubill.getId() ){
			createCriteria.andIdLike(rukubill.getId()+"%");
		}
		if(rukubill.getJiehuopeople()!=null && ""!=rukubill.getJiehuopeople()){
			createCriteria.andJiehuopeopleLike("%"+rukubill.getJiehuopeople()+"%");
		}
		createCriteria.andJiehuostationLike("%"+station+"%");

		
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Rukubill> rukubills = rukubillMapper.selectByExample(rukubillExample);
		if (!rukubills.isEmpty()) {
			pageBean.setRows(rukubills);
		}else{
			pageBean.setRows(new ArrayList<Rukubill>());
		}
		pageBean.setTotal(page.getTotal());
	}

	@Override
	public void deleteBatch(String ids) {
		RukubillExample rukubillExample = new RukubillExample();
		Criteria createCriteria = rukubillExample.createCriteria();

		RukudetailsExample rukudetailsExample=new RukudetailsExample();
		cn.com.lingnan.pojo.RukudetailsExample.Criteria createCriteria2 = rukudetailsExample.createCriteria();
		String[] split = ids.split(",");
		for (int i = 0; i < split.length; i++) {
			//删除对应的明细
			createCriteria2.andRukubillIdEqualTo(split[i]);
			rukudetailsMapper.deleteByExample(rukudetailsExample);
			
			createCriteria.andIdEqualTo(split[i]);
			rukubillMapper.deleteByExample(rukubillExample);
		}
		
	}

	@Override
	public Rukubill findById(String id) {
		
		return rukubillMapper.selectByPrimaryKey(id);
	}
	
	
	@Override
	public List<Rukubill> findAll() {
		RukubillExample rukubillExample = new RukubillExample();
		return rukubillMapper.selectByExample(rukubillExample);
	}

	@Override
	public int update(Rukubill rukubill) {
		return rukubillMapper.updateByPrimaryKeySelective(rukubill);
		
	}

	@Override
	public List<Rukudetails> findRukudetailsByid(String id) {
		RukudetailsExample rukudetailsExample=new RukudetailsExample();
		cn.com.lingnan.pojo.RukudetailsExample.Criteria createCriteria2 = rukudetailsExample.createCriteria();
		createCriteria2.andRukubillIdEqualTo(id);
		List<Rukudetails> selectByExample = rukudetailsMapper.selectByExample(rukudetailsExample);
		return selectByExample;
	}
	

	

}
