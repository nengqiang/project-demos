package com.hnq.fly.service.impl;

import com.github.pagehelper.PageInfo;
import com.hnq.fly.model.bo.SysLogBO;
import com.hnq.fly.dao.repository.SysLogsRepository;
import com.hnq.fly.model.domain.SysLogDO;
import com.hnq.fly.model.request.LogPageRequest;
import com.hnq.fly.model.response.PageDataResponse;
import com.hnq.fly.service.SysLogService;
import com.hnq.toolkit.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 日志服务
 *
 * @author henengqiang
 * @date 2020/3/16
 */
@Service
@Slf4j
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private SysLogsRepository logsRepository;

    @Async
    @Override
    public void saveLog(SysLogBO logs) {
        if (logs == null || logs.getUserNo() == null) {
            return;
        }
        logsRepository.saveLogs(BeanUtils.convert(logs, SysLogDO.class));
    }

    @Async
    @Override
    public void saveLog(Long userNo, String module, String result, String remark) {
        SysLogDO logs = new SysLogDO();
        logs.setUserNo(userNo);
        logs.setModule(module);
        logs.setResult(result);
        logs.setRemark(remark);
        logsRepository.saveLogs(logs);
    }

    @Override
    public PageDataResponse<SysLogBO> listSysLogs(LogPageRequest request) {
        PageInfo<SysLogDO> data = logsRepository.listLogs(request);
        return new PageDataResponse<>(data.getTotal(), BeanUtils.convert(data.getList(), SysLogBO.class));
    }

    @Override
    public void deleteLogs() {
        Date date = DateUtils.addMonths(new Date(), -3);
        int n = logsRepository.deleteLogs(date);
        log.info("删除{}之前的日志{}条", DateFormatUtils.format(
                date, DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.getPattern()), n);
    }

}
