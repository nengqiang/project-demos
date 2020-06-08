package com.hnq.fly.advice;

import com.hnq.fly.annotation.LogAnnotation;
import com.hnq.fly.model.bo.SysLogBO;
import com.hnq.fly.service.SysLogService;
import com.hnq.fly.util.UserUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 统一日志处理
 *
 * @author henengqiang
 * @date 2020/3/16
 */
@Aspect
@Component
public class LogAdvice {

	@Autowired
	private SysLogService logService;

	@Around(value = "@annotation(com.hnq.fly.annotation.LogAnnotation)")
	public Object logSave(ProceedingJoinPoint joinPoint) throws Throwable {
		SysLogBO sysLogBo = new SysLogBO();
		sysLogBo.setUserNo(Objects.requireNonNull(UserUtils.getLoginUser()).getUserNo());
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		LogAnnotation logAnnotation = methodSignature.getMethod().getDeclaredAnnotation(LogAnnotation.class);
		String module = logAnnotation.module();
		if (StringUtils.isEmpty(module)) {
			throw new RuntimeException("没有指定日志的module");
		}
		sysLogBo.setModule(module);

		try {
			Object obj = joinPoint.proceed();
			sysLogBo.setResult(SysLogBO.Status.SUCCESS);
			return obj;
		} catch (Exception e) {
			sysLogBo.setResult(SysLogBO.Status.FAILED);
			sysLogBo.setRemark(e.getMessage());
			throw e;
		} finally {
			if (sysLogBo.getUserNo() != null) {
				logService.saveLog(sysLogBo);
			}
		}
	}

}
