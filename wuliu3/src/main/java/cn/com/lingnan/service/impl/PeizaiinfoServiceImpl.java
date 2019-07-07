package cn.com.lingnan.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.lingnan.mapper.CombinebillMapper;
import cn.com.lingnan.mapper.PeizaiinfoMapper;
import cn.com.lingnan.mapper.RoutebillMapper;
import cn.com.lingnan.mapper.RoutelinebillMapper;
import cn.com.lingnan.mapper.RukubillMapper;
import cn.com.lingnan.mapper.RukudetailsMapper;
import cn.com.lingnan.pojo.Combinebill;
import cn.com.lingnan.pojo.CombinebillExample;
import cn.com.lingnan.pojo.Peizaiinfo;
import cn.com.lingnan.pojo.PeizaiinfoExample;
import cn.com.lingnan.pojo.PeizaiinfoExample.Criteria;
import cn.com.lingnan.pojo.Routebill;
import cn.com.lingnan.pojo.RoutebillExample;
import cn.com.lingnan.pojo.Routelinebill;
import cn.com.lingnan.pojo.Rukubill;
import cn.com.lingnan.pojo.RukubillExample;
import cn.com.lingnan.pojo.Rukudetails;
import cn.com.lingnan.pojo.RukudetailsExample;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.pojo.Workorder;
import cn.com.lingnan.service.PeizaiinfoService;
import cn.com.lingnan.service.WorkorderService;
import cn.com.lingnan.utils.PageBean;

@Service(value="peizaiinfoService")
public class PeizaiinfoServiceImpl  implements PeizaiinfoService{
	@Autowired
	private  PeizaiinfoMapper peizaiinfoMapper;
	
	@Autowired
	private  RukudetailsMapper rukudetailsMapper;
	
	@Autowired
	private   RukubillMapper rukubillMapper;
	
	@Autowired
	private   CombinebillMapper combinebillMapper;
	
	@Autowired
	private   RoutebillMapper routebillMapper;
	
	@Autowired
	private   RoutelinebillMapper routelinebillMapper;
	
	@Resource(name = "workorderService")
	private WorkorderService workorderService;

	@Override
	public void save(Peizaiinfo peizaiinfo)  {
		Peizaiinfo peizaiinfo2 = peizaiinfoMapper.selectByPrimaryKey(peizaiinfo.getWorkorderId());
		if(peizaiinfo2==null){
			peizaiinfoMapper.insertSelective(peizaiinfo);
		}else{
			update(peizaiinfo);
		}
		
	}

	@Override
	public void pageQueryOfPeizaied(PageBean pageBean,Peizaiinfo peizaiinfo) {
		PeizaiinfoExample peizaiinfoExample = new PeizaiinfoExample();
		Criteria createCriteria = peizaiinfoExample.createCriteria();
		if(peizaiinfo.getWorkorderId()!=null && ""!=peizaiinfo.getWorkorderId() ){
			createCriteria.andWorkorderIdLike(peizaiinfo.getWorkorderId()+"%");
		}
		createCriteria.andOperateunitLike("%"+peizaiinfo.getOperateunit()+"%");	
		
		
		
		
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Peizaiinfo> peizaiinfos = peizaiinfoMapper.selectByExample(peizaiinfoExample);
		if (!peizaiinfos.isEmpty()) {
			pageBean.setRows(peizaiinfos);
		}else{
			pageBean.setRows(new ArrayList<Peizaiinfo>());
		}
		pageBean.setTotal(page.getTotal());
	}
	
	
	@Override
	public void pageQueryOfNoPeizai(PageBean pageBean, Rukudetails rukudetails, String jiehuostation) {
		//找到已配载中的所有工作单id,需要有地址作为参数
		PeizaiinfoExample peizaiinfoExample=new PeizaiinfoExample();
		Criteria createCriteria3 = peizaiinfoExample.createCriteria();
		createCriteria3.andOperateunitLike("%"+jiehuostation+"%");
		List<String> ids=peizaiinfoMapper.selectAllWorkorderId(peizaiinfoExample);
		//根据地点找到入库单，再从对应的入库单找到明细
		RukubillExample rukubillExample=new RukubillExample();
		cn.com.lingnan.pojo.RukubillExample.Criteria createCriteria2 = rukubillExample.createCriteria();
		createCriteria2.andJiehuostationLike("%"+jiehuostation+"%");
		List<Rukubill> rukubills = rukubillMapper.selectByExample(rukubillExample);
		//遍历入库单找到明细
		List<String> rukubillids=new ArrayList<>();
		
		RukudetailsExample rukudetailsExample = new RukudetailsExample();
		cn.com.lingnan.pojo.RukudetailsExample.Criteria createCriteria = rukudetailsExample.createCriteria();
		
		if (rukubills.size()>0) {
			for (Rukubill rukubill : rukubills) {
				rukubillids.add(rukubill.getId());
			}
			//
			createCriteria.andRukubillIdIn(rukubillids);
		}else{
			return;
		}
		
		if (ids.size()>0) {
			//
			createCriteria.andWorkorderIdNotIn(ids);
		}
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Rukudetails> selectByExample = rukudetailsMapper.selectByExample(rukudetailsExample);
		if (!selectByExample.isEmpty()) {
			pageBean.setRows(selectByExample);
		}else{
			pageBean.setRows(new ArrayList<Rukudetails>());
		}
		pageBean.setTotal(page.getTotal());
		
	}

