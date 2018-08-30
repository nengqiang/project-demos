package com.hnq.crawler.dao.mapper;

import com.hnq.crawler.dao.domain.BaiduHot;
import com.hnq.crawler.dao.domain.BaiduHotCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BaiduHotMapper {
    int countByExample(BaiduHotCriteria example);

    int deleteByExample(BaiduHotCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaiduHot record);

    int insertSelective(BaiduHot record);

    List<BaiduHot> selectByExampleWithBLOBsWithRowbounds(BaiduHotCriteria example, RowBounds rowBounds);

    List<BaiduHot> selectByExampleWithBLOBs(BaiduHotCriteria example);

    List<BaiduHot> selectByExampleWithRowbounds(BaiduHotCriteria example, RowBounds rowBounds);

    List<BaiduHot> selectByExample(BaiduHotCriteria example);

    BaiduHot selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaiduHot record, @Param("example") BaiduHotCriteria example);

    int updateByExampleWithBLOBs(@Param("record") BaiduHot record, @Param("example") BaiduHotCriteria example);

    int updateByExample(@Param("record") BaiduHot record, @Param("example") BaiduHotCriteria example);

    int updateByPrimaryKeySelective(BaiduHot record);

    int updateByPrimaryKeyWithBLOBs(BaiduHot record);

    int updateByPrimaryKey(BaiduHot record);
}