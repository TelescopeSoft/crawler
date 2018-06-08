package com.qlmsoft.crawler.mapper;

import com.qlmsoft.crawler.entity.Qyzzmx;
import com.qlmsoft.crawler.entity.QyzzmxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface QyzzmxMapper {
    long countByExample(QyzzmxExample example);

    int deleteByExample(QyzzmxExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Qyzzmx record);

    int insertSelective(Qyzzmx record);

    List<Qyzzmx> selectByExampleWithRowbounds(QyzzmxExample example, RowBounds rowBounds);

    List<Qyzzmx> selectByExample(QyzzmxExample example);

    Qyzzmx selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Qyzzmx record, @Param("example") QyzzmxExample example);

    int updateByExample(@Param("record") Qyzzmx record, @Param("example") QyzzmxExample example);

    int updateByPrimaryKeySelective(Qyzzmx record);

    int updateByPrimaryKey(Qyzzmx record);
}