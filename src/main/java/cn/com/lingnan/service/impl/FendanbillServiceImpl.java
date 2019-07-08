package cn.com.lingnan.service.impl;

import java.sql.Timestamp;
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
import cn.com.lingnan.mapper.DeliveryunitMapper;
import cn.com.lingnan.mapper.FendanbillMapper;
import cn.com.lingnan.mapper.QianshoubillMapper;
import cn.com.lingnan.mapper.RoutebillMapper;
import cn.com.lingnan.mapper.RoutelinebillMapper;
import cn.com.lingnan.mapper.RukubillMapper;
import cn.com.lingnan.mapper.RukudetailsMapper;
import cn.com.lingnan.pojo.Combinebill;
import cn.com.lingnan.pojo.CombinebillExample;
import cn.com.lingnan.pojo.Deliveryunit;
import cn.com.lingnan.pojo.DeliveryunitExample;
import cn.com.lingnan.pojo.Fendanbill;
import cn.com.lingnan.pojo.FendanbillExample;
import cn.com.lingnan.pojo.FendanbillKey;
import cn.com.lingnan.pojo.Qianshoubill;
import cn.com.lingnan.pojo.QianshoubillExample;
import cn.com.lingnan.pojo.FendanbillExample.Criteria;
import cn.com.lingnan.pojo.Routebill;
import cn.com.lingnan.pojo.RoutebillExample;
import cn.com.lingnan.pojo.Routelinebill;
import cn.com.lingnan.pojo.Rukubill;
import cn.com.lingnan.pojo.RukubillExample;
import cn.com.lingnan.pojo.Rukudetails;
import cn.com.lingnan.pojo.RukudetailsExample;
import cn.com.lingnan.pojo.User;
import cn.com.lingnan.pojo.Workorder;
import cn.com.lingnan.service.FendanbillService;
import cn.com.lingnan.service.WorkorderService;
import cn.com.lingnan.utils.PageBean;

@Service(value="fendanbillService")
public class FendanbillServiceImpl  implements FendanbillService{
	@Autowired
	private  FendanbillMapper fendanbillMapper;
	
	@Autowired
	private  RukudetailsMapper rukudetailsMapper;
	
	@Autowired
	private   RukubillMapper rukubillMapper;
	
	@Autowired
	private   CombinebillMapper combinebillMapper;
	
	@Autowired
	private   QianshoubillMapper qianshoubillMapper;
	
	@Autowired
	private   DeliveryunitMapper deliveryunitMapper;
	
	@Resource(name = "workorderService")
	private WorkorderService workorderService;

	@Override
	public void save(Fendanbill fendanbill)  {
		Fendanbill fendanbill2 = fendanbillMapper.selectByPrimaryKey(new FendanbillKey(fendanbill.getWorkorderId(),fendanbill.getTransfercenter()));
		if(fendanbill2==null){
			fendanbillMapper.insertSelective(fendanbill);
		}else{
			update(fendanbill);
		}
		
	}

