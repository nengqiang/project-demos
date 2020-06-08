package com.hnq.fly.controller;

import com.hnq.fly.model.bo.SysLogBO;
import com.hnq.fly.model.request.LogPageRequest;
import com.hnq.fly.model.response.PageDataResponse;
import com.hnq.fly.model.vo.SysLogVO;
import com.hnq.fly.service.SysLogService;
import com.hnq.toolkit.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户操作日志相关接口
 *
 * @author henengqiang
 * @date 2020/5/5
 */
@RestController
@RequestMapping("/logs")
@Slf4j
public class SysLogsController {

    @Autowired
    private SysLogService logService;

    @GetMapping
    @PreAuthorize("hasAuthority('sys:log:query')")
    public PageDataResponse<SysLogVO> list(LogPageRequest request) {
        PageDataResponse<SysLogBO> data = logService.listSysLogs(request);
        return new PageDataResponse<>(data.getTotal(), BeanUtils.convert(data.getData(), SysLogVO.class));
    }

}