	@Override
	public void deleteBatch(String ids, User user) {
		PeizaiinfoExample peizaiinfoExample = new PeizaiinfoExample();
		Criteria createCriteria = peizaiinfoExample.createCriteria();
		String[] split = ids.split(",");
		List<String> asList = Arrays.asList(split);
		createCriteria.andWorkorderIdIn(asList);
		createCriteria.andOperateunitLike("%"+user.getStation()+"%");
		peizaiinfoMapper.deleteByExample(peizaiinfoExample);
		
	}

	@Override
	public Peizaiinfo findByIdAndStation(String id,String station) {
		PeizaiinfoExample peizaiinfoExample = new PeizaiinfoExample();
		Criteria createCriteria = peizaiinfoExample.createCriteria();
		createCriteria.andWorkorderIdEqualTo(id);
		createCriteria.andOperateunitLike("%"+station+"%");
		return peizaiinfoMapper.selectByExample(peizaiinfoExample).get(0);
	}
	
	
	@Override
	public List<Peizaiinfo> findAll() {
		PeizaiinfoExample peizaiinfoExample = new PeizaiinfoExample();
		return peizaiinfoMapper.selectByExample(peizaiinfoExample);
	}

	@Override
	public int update(Peizaiinfo peizaiinfo) {
		return peizaiinfoMapper.updateByPrimaryKeySelective(peizaiinfo);
		
	}

	@Transactional
	@Override
	public void autoPeizai(String operateunit) {
		//获取合包单
		CombinebillExample combinebillExample=new CombinebillExample();
		cn.com.lingnan.pojo.CombinebillExample.Criteria createCriteria = combinebillExample.createCriteria();
		createCriteria.andCombinepeopleEqualTo("aaaaa");
		Combinebill combinebill = combinebillMapper.selectByExample(combinebillExample).get(0);
		
		//根据合包单的到达地址选取线路
		RoutebillExample routebillExample=new RoutebillExample();
		cn.com.lingnan.pojo.RoutebillExample.Criteria createCriteria2 = routebillExample.createCriteria();
		createCriteria2.andEndcityLike("%"+combinebill.getDestination()+"%");
		createCriteria2.andFlagEqualTo("1");
		Routebill routebill = routebillMapper.selectByExample(routebillExample).get(0);
		
		//找到对应的合包单id的下的入库明细
		RukudetailsExample rukudetailsExample = new RukudetailsExample();
		cn.com.lingnan.pojo.RukudetailsExample.Criteria createCriteria3 = rukudetailsExample.createCriteria();
		createCriteria3.andCombineorderIdEqualTo(combinebill.getId());
		List<Rukudetails> rukudetails = rukudetailsMapper.selectByExample(rukudetailsExample);
		
		//对入库明细进行配载
		for (Rukudetails rukudetails2 : rukudetails) {
			Workorder workorder = workorderService.findById(rukudetails2.getWorkorderId());
			Peizaiinfo peizaiinfo = new Peizaiinfo(rukudetails2.getWorkorderId(), rukudetails2.getCombinebillId(), operateunit, routebill.getName(), routebill.getEndcity(), combinebill.getTimelimit(), workorder.getFloadreqr(), workorder.getReceivername(), workorder.getReceiveraddr(),"0");
			peizaiinfoMapper.insertSelective(peizaiinfo);
		}
		
		
		
	}

	@Transactional
	@Override
	public void handPeizai(String workorderIds, String lineId,String operateunit) {
		String[] split = workorderIds.split(",");
		List<String> asList = Arrays.asList(split);
		Routelinebill routelinebill = routelinebillMapper.findByIdInAll(lineId);
		for (String string : asList) {
			Workorder workorder = workorderService.findById(string);
			Rukudetails rukudetails = rukudetailsMapper.selectByPrimaryKey(string);
			Peizaiinfo peizaiinfo = new Peizaiinfo(string, rukudetails.getCombinebillId(), operateunit, routelinebill.getId(), routelinebill.getEndstation(), Integer.parseInt(routelinebill.getTianshu()), workorder.getFloadreqr(), workorder.getReceivername(), workorder.getReceiveraddr(),null);
			peizaiinfoMapper.insertSelective(peizaiinfo);
		}
		
	}




	

	

}