	@Override
	public void pageQueryOfFendaned(PageBean pageBean,Fendanbill fendanbill) {
		FendanbillExample fendanbillExample = new FendanbillExample();
		Criteria createCriteria = fendanbillExample.createCriteria();
		if(fendanbill.getWorkorderId()!=null && ""!=fendanbill.getWorkorderId() ){
			createCriteria.andWorkorderIdLike(fendanbill.getWorkorderId()+"%");
		}
		if(fendanbill.getDeliveryunitId()!=null && ""!=fendanbill.getDeliveryunitId() ){
			createCriteria.andDeliveryunitIdEqualTo(fendanbill.getDeliveryunitId());
		}
		createCriteria.andTransfercenterLike("%"+fendanbill.getTransfercenter()+"%");
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Fendanbill> fendanbills = fendanbillMapper.selectByExample(fendanbillExample);
		if (!fendanbills.isEmpty()) {
			pageBean.setRows(fendanbills);
		}else{
			pageBean.setRows(new ArrayList<Fendanbill>());
		}
		pageBean.setTotal(page.getTotal());
	}
	
	
	@Override
	public void pageQueryOfNoFendan(PageBean pageBean, Rukudetails rukudetails, String transfercenter) {
		//找到已配载中的所有工作单id,需要有地址作为参数
		FendanbillExample fendanbillExample=new FendanbillExample();
		Criteria createCriteria3 = fendanbillExample.createCriteria();
		createCriteria3.andTransfercenterLike("%"+transfercenter+"%");
		List<String> ids=fendanbillMapper.selectAllWorkorderId(fendanbillExample);
		//根据地点找到入库单，再从对应的入库单找到明细
		RukubillExample rukubillExample=new RukubillExample();
		cn.com.lingnan.pojo.RukubillExample.Criteria createCriteria2 = rukubillExample.createCriteria();
		createCriteria2.andJiehuostationLike("%"+transfercenter+"%");
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
		FendanbillExample fendanbillExample = new FendanbillExample();
		Criteria createCriteria = fendanbillExample.createCriteria();
		String[] split = ids.split(",");
		List<String> asList = Arrays.asList(split);
		createCriteria.andWorkorderIdIn(asList);
		createCriteria.andTransfercenterLike("%"+user.getStation()+"%");
		fendanbillMapper.deleteByExample(fendanbillExample);
		
	}

	@Override
	public Fendanbill findByIdAndStation(String id,String station) {
		return fendanbillMapper.selectByPrimaryKey(new FendanbillKey(id, station));
	}
	
	
	@Override
	public List<Fendanbill> findAll() {
		FendanbillExample fendanbillExample = new FendanbillExample();
		return fendanbillMapper.selectByExample(fendanbillExample);
	}

	@Override
	public int update(Fendanbill fendanbill) {
		return fendanbillMapper.updateByPrimaryKeySelective(fendanbill);
		
	}



	@Transactional
	@Override
	public void handFendan(String workorderIds, String deliveryunitId,User user) {
		String[] split = workorderIds.split(",");
		List<String> asList = Arrays.asList(split);
		for (String string : asList) {
			Workorder workorder = workorderService.findById(string);
			Fendanbill fendanbill = new Fendanbill(string,user.getStation(),deliveryunitId, 1, "1", workorder.getReceiveraddr(), "1",new Timestamp(System.currentTimeMillis()), user.getUsername());
			fendanbillMapper.insertSelective(fendanbill);
		}
		
	}

	@Override
	public void findFendanedToDeliveryunit(PageBean pageBean, Fendanbill fendanbill, User user) {
		
		//找到对应的分派单位id
		DeliveryunitExample deliveryunitExample=new DeliveryunitExample();
		cn.com.lingnan.pojo.DeliveryunitExample.Criteria createCriteria = deliveryunitExample.createCriteria();
		cn.com.lingnan.pojo.DeliveryunitExample.Criteria andNameLike = createCriteria.andNameLike("%"+user.getStation()+"%");
		String id = deliveryunitMapper.selectByExample(deliveryunitExample).get(0).getId();
		
		QianshoubillExample qianshoubillExample = new  QianshoubillExample();
		List<Qianshoubill> selectByExample = qianshoubillMapper.selectByExample(qianshoubillExample);
		//取出其中的工作单id
		ArrayList<String> arrayList = new ArrayList<>();
		
		if (selectByExample.size()>0) {
			for (Qianshoubill qianshoubill : selectByExample) {
				arrayList.add(qianshoubill.getWorkorderId());
			}
		}
		
		
		
		//根据分派单位id找到所有的进港分单，必须是还没签收的
		FendanbillExample fendanbillExample=new FendanbillExample();
		Criteria createCriteria2 = fendanbillExample.createCriteria();
		if (arrayList.size()>0) {
			createCriteria2.andWorkorderIdNotIn(arrayList);
		}
		createCriteria2.andDeliveryunitIdEqualTo(id);
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Fendanbill> fendanbills = fendanbillMapper.selectByExample(fendanbillExample);
		if (!fendanbills.isEmpty()) {
			pageBean.setRows(fendanbills);
		}else{
			pageBean.setRows(new ArrayList<Fendanbill>());
		}
		pageBean.setTotal(page.getTotal());
	}




	

	

}
