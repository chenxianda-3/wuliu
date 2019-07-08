package cn.com.lingnan.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.lingnan.mapper.SubareaMapper;
import cn.com.lingnan.pojo.Decidedzone;
import cn.com.lingnan.pojo.Region;
import cn.com.lingnan.pojo.Subarea;
import cn.com.lingnan.pojo.SubareaExample;
import cn.com.lingnan.pojo.SubareaExample.Criteria;
import cn.com.lingnan.service.DecidedzoneService;
import cn.com.lingnan.service.RegionService;
import cn.com.lingnan.service.SubareaService;
import cn.com.lingnan.utils.PageBean;

@Service(value="subareaService")
public class SubareaServiceImpl  implements SubareaService{
	@Autowired
	private  SubareaMapper subareaMapper;
	
	@Resource(name = "regionService")
	private RegionService regionService;
	
	@Resource(name = "decidedzoneService")
	private DecidedzoneService decidedzoneService;

	@Override
	public void save(Subarea subarea)  {
		//根据提交的省市区查询区域id并存入分区对象中
		if (null !=subarea.getRegion()) {
			String regionid = regionService.findBySSQ(subarea.getRegion());
			if (null!=regionid) {
				subarea.setRegionId(regionid);
			}
		}
		Subarea subarea2 = subareaMapper.selectByPrimaryKey(subarea.getId());
		if(subarea2==null){
			subareaMapper.insertSelective(subarea);
		}else{
			update(subarea);
		}
		
	}

	@Override
	public void pageQuery(PageBean pageBean,Subarea subarea) {
		//需要省市区全都填写完毕才能根据省市区查询相应的分区
		if(subarea.getRegion()!=null){
			if(subarea.getRegion().getProvince()!=null && ""!=subarea.getRegion().getProvince()){
				if(subarea.getRegion().getCity()!=null && ""!=subarea.getRegion().getCity()){
					if(subarea.getRegion().getDistrict()!=null && ""!=subarea.getRegion().getDistrict()){
						String regionid = regionService.findBySSQ(subarea.getRegion());
						if (null!=regionid) {
							subarea.setRegionId(regionid);
						}
					}
				}
			}
		}
		
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Subarea> subareas = subareaMapper.selectSubarea(subarea);
		if (!subareas.isEmpty()) {
			pageBean.setRows(subareas);
		}else{
			pageBean.setRows(new ArrayList<Subarea>());
		}
		pageBean.setTotal(page.getTotal());
	}
	
	
	
	

	@Override
	public void deleteBatch(String ids) {
		SubareaExample subareaExample = new SubareaExample();
		Criteria createCriteria = subareaExample.createCriteria();
		String[] split = ids.split(",");
		List<String> asList = Arrays.asList(split);
		createCriteria.andIdIn(asList);
		subareaMapper.deleteByExample(subareaExample);
		
	}

	@Override
	public Subarea findById(String id) {

		Subarea subarea = subareaMapper.selectByPrimaryKey(id);
		System.out.println(subarea.toString());
		if(subarea.getRegionId()!=null && subarea.getRegionId()!="" ){
			Region region = regionService.findById(subarea.getRegionId());
			subarea.setRegion(region);
		}
		System.out.println(subarea.getDecidedzoneId());
		if(subarea.getDecidedzoneId()!=null && subarea.getDecidedzoneId()!="" ){
			Decidedzone decidedzone = decidedzoneService.findById(subarea.getDecidedzoneId());
			subarea.setDecidedzone(decidedzone);
		}
		return subarea;
	}
	
	@Override
	public List<Decidedzone>  findDecidezoneBySSQ(Region region) {

		String regionid = regionService.findBySSQ(region);
		List<Decidedzone> decidedzones = decidedzoneService.findByRegionId(regionid);
		return decidedzones;
	}
	
	

	@Override
	public int update(Subarea subarea) {
		return subareaMapper.updateByPrimaryKeySelective(subarea);
		
	}
	
	@Override
	public int updateById(Subarea subarea) {
		if (null !=subarea.getRegion()) {
			String regionid = regionService.findBySSQ(subarea.getRegion());
			if (null!=regionid) {
				subarea.setRegionId(regionid);
			}
		}
		return subareaMapper.updateByPrimaryKeySelective(subarea);
		
	}
	
	@Override
	public  int  saveBatch(List<Subarea> subareaList){
		return subareaMapper.insertBatch(subareaList);
	}
	
	@Override
	public List<Subarea> findAll() {
		SubareaExample subareaExample = new SubareaExample();
		return subareaMapper.selectByExample(subareaExample);
	}

	@Override
	public List<Subarea> findByDecidedzoneId(String decidedzoneId) {
		Subarea subarea = new Subarea();
		subarea.setDecidedzoneId(decidedzoneId);
		List<Subarea> subareas = subareaMapper.selectSubarea(subarea);
		return subareas;
	}
	

}
