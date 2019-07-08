package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Rukudetails;
import cn.com.lingnan.pojo.RukudetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RukudetailsMapper {
    int countByExample(RukudetailsExample example);

    int deleteByExample(RukudetailsExample example);

    int deleteByPrimaryKey(String workorderId);

    int insert(Rukudetails record);

    int insertSelective(Rukudetails record);

    List<Rukudetails> selectByExample(RukudetailsExample example);

    Rukudetails selectByPrimaryKey(String workorderId);

    int updateByExampleSelective(@Param("record") Rukudetails record, @Param("example") RukudetailsExample example);

    int updateByExample(@Param("record") Rukudetails record, @Param("example") RukudetailsExample example);

    int updateByPrimaryKeySelective(Rukudetails record);

    int updateByPrimaryKey(Rukudetails record);
}