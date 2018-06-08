package com.qlmsoft.crawler.mapper;

import com.qlmsoft.crawler.entity.Qycsyw;
import com.qlmsoft.crawler.entity.QycsywExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface QycsywMapper {
    long countByExample(QycsywExample example);

    int deleteByExample(QycsywExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Qycsyw record);

    int insertSelective(Qycsyw record);

    List<Qycsyw> selectByExampleWithRowbounds(QycsywExample example, RowBounds rowBounds);

    List<Qycsyw> selectByExample(QycsywExample example);

    Qycsyw selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Qycsyw record, @Param("example") QycsywExample example);

    int updateByExample(@Param("record") Qycsyw record, @Param("example") QycsywExample example);

    int updateByPrimaryKeySelective(Qycsyw record);

    int updateByPrimaryKey(Qycsyw record);
}