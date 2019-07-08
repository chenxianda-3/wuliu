package cn.com.lingnan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.lingnan.mapper.DeliveryunitMapper;
import cn.com.lingnan.pojo.Deliveryunit;
import cn.com.lingnan.pojo.DeliveryunitExample;
import cn.com.lingnan.pojo.DeliveryunitExample.Criteria;
import cn.com.lingnan.service.DeliveryunitService;

@Service(value="deliveryunitService")
public class DeliveryunitServiceImpl  implements DeliveryunitService{
	@Autowired
	private  DeliveryunitMapper deliveryunitMapper;

	@Override
	public List<Deliveryunit> findByTransfercenter(String transfercenter) {
		DeliveryunitExample deliveryunitExample = new DeliveryunitExample();
		Criteria createCriteria = deliveryunitExample.createCriteria();
		createCriteria.andTransfercenterLike("%"+transfercenter+"%");
		return deliveryunitMapper.selectByExample(deliveryunitExample);
	}
	
	
	
	

}
