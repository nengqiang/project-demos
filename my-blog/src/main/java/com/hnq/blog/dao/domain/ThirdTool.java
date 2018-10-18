package com.hnq.blog.dao.domain;

import java.io.Serializable;
import java.util.Date;

public class ThirdTool implements Serializable {
    /**
     * 主键，三方工具链接id
     */
    private Integer id;

    /**
     * 工具名称
     */
    private String toolName;

    /**
     * 工具类型，1-生活常用，2-教育学习，3-办公辅助，4-图片视频，5-网络工具，6-程序开发
     */
    private Byte type;

    /**
     * 三方工具链接地址
     */
    private String link;

    /**
     * 备用字段
     */
    private String spare;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后更新时间
     */
    private Date lastUpdateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table third_tool_link
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column third_tool_link.id
     *
     * @return the value of third_tool_link.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column third_tool_link.id
     *
     * @param id the value for third_tool_link.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column third_tool_link.tool_name
     *
     * @return the value of third_tool_link.tool_name
     *
     * @mbggenerated
     */
    public String getToolName() {
        return toolName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column third_tool_link.tool_name
     *
     * @param toolName the value for third_tool_link.tool_name
     *
     * @mbggenerated
     */
    public void setToolName(String toolName) {
        this.toolName = toolName == null ? null : toolName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column third_tool_link.type
     *
     * @return the value of third_tool_link.type
     *
     * @mbggenerated
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column third_tool_link.type
     *
     * @param type the value for third_tool_link.type
     *
     * @mbggenerated
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column third_tool_link.link
     *
     * @return the value of third_tool_link.link
     *
     * @mbggenerated
     */
    public String getLink() {
        return link;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column third_tool_link.link
     *
     * @param link the value for third_tool_link.link
     *
     * @mbggenerated
     */
    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column third_tool_link.spare
     *
     * @return the value of third_tool_link.spare
     *
     * @mbggenerated
     */
    public String getSpare() {
        return spare;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column third_tool_link.spare
     *
     * @param spare the value for third_tool_link.spare
     *
     * @mbggenerated
     */
    public void setSpare(String spare) {
        this.spare = spare == null ? null : spare.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column third_tool_link.create_date
     *
     * @return the value of third_tool_link.create_date
     *
     * @mbggenerated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column third_tool_link.create_date
     *
     * @param createDate the value for third_tool_link.create_date
     *
     * @mbggenerated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column third_tool_link.last_update_date
     *
     * @return the value of third_tool_link.last_update_date
     *
     * @mbggenerated
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column third_tool_link.last_update_date
     *
     * @param lastUpdateDate the value for third_tool_link.last_update_date
     *
     * @mbggenerated
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table third_tool_link
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", toolName=").append(toolName);
        sb.append(", type=").append(type);
        sb.append(", link=").append(link);
        sb.append(", spare=").append(spare);
        sb.append(", createDate=").append(createDate);
        sb.append(", lastUpdateDate=").append(lastUpdateDate);
        sb.append("]");
        return sb.toString();
    }
}