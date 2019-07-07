package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Customer;
import cn.com.lingnan.pojo.CustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    int countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    
    int  updateDecidedzoneIdToNull(String decidedzoneId);
    
    int  updateDecidedzoneIdByCustomerId(String decidedzoneId,String customerId);
    
    
}