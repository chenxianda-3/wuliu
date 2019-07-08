package cn.com.lingnan.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.lingnan.mapper.DecidedzoneMapper;
import cn.com.lingnan.pojo.Decidedzone;
import cn.com.lingnan.pojo.DecidedzoneExample;
import cn.com.lingnan.pojo.DecidedzoneExample.Criteria;
import cn.com.lingnan.pojo.Region;
import cn.com.lingnan.pojo.Staff;
import cn.com.lingnan.pojo.Subarea;
import cn.com.lingnan.service.DecidedzoneService;
import cn.com.lingnan.service.RegionService;
import cn.com.lingnan.service.StaffService;
import cn.com.lingnan.service.SubareaService;
import cn.com.lingnan.utils.PageBean;

@Service(value = "decidedzoneService")
public class DecidedzoneServiceImpl implements DecidedzoneService {
	@Autowired
	private DecidedzoneMapper decidedzoneMapper;

	@Resource(name = "regionService")
	private RegionService regionService;
	

	@Resource(name = "subareaService")
	private SubareaService subareaService;
	
	@Resource(name = "staffService")
	private StaffService staffService;


	@Transactional
	@Override
	public void save(Decidedzone decidedzone,String ids)  {
		// 更加提交的省市区查询区域id并存入分区对象中
		if (null != decidedzone.getRegion()) {
			String regionid = regionService.findBySSQ(decidedzone.getRegion());
			if (null != regionid) {
				decidedzone.setRegionId(regionid);
			}
		}
		Decidedzone decidedzone2 = decidedzoneMapper.selectByPrimaryKey(decidedzone.getId());
	
		if (decidedzone2 == null) {
			decidedzoneMapper.insertSelective(decidedzone);
		} else {
			update(decidedzone);
		}
		String[] split = ids.split(",");
		for (int i = 0; i < split.length; i++) {
			String id = split[i];
			Subarea subarea = new Subarea();
			subarea.setId(id);
			subarea.setDecidedzoneId(decidedzone.getId());
			subareaService.update(subarea);
		}

	}

	@Override
	public void pageQuery(PageBean pageBean, Decidedzone decidedzone) {

		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Decidedzone> decidedzones = decidedzoneMapper.selectDecidedzone();
		if (!decidedzones.isEmpty()) {
			pageBean.setRows(decidedzones);
		} else {
			pageBean.setRows(new ArrayList<Decidedzone>());
		}
		pageBean.setTotal(page.getTotal());
	}

	@Override
	public void deleteBatch(String ids) {
		DecidedzoneExample decidedzoneExample = new DecidedzoneExample();
		Criteria createCriteria = decidedzoneExample.createCriteria();
		String[] split = ids.split(",");
		List<String> asList = Arrays.asList(split);
		createCriteria.andIdIn(asList);
		decidedzoneMapper.deleteByExample(decidedzoneExample);

	}

	@Override
	public Decidedzone findById(String id) {

		Decidedzone decidedzone = decidedzoneMapper.selectByPrimaryKey(id);
		if(decidedzone.getRegionId()!=null&&decidedzone.getRegionId()!=""){
			Region region = regionService.findById(decidedzone.getRegionId());
			decidedzone.setRegion(region);
			
		}
		if (decidedzone.getStaffId()!=null&& decidedzone.getStaffId()!="") {
			Staff staff = staffService.findById(decidedzone.getStaffId());
			decidedzone.setStaff(staff);
		}
		return decidedzone;
	}
	
	
	@Override
	public List<Decidedzone> findByRegionId(String regionId) {
		DecidedzoneExample decidedzoneExample = new DecidedzoneExample();
		Criteria createCriteria = decidedzoneExample.createCriteria();
		createCriteria.andRegionIdEqualTo(regionId);
		List<Decidedzone> decidedzones = decidedzoneMapper.selectByExample(decidedzoneExample);
		return decidedzones;
	}

	@Override
	public Decidedzone findByDecidedzoneName(String decidedzoneName) {
		DecidedzoneExample decidedzoneExample = new DecidedzoneExample();
		Criteria createCriteria = decidedzoneExample.createCriteria();
		createCriteria.andNameLike("%"+decidedzoneName+"%");
		List<Decidedzone> decidedzones = decidedzoneMapper.selectByExample(decidedzoneExample);
		if (decidedzones.size()>0) {
			return decidedzones.get(0);
		}else{
			return  null;
		}
	}
	
	
	
	@Override
	public int update(Decidedzone decidedzone) {
		return decidedzoneMapper.updateByPrimaryKeySelective(decidedzone);

	}

	@Override
	public int saveBatch(List<Decidedzone> decidedzoneList) {
		return decidedzoneMapper.insertBatch(decidedzoneList);
	}
	
	
	@Override
	public List<Decidedzone> findAll() {
		DecidedzoneExample decidedzoneExample = new DecidedzoneExample();
		return decidedzoneMapper.selectByExample(decidedzoneExample);
	}

}
