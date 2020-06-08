package com.hnq.fly.dao.repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnq.fly.dao.mapper.SysLogsMapper;
import com.hnq.fly.dao.mapper.SysUserMapper;
import com.hnq.fly.dao.po.SysLogs;
import com.hnq.fly.dao.po.SysLogsCriteria;
import com.hnq.fly.dao.po.SysUser;
import com.hnq.fly.dao.po.SysUserCriteria;
import com.hnq.fly.model.domain.SysLogDO;
import com.hnq.fly.model.request.LogPageRequest;
import com.hnq.toolkit.util.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author henengqiang
 * @date 2020/3/18
 */
@Repository
public class SysLogsRepository {

    @Resource
    private SysLogsMapper sysLogsMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    public int saveLogs(SysLogDO logs) {
        SysLogs sysLogs = BeanUtils.convert(logs, SysLogs.class);
        return sysLogsMapper.insert(sysLogs);
    }

    public long countByResultAndNameAndTime(LogPageRequest req) {
        List<Long> userNos = listUserNosByNickname(req);

        SysLogsCriteria logExample = new SysLogsCriteria();
        SysLogsCriteria.Criteria criteria1 = logExample.createCriteria();
        if (StringUtils.isNotEmpty(req.getResult())) {
            criteria1.andResultEqualTo(req.getResult());
        }
        if (req.getBeginTime() != null) {
            criteria1.andCreateTimeGreaterThanOrEqualTo(req.getBeginTime());
        }
        if (req.getEndTime() != null) {
            criteria1.andCreateTimeLessThanOrEqualTo(req.getEndTime());
        }
        criteria1.andUserNoIn(userNos);
        return sysLogsMapper.countByExample(logExample);
    }

    public PageInfo<SysLogDO> listLogs(LogPageRequest req) {
        List<Long> userNos = listUserNosByNickname(req);

        SysLogsCriteria logExample = new SysLogsCriteria();
        SysLogsCriteria.Criteria criteria1 = logExample.createCriteria();
        if (StringUtils.isNotEmpty(req.getResult())) {
            criteria1.andResultEqualTo(req.getResult());
        }
        if (req.getBeginTime() != null) {
            criteria1.andCreateTimeGreaterThanOrEqualTo(req.getBeginTime());
        }
        if (req.getEndTime() != null) {
            criteria1.andCreateTimeLessThanOrEqualTo(req.getEndTime());
        }
        criteria1.andUserNoIn(userNos);
        PageHelper.startPage(req.getCurrentPage(), req.getPageSize());
        return new PageInfo<>(BeanUtils.convert(sysLogsMapper.selectByExample(logExample), SysLogDO.class));
    }

    public int deleteLogs(Date time) {
        SysLogsCriteria example = new SysLogsCriteria();
        example.createCriteria().andCreateTimeLessThanOrEqualTo(time);
        return sysLogsMapper.deleteByExample(example);
    }

    private List<Long> listUserNosByNickname(LogPageRequest req) {
        SysUserCriteria userExample = new SysUserCriteria();
        SysUserCriteria.Criteria criteria = userExample.createCriteria();
        if (StringUtils.isNotEmpty(req.getNickname())) {
            criteria.andNicknameLike("%" + req.getNickname() + "%");
        }
        List<SysUser> users = sysUserMapper.selectByExample(userExample);
        return users.stream().map(SysUser::getUserNo).collect(Collectors.toList());
    }

}
