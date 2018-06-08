package com.qlmsoft.crawler.mapper;

import com.qlmsoft.crawler.entity.UeppCode;
import com.qlmsoft.crawler.entity.UeppCodeExample;
import com.qlmsoft.crawler.entity.UeppCodeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UeppCodeMapper {
    long countByExample(UeppCodeExample example);

    int deleteByExample(UeppCodeExample example);

    int deleteByPrimaryKey(UeppCodeKey key);

    int insert(UeppCode record);

    int insertSelective(UeppCode record);

    List<UeppCode> selectByExampleWithRowbounds(UeppCodeExample example, RowBounds rowBounds);

    List<UeppCode> selectByExample(UeppCodeExample example);

    UeppCode selectByPrimaryKey(UeppCodeKey key);

    int updateByExampleSelective(@Param("record") UeppCode record, @Param("example") UeppCodeExample example);

    int updateByExample(@Param("record") UeppCode record, @Param("example") UeppCodeExample example);

    int updateByPrimaryKeySelective(UeppCode record);

    int updateByPrimaryKey(UeppCode record);
}