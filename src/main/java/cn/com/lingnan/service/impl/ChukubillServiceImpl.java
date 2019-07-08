package cn.com.lingnan.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.lingnan.mapper.ChukubillMapper;
import cn.com.lingnan.mapper.ChukudetailsMapper;
import cn.com.lingnan.mapper.RoutelinebillMapper;
import cn.com.lingnan.pojo.Combinedetails;
import cn.com.lingnan.pojo.CombinedetailsExample;
import cn.com.lingnan.pojo.Peizaiinfo;
import cn.com.lingnan.pojo.Routelinebill;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.pojo.Chukubill;
import cn.com.lingnan.pojo.ChukubillExample;
import cn.com.lingnan.pojo.ChukubillExample.Criteria;
import cn.com.lingnan.pojo.Chukudetails;
import cn.com.lingnan.pojo.ChukudetailsExample;
import cn.com.lingnan.service.ChukubillService;
import cn.com.lingnan.service.PeizaiinfoService;
import cn.com.lingnan.service.WorkorderService;
import cn.com.lingnan.utils.PageBean;

@Service(value="chukubillService")
public class ChukubillServiceImpl  implements ChukubillService{
	@Autowired
	private  ChukubillMapper chukubillMapper;
	
	@Autowired
	private  ChukudetailsMapper chukudetailsMapper;
	
	
	@Autowired
	private   RoutelinebillMapper routelinebillMapper;
	
	

	@Resource(name = "peizaiinfoService")
	private PeizaiinfoService peizaiinfoService;


	@Override
	public void pageQuery(PageBean pageBean,Chukubill chukubill,String station) {
		ChukubillExample chukubillExample = new ChukubillExample();
		Criteria createCriteria = chukubillExample.createCriteria();
		if(chukubill.getId()!=null && ""!=chukubill.getId() ){
			createCriteria.andIdLike(chukubill.getId()+"%");
		}
		if(chukubill.getJiehuopeople()!=null && ""!=chukubill.getJiehuopeople()){
			createCriteria.andJiehuopeopleLike("%"+chukubill.getJiehuopeople()+"%");
		}

		createCriteria.andJiaohuostationLike("%"+station+"%");
		
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Chukubill> chukubills = chukubillMapper.selectByExample(chukubillExample);
		if (!chukubills.isEmpty()) {
			pageBean.setRows(chukubills);
		}else{
			pageBean.setRows(new ArrayList<Chukubill>());
		}
		pageBean.setTotal(page.getTotal());
	}

	@Override
	public void deleteBatch(String ids) {
		ChukubillExample chukubillExample = new ChukubillExample();
		Criteria createCriteria = chukubillExample.createCriteria();

		ChukudetailsExample rukudetailsExample=new ChukudetailsExample();
		cn.com.lingnan.pojo.ChukudetailsExample.Criteria createCriteria2 = rukudetailsExample.createCriteria();
		String[] split = ids.split(",");
		for (int i = 0; i < split.length; i++) {
			//删除对应的明细
			createCriteria2.andChukubillIdEqualTo(split[i]);
			chukudetailsMapper.deleteByExample(rukudetailsExample);
			createCriteria.andIdEqualTo(split[i]);
			chukubillMapper.deleteByExample(chukubillExample);
		}
		
	}

	@Override
	public Chukubill findById(String id) {
		
		return chukubillMapper.selectByPrimaryKey(id);
	}
	
	
	@Override
	public List<Chukubill> findAll() {
		ChukubillExample chukubillExample = new ChukubillExample();
		return chukubillMapper.selectByExample(chukubillExample);
	}

	@Override
	public int update(Chukubill chukubill) {
		return chukubillMapper.updateByPrimaryKeySelective(chukubill);
		
	}

	@Override
	public List<Chukudetails> findChukudetailsByid(String id) {
		ChukudetailsExample chukudetailsExample=new ChukudetailsExample();
		cn.com.lingnan.pojo.ChukudetailsExample.Criteria createCriteria2 = chukudetailsExample.createCriteria();
		createCriteria2.andChukubillIdEqualTo(id);
		List<Chukudetails> selectByExample = chukudetailsMapper.selectByExample(chukudetailsExample);
		return selectByExample;
	}

	@Transactional
	@Override
	public void save(Chukubill chukubill, String workorderIds, User user) {
		chukubill.setJiaohuotime(new Timestamp(System.currentTimeMillis()));
		chukubillMapper.insertSelective(chukubill);
		String[] split = workorderIds.split(",");
		String lindId=null;
		String endCity=null;
		for (int i = 0; i < split.length; i++) {
			String id = split[i];
			Peizaiinfo peizaiinfo = peizaiinfoService.findByIdAndStation(id, user.getStation());
			lindId=peizaiinfo.getLineId();
			endCity=peizaiinfo.getEndcity();
			Chukudetails chukudetails = new  Chukudetails(peizaiinfo.getWorkorderId(), chukubill.getId(), peizaiinfo.getCombineId(), peizaiinfo.getWeight(), peizaiinfo.getProduct(), peizaiinfo.getShouhuopeople(), peizaiinfo.getShouhuoaddress(), peizaiinfo.getTimelimit(), peizaiinfo.getEndcity() );
			chukudetailsMapper.insertSelective(chukudetails);
		}
		chukubill.setLineresource(lindId);
		chukubill.setLinedirection(endCity);
		chukubill.setJiaohuopeople(user.getUsername());
		chukubill.setJiaohuostation(user.getStation());
		chukubillMapper.updateByPrimaryKeySelective(chukubill);
		
	}
	

	

}
