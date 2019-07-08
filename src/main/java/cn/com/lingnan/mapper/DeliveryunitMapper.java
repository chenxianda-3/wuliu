package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Deliveryunit;
import cn.com.lingnan.pojo.DeliveryunitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliveryunitMapper {
    int countByExample(DeliveryunitExample example);

    int deleteByExample(DeliveryunitExample example);

    int deleteByPrimaryKey(String id);

    int insert(Deliveryunit record);

    int insertSelective(Deliveryunit record);

    List<Deliveryunit> selectByExample(DeliveryunitExample example);

    Deliveryunit selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Deliveryunit record, @Param("example") DeliveryunitExample example);

    int updateByExample(@Param("record") Deliveryunit record, @Param("example") DeliveryunitExample example);

    int updateByPrimaryKeySelective(Deliveryunit record);

    int updateByPrimaryKey(Deliveryunit record);
}