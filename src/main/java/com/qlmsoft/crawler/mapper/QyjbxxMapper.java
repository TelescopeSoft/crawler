package com.qlmsoft.crawler.mapper;

import com.qlmsoft.crawler.entity.Qyjbxx;
import com.qlmsoft.crawler.entity.QyjbxxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface QyjbxxMapper {
    long countByExample(QyjbxxExample example);

    int deleteByExample(QyjbxxExample example);

    int deleteByPrimaryKey(String qyid);

    int insert(Qyjbxx record);

    int insertSelective(Qyjbxx record);

    List<Qyjbxx> selectByExampleWithRowbounds(QyjbxxExample example, RowBounds rowBounds);

    List<Qyjbxx> selectByExample(QyjbxxExample example);

    Qyjbxx selectByPrimaryKey(String qyid);

    int updateByExampleSelective(@Param("record") Qyjbxx record, @Param("example") QyjbxxExample example);

    int updateByExample(@Param("record") Qyjbxx record, @Param("example") QyjbxxExample example);

    int updateByPrimaryKeySelective(Qyjbxx record);

    int updateByPrimaryKey(Qyjbxx record);
}