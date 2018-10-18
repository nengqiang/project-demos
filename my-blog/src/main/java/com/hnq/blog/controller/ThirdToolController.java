package com.hnq.blog.controller;

import com.hnq.blog.bean.Answer;
import com.hnq.blog.dao.domain.ThirdTool;
import com.hnq.blog.service.IThirdToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/9/30
 */
@RestController
@RequestMapping(value = "/back")
public class ThirdToolController extends AbstractController {

    @Autowired
    private IThirdToolService thirdToolService;

    @RequestMapping(value = "/createThirdTool")
    public Answer<?> createThirdTool(@RequestParam("toolName") String toolName,
                                     @RequestParam("toolType") Integer toolType,
                                     @RequestParam("link") String link) {
        try {
            int result = thirdToolService.createThirdTool(toolName, toolType, link);
            return renderAnswer( "添加了" + result + "条数据。");
        } catch (Exception e) {
            return renderError("操作失败。", e.getMessage());
        }
    }

    @RequestMapping(value = "/deleteThirdTool")
    public Answer<?> deleteThirdTool(@RequestParam("id") Integer id) {
        try {
            int result = thirdToolService.deleteThirdTool(id);
            return renderAnswer("成功删除" + result + "条数据。");
        } catch (Exception e) {
            return renderError("操作失败！");
        }
    }

    @RequestMapping(value = "/updateThirdTool")
    public Answer<?> updateThirdTool(@RequestBody ThirdTool thirdTool) {
        try {
            int result = thirdToolService.updateThirdTool(thirdTool);
            return renderAnswer("成功更新" + result + "条数据。");
        } catch (Exception e) {
            return renderError("操作失败！");
        }
    }

    @RequestMapping(value = "/queryThirdTool")
    public Answer<?> queryThirdTool(@RequestParam("pageNumber") Integer pageNumber,
                                    @RequestParam("pageSize") Integer pageSize) {
        try {
            List<ThirdTool> thirdTools = thirdToolService.queryThirdTool(pageNumber, pageSize);
            return renderAnswer(thirdTools);
        } catch (Exception e) {
            return renderError("查询失败！");
        }
    }

    @RequestMapping(value = "/queryThirdToolAccurate")
    public Answer<?> queryThirdToolAccurate(@RequestParam("toolNameLike") String toolNameLike,
                                            @RequestParam("pageNumber") Integer pageNumber,
                                            @RequestParam("pageSize") Integer pageSize) {
        // 模糊查询
        try {
            List<ThirdTool> thirdTools = thirdToolService.queryThirdToolAccurate(toolNameLike, pageNumber, pageSize);
            return renderAnswer(thirdTools);
        } catch (Exception e) {
            return renderError("查询失败！");
        }
    }

}
