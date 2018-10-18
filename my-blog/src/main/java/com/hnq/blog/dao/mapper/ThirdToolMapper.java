package com.hnq.blog.dao.mapper;

import com.hnq.blog.dao.domain.ThirdTool;
import com.hnq.blog.dao.domain.ThirdToolCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ThirdToolMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table third_tool_link
     *
     * @mbggenerated
     */
    int countByExample(ThirdToolCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table third_tool_link
     *
     * @mbggenerated
     */
    int deleteByExample(ThirdToolCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table third_tool_link
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table third_tool_link
     *
     * @mbggenerated
     */
    int insert(ThirdTool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table third_tool_link
     *
     * @mbggenerated
     */
    int insertSelective(ThirdTool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table third_tool_link
     *
     * @mbggenerated
     */
    List<ThirdTool> selectByExampleWithRowbounds(ThirdToolCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table third_tool_link
     *
     * @mbggenerated
     */
    List<ThirdTool> selectByExample(ThirdToolCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table third_tool_link
     *
     * @mbggenerated
     */
    ThirdTool selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table third_tool_link
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ThirdTool record, @Param("example") ThirdToolCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table third_tool_link
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ThirdTool record, @Param("example") ThirdToolCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table third_tool_link
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ThirdTool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table third_tool_link
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ThirdTool record);
}