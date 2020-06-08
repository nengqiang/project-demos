package com.hnq.fly.service;

import com.hnq.fly.model.bo.SysLogBO;
import com.hnq.fly.model.request.LogPageRequest;
import com.hnq.fly.model.response.PageDataResponse;

/**
 * @author henengqiang
 * @date 2020/3/16
 */
public interface SysLogService {

    void saveLog(SysLogBO sysLogBo);

    void saveLog(Long userNo, String module, String result, String remark);

    PageDataResponse<SysLogBO> listSysLogs(LogPageRequest request);

    void deleteLogs();

}
