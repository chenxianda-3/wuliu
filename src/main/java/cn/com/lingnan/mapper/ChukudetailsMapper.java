package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Chukudetails;
import cn.com.lingnan.pojo.ChukudetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChukudetailsMapper {
    int countByExample(ChukudetailsExample example);

    int deleteByExample(ChukudetailsExample example);

    int deleteByPrimaryKey(String workorderId);

    int insert(Chukudetails record);

    int insertSelective(Chukudetails record);

    List<Chukudetails> selectByExample(ChukudetailsExample example);

    Chukudetails selectByPrimaryKey(String workorderId);

    int updateByExampleSelective(@Param("record") Chukudetails record, @Param("example") ChukudetailsExample example);

    int updateByExample(@Param("record") Chukudetails record, @Param("example") ChukudetailsExample example);

    int updateByPrimaryKeySelective(Chukudetails record);

    int updateByPrimaryKey(Chukudetails record);
}