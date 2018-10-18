package com.hnq.blog;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hnq.blog.dao.domain.ThirdTool;
import com.hnq.blog.dao.domain.ThirdToolCriteria;
import com.hnq.blog.dao.mapper.ThirdToolMapper;
import com.hnq.blog.dao.mapper.ext.ThirdToolExtMapper;

/**
 * @author henengqiang
 * @date 2018/9/30
 */
public class MyBatisTests extends AbstractTestCase {

    @Autowired
    private ThirdToolMapper thirdToolMapper;

    @Autowired
    private ThirdToolExtMapper thirdToolExtMapper;

    @Test
    public void saveDataToThirdToolTest() {
        try {
            ThirdTool thirdTool = new ThirdTool();
            thirdTool.setToolName("JSON在线视图查看器");
            thirdTool.setType((byte) 6);
            thirdTool.setLink("https://www.bejson.com/jsonviewernew/");
            thirdToolMapper.insert(thirdTool);
            logger.info("数据保存成功，存入数据为： {}", findToolByToolName("JSON在线视图查看器"));
        } catch (Exception e) {
            logger.error("数据保存失败", e);
        }
    }

    private ThirdTool findToolByToolName(String name) {
        ThirdToolCriteria example = new ThirdToolCriteria();
        example.createCriteria().andToolNameEqualTo(name);
        List<ThirdTool> thirdTools = thirdToolMapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(thirdTools) ? thirdTools.get(0) : null;
    }

    @Test
    public void findToolByPageSizeTest() {
        Integer pageNumber = 1;
        Integer pageSize = 10;
        Integer startPoint = (pageNumber - 1) * pageSize;
        Integer endPoint = pageNumber * pageSize;
        List<ThirdTool> thirdTools = thirdToolExtMapper.selectByPageLimit(startPoint, endPoint);
        if (CollectionUtils.isNotEmpty(thirdTools)) {
            thirdTools.forEach(System.out::println);
        }
    }

    @Test
    public void findToolByNameAndPageSizeTest() {
        String toolNameLike = "查";
        Integer pageNumber = 1;
        Integer pageSize = 10;
        Integer startPoint = (pageNumber - 1) * pageSize;
        Integer endPoint = pageNumber * pageSize;
        List<ThirdTool> thirdTools = thirdToolExtMapper.selectByNameAndPageLimit(toolNameLike, startPoint, endPoint);
        if (CollectionUtils.isNotEmpty(thirdTools)) {
            thirdTools.forEach(System.out::println);
        }
    }

}
