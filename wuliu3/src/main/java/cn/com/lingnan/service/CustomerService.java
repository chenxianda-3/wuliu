package cn.com.lingnan.service;

import java.util.List;

import javax.jws.WebService;

import cn.com.lingnan.pojo.Customer;
import cn.com.lingnan.pojo.Subarea;
@WebService
public interface CustomerService {
	public List<Customer> findAll();
	//查询未关联到定区的客户
	public List<Customer> findListNotAssociation();
	//查询已经关联到指定定区的客户
	public List<Customer> findListHasAssociation(String decidedzoneId);
	//定区关联客户
	void assignCustomersToDecidedzone(String decidedzoneId, String[] customerIds);
	public List<Customer> findByDecidedzoneId(String decidedzoneId);
	
	public  Customer findCustomerByTelephone(String telephone);
	
}
