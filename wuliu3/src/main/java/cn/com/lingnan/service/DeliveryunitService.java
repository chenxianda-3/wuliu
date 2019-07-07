package cn.com.lingnan.service;


import java.util.List;

import cn.com.lingnan.pojo.Deliveryunit;

public interface DeliveryunitService {


	public List<Deliveryunit>  findByTransfercenter(String transfercenter);


}
