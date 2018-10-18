package com.hnq.blog.service;

import com.hnq.blog.dao.domain.ThirdTool;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/10/17
 */
public interface IThirdToolService {

    /**
     * 创建第三方工具及其链接数据
     */
    int createThirdTool(String toolName, Integer toolType, String link);

    /**
     * 删除第三方工具及其链接数据
     */
    int deleteThirdTool(Integer toolId);

    /**
     * 更新第三方工具及其链接数据
     */
    int updateThirdTool(ThirdTool thirdTool);

    /**
     * 查询第三方工具及其链接数据
     * @param pageNumber    页码
     * @param pageSize      每页数据条数
     */
    List<ThirdTool> queryThirdTool(Integer pageNumber, Integer pageSize);

    /**
     * 模糊查询第三方工具及其链接数据
     * @param toolNameLike  工具名包含的关键字
     * @param pageNumber    页码
     * @param pageSize      每页数据条数
     */
    List<ThirdTool> queryThirdToolAccurate(String toolNameLike, Integer pageNumber, Integer pageSize);
}
