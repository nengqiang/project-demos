package com.hnq.blog.service.impl;

import com.hnq.blog.dao.domain.ThirdTool;
import com.hnq.blog.dao.mapper.ThirdToolMapper;
import com.hnq.blog.dao.mapper.ext.ThirdToolExtMapper;
import com.hnq.blog.service.IThirdToolService;
import com.mysql.jdbc.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/10/18
 */
@Service
public class ThirdToolServiceImpl implements IThirdToolService {

    private static final Logger logger = LoggerFactory.getLogger(ThirdToolServiceImpl.class);

    @Autowired
    private ThirdToolMapper thirdToolMapper;

    @Autowired
    private ThirdToolExtMapper thirdToolExtMapper;

    @Override
    public int createThirdTool(String toolName, Integer toolType, String link) {
        logger.info("===>> createThirdTool: toolName={}, toolType={}, link={}", toolName, toolType, link);
        if (StringUtils.isNullOrEmpty(toolName) || StringUtils.isNullOrEmpty(link) || toolType == null) {
            throw new RuntimeException("输入参数不能为空！");
        }
        try {
            ThirdTool thirdTool = new ThirdTool();
            thirdTool.setToolName(toolName);
            thirdTool.setType(toolType.byteValue());
            thirdTool.setLink(link);
            return thirdToolMapper.insert(thirdTool);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("数据库或网络异常，请稍后重试。");
        }
    }

    @Override
    public int deleteThirdTool(Integer toolId) {
        logger.info("==> deleteThirdTool toolId={}", toolId);
        return thirdToolMapper.deleteByPrimaryKey(toolId);
    }

    @Override
    public int updateThirdTool(ThirdTool thirdTool) {
        logger.info("===> updateThirdTool thirdTool={}", thirdTool);
        return thirdToolMapper.updateByPrimaryKeySelective(thirdTool);
    }

    @Override
    public List<ThirdTool> queryThirdTool(Integer pageNumber, Integer pageSize) {
        logger.info("===>> queryThirdTool: pageNumber={}, pageSize={}", pageNumber, pageSize);
        Integer startPoint = (pageNumber - 1) * pageSize;
        Integer endPoint = pageNumber * pageSize;
        return thirdToolExtMapper.selectByPageLimit(startPoint, endPoint);
    }

    @Override
    public List<ThirdTool> queryThirdToolAccurate(String toolNameLike, Integer pageNumber, Integer pageSize) {
        logger.info("===>> queryThirdToolAccurate: toolNameLike={} pageNumber={}, pageSize={}",
                toolNameLike, pageNumber, pageSize);
        Integer startPoint = (pageNumber - 1) * pageSize;
        Integer endPoint = pageNumber * pageSize;
        return thirdToolExtMapper.selectByNameAndPageLimit(toolNameLike, startPoint, endPoint);
    }

}
