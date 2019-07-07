package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Fendanbill;
import cn.com.lingnan.pojo.FendanbillExample;
import cn.com.lingnan.pojo.FendanbillKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FendanbillMapper {
    int countByExample(FendanbillExample example);

    int deleteByExample(FendanbillExample example);

    int deleteByPrimaryKey(FendanbillKey key);

    int insert(Fendanbill record);

    int insertSelective(Fendanbill record);

    List<Fendanbill> selectByExample(FendanbillExample example);

    Fendanbill selectByPrimaryKey(FendanbillKey key);

    int updateByExampleSelective(@Param("record") Fendanbill record, @Param("example") FendanbillExample example);

    int updateByExample(@Param("record") Fendanbill record, @Param("example") FendanbillExample example);

    int updateByPrimaryKeySelective(Fendanbill record);

    int updateByPrimaryKey(Fendanbill record);

	List<String> selectAllWorkorderId(FendanbillExample fendanbillExample);
}