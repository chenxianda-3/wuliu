package cn.com.lingnan.mapper;

import cn.com.lingnan.pojo.Noticebill;
import cn.com.lingnan.pojo.NoticebillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticebillMapper {
    int countByExample(NoticebillExample example);

    int deleteByExample(NoticebillExample example);

    int deleteByPrimaryKey(String id);

    int insert(Noticebill record);

    int insertSelective(Noticebill record);

    List<Noticebill> selectByExample(NoticebillExample example);

    Noticebill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Noticebill record, @Param("example") NoticebillExample example);

    int updateByExample(@Param("record") Noticebill record, @Param("example") NoticebillExample example);

    int updateByPrimaryKeySelective(Noticebill record);

    int updateByPrimaryKey(Noticebill record);
}