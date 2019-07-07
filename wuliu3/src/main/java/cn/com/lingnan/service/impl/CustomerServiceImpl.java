package cn.com.lingnan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lingnan.mapper.CustomerMapper;
import cn.com.lingnan.pojo.Customer;
import cn.com.lingnan.pojo.CustomerExample;
import cn.com.lingnan.pojo.CustomerExample.Criteria;
import cn.com.lingnan.service.CustomerService;

@Service(value="customerService")
public class CustomerServiceImpl  implements CustomerService{
	@Autowired
	private  CustomerMapper customerMapper;


	
	@Override
	public List<Customer> findAll() {
		CustomerExample customerExample = new CustomerExample();
		return customerMapper.selectByExample(customerExample);
	}


	@Override
	public List<Customer> findListNotAssociation() {
		CustomerExample customerExample = new CustomerExample();
		Criteria createCriteria = customerExample.createCriteria();
		createCriteria.andDecidedzoneIdIsNull();
		return customerMapper.selectByExample(customerExample);
	}


	@Override
	public List<Customer> findListHasAssociation(String decidedzoneId) {
		CustomerExample customerExample = new CustomerExample();
		Criteria createCriteria = customerExample.createCriteria();
		createCriteria.andDecidedzoneIdEqualTo(decidedzoneId);
		return customerMapper.selectByExample(customerExample);
	}

	@Transactional
	@Override
	public void assignCustomersToDecidedzone(String decidedzoneId, String[] customerIds) {
		//原有的设置为null
		customerMapper.updateDecidedzoneIdToNull(decidedzoneId);
		//选择的全部客户id数组设置为相应的定区
		for (int i = 0; i < customerIds.length; i++) {
			String customerId = customerIds[i];
			customerMapper.updateDecidedzoneIdByCustomerId(decidedzoneId, customerId);
			
		}
	
	}


	@Override
	public List<Customer> findByDecidedzoneId(String decidedzoneId) {
		CustomerExample customerExample = new CustomerExample();
		Criteria createCriteria = customerExample.createCriteria();
		createCriteria.andDecidedzoneIdEqualTo(decidedzoneId);
		return customerMapper.selectByExample(customerExample);
	}


	@Override
	public Customer findCustomerByTelephone(String telephone) {
		CustomerExample customerExample = new CustomerExample();
		Criteria createCriteria = customerExample.createCriteria();
		createCriteria.andTelephoneEqualTo(telephone);
		List<Customer> customers = customerMapper.selectByExample(customerExample);
		if(customers.size()>0){
			return customers.get(0);
		}
		return null;
	}

	
	

}
