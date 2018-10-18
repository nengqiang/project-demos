package com.hnq.blog.dao.mapper.ext;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hnq.blog.dao.domain.ThirdTool;

/**
 * @author henengqiang
 * @date 2018/10/17
 */
public interface ThirdToolExtMapper {

    List<ThirdTool> selectByPageLimit(@Param("startPoint") Integer startPoint, @Param("endPoint") Integer endPoint);

    List<ThirdTool> selectByNameAndPageLimit(@Param("toolName") String toolName,
                                             @Param("startPoint") Integer startPoint,
                                             @Param("endPoint") Integer endPoint);

}
