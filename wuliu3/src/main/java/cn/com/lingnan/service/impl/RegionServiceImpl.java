package cn.com.lingnan.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.com.lingnan.mapper.RegionMapper;
import cn.com.lingnan.pojo.Region;
import cn.com.lingnan.pojo.RegionExample;
import cn.com.lingnan.pojo.RegionExample.Criteria;
import cn.com.lingnan.service.RegionService;
import cn.com.lingnan.utils.PageBean;

@Service(value="regionService")
public class RegionServiceImpl  implements RegionService{
	@Autowired
	private  RegionMapper regionMapper;

	@Override
	public void save(Region region)  {
		Region region2 = regionMapper.selectByPrimaryKey(region.getId());
		if(region2==null){
			regionMapper.insertSelective(region);
		}else{
			update(region);
		}
		
	}

	@Override
	public void pageQuery(PageBean pageBean,Region region) {
		RegionExample regionExample = new RegionExample();
		Criteria createCriteria = regionExample.createCriteria();
		if(region.getProvince()!=null && ""!=region.getProvince() ){
			createCriteria.andProvinceLike(region.getProvince()+"%");
		}
		if(region.getCity()!=null && ""!=region.getCity()){
			createCriteria.andCityLike(region.getCity()+"%");
		}
		if(region.getDistrict()!=null && ""!=region.getDistrict()){
			createCriteria.andDistrictLike(region.getDistrict()+"%");
		}
		if(region.getPostcode()!=null && ""!=region.getPostcode()){
			createCriteria.andPostcodeLike(region.getPostcode()+"%");
		}
		if(region.getShortcode()!=null && ""!=region.getShortcode()){
			createCriteria.andShortcodeLike(region.getShortcode()+"%");
		}
		if(region.getCitycode()!=null && ""!=region.getCitycode()){
			createCriteria.andCitycodeLike(region.getCitycode()+"%");
		}
	
		
		Page page = PageHelper.startPage(pageBean.getPage(), pageBean.getPageSize());
		List<Region> regions = regionMapper.selectByExample(regionExample);
		if (!regions.isEmpty()) {
			pageBean.setRows(regions);
		}else{
			pageBean.setRows(new ArrayList<Region>());
		}
		pageBean.setTotal(page.getTotal());
	}

	@Override
	public String findBySSQ(Region region){
		RegionExample regionExample = new RegionExample();
		Criteria createCriteria = regionExample.createCriteria();
		if(region.getProvince()!=null && ""!=region.getProvince() ){
			createCriteria.andProvinceLike(region.getProvince()+"%");
		}
		if(region.getCity()!=null && ""!=region.getCity()){
			createCriteria.andCityLike(region.getCity()+"%");
		}
		if(region.getDistrict()!=null && ""!=region.getDistrict()){
			createCriteria.andDistrictLike(region.getDistrict()+"%");
		}
		 Region region2 = regionMapper.selectByExample(regionExample).get(0);
		 if (null !=region2) {
			 return  region2.getId();
		}
		 return null;
	}
	
	
	
	
	@Override
	public void deleteBatch(String ids) {
		RegionExample regionExample = new RegionExample();
		Criteria createCriteria = regionExample.createCriteria();
		String[] split = ids.split(",");
		List<String> asList = Arrays.asList(split);
		createCriteria.andIdIn(asList);
		regionMapper.deleteByExample(regionExample);
		
	}

	@Override
	public Region findById(String id) {
		
		return regionMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Region region) {
		return regionMapper.updateByPrimaryKeySelective(region);
		
	}
	
	@Override
	public  int  saveBatch(List<Region> regionList){
		return regionMapper.insertBatch(regionList);
	}
	
	
	@Override
	public List<Region> findAll() {
		RegionExample regionExample = new RegionExample();
		return regionMapper.selectByExample(regionExample);
	}

}
