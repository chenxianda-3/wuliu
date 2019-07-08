package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Combinedetails;
import cn.com.lingnan.pojo.CombinedetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CombinedetailsMapper {
    int countByExample(CombinedetailsExample example);

    int deleteByExample(CombinedetailsExample example);

    int deleteByPrimaryKey(String workorderId);

    int insert(Combinedetails record);

    int insertSelective(Combinedetails record);

    List<Combinedetails> selectByExample(CombinedetailsExample example);

    Combinedetails selectByPrimaryKey(String workorderId);

    int updateByExampleSelective(@Param("record") Combinedetails record, @Param("example") CombinedetailsExample example);

    int updateByExample(@Param("record") Combinedetails record, @Param("example") CombinedetailsExample example);

    int updateByPrimaryKeySelective(Combinedetails record);

    int updateByPrimaryKey(Combinedetails record);
}