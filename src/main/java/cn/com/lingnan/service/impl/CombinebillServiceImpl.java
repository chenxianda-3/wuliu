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
import cn.com.lingnan.mapper.CombinedetailsMapper;
import cn.com.lingnan.pojo.Combinebill;
import cn.com.lingnan.pojo.CombinebillExample;
import cn.com.lingnan.pojo.Combinedetails;
import cn.com.lingnan.pojo.CombinedetailsExample;
import cn.com.lingnan.pojo.Subarea;
import cn.com.lingnan.pojo.Workorder;
import cn.com.lingnan.pojo.CombinebillExample.Criteria;
import cn.com.lingnan.service.CombinebillService;
import cn.com.lingnan.service.WorkorderService;
import cn.com.lingnan.utils.PageBean;
import cn.com.lingnan.utils.UUIDUtils;

@Service(value="combinebillService")
public class CombinebillServiceImpl  implements CombinebillService{
	@Autowired
	private  CombinebillMapper combinebillMapper;
	
	@Autowired
	private  CombinedetailsMapper combinedetailsMapper;
	
	@Resource(name = "workorderService")
	private WorkorderService workorderService;

	@Transactional
	@Override
	public void save(Combinebill combinebill,String ids)  {

		combinebillMapper.insertSelective(combinebill);

		int   jianshusum=0;
		String[] split = ids.split(",");
		for (int i = 0; i < split.length; i++) {
			String id = split[i];
			Workorder findById = workorderService.findById(id);
			Combinedetails combinedetails = new  Combinedetails(findById.getId(), combinebill.getId(), findById.getProduct(), findById.getReceiveraddr(), findById.getNum(), findById.getWeight(), findById.getFloadreqr());
			combinedetailsMapper.insertSelective(combinedetails);
			jianshusum+=findById.getNum();
		}
		combinebill.setJiangshu(jianshusum);
		combinebill.setCombinepeople("aaaaa");
		combinebill.setSealId(UUIDUtils.getId());
		combinebill.setPiaoshu(split.length);
		combinebill.setCountDestination(combinebill.getDestination());
		combinebill.setStatus("0");
		combinebillMapper.updateByPrimaryKeySelective(combinebill);
	}

	@Override
	public void pageQuery(PageBean pageBean,Combinebill combinebill) {
		CombinebillExample combinebillExample = new CombinebillExample();
		Criteria createCriteria = combinebillExample.createCriteria();
		if(combinebill.getId()!=null && ""!=combinebill.getId() ){
			createCriteria.andIdLike(combinebill.getId()+"%");
		}
		if(combinebill.getCombinepeople()!=null && ""!=combinebill.getCombinepeople()){
			createCriteria.andCombinepeopleLike("%"+combinebill.getCombinepeople()+"%");
		}


		
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Combinebill> combinebills = combinebillMapper.selectByExample(combinebillExample);
		if (!combinebills.isEmpty()) {
			pageBean.setRows(combinebills);
		}else{
			pageBean.setRows(new ArrayList<Combinebill>());
		}
		pageBean.setTotal(page.getTotal());
	}

	@Override
	public void deleteBatch(String ids) {
		CombinebillExample combinebillExample = new CombinebillExample();
		Criteria createCriteria = combinebillExample.createCriteria();

		CombinedetailsExample combinedetailsExample = new   CombinedetailsExample();
		cn.com.lingnan.pojo.CombinedetailsExample.Criteria createCriteria2=combinedetailsExample.createCriteria();
		String[] split = ids.split(",");
		for (int i = 0; i < split.length; i++) {
			//删除对应的明细
			createCriteria2.andCombineorderIdEqualTo(split[i]);
			combinedetailsMapper.deleteByExample(combinedetailsExample);
			
			createCriteria.andIdEqualTo(split[i]);
			combinebillMapper.deleteByExample(combinebillExample);
		}
		
	}

	@Override
	public Combinebill findById(String id) {
		
		return combinebillMapper.selectByPrimaryKey(id);
	}
	
	
	@Override
	public List<Combinebill> findAll() {
		CombinebillExample combinebillExample = new CombinebillExample();
		return combinebillMapper.selectByExample(combinebillExample);
	}

	@Override
	public int update(Combinebill combinebill) {
		return combinebillMapper.updateByPrimaryKeySelective(combinebill);
		
	}

	@Override
	public List<Combinedetails> findCombinedetailsByid(String id) {
		CombinedetailsExample combinedetailsExample=new CombinedetailsExample();
		cn.com.lingnan.pojo.CombinedetailsExample.Criteria createCriteria = combinedetailsExample.createCriteria();
		createCriteria.andCombineorderIdEqualTo(id);
		List<Combinedetails> selectByExample = combinedetailsMapper.selectByExample(combinedetailsExample);
		return selectByExample;
	}
	

	

}
