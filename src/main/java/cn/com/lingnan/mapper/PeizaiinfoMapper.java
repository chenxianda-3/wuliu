package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Peizaiinfo;
import cn.com.lingnan.pojo.PeizaiinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeizaiinfoMapper {
    int countByExample(PeizaiinfoExample example);

    int deleteByExample(PeizaiinfoExample example);

    int deleteByPrimaryKey(String workorderId);

    int insert(Peizaiinfo record);

    int insertSelective(Peizaiinfo record);

    List<Peizaiinfo> selectByExample(PeizaiinfoExample example);

    Peizaiinfo selectByPrimaryKey(String workorderId);

    int updateByExampleSelective(@Param("record") Peizaiinfo record, @Param("example") PeizaiinfoExample example);

    int updateByExample(@Param("record") Peizaiinfo record, @Param("example") PeizaiinfoExample example);

    int updateByPrimaryKeySelective(Peizaiinfo record);

    int updateByPrimaryKey(Peizaiinfo record);

	List<String> selectAllWorkorderId(PeizaiinfoExample peizaiinfoExample);
}