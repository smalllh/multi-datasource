package com.wbb.aop;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wbb.annotation.DynamicRoutingDataSource;
import com.wbb.dataSource.MultiDataSource;

@Aspect
@Component
public class HandlerDataSourceAop {

	private static Logger logger = LoggerFactory.getLogger(HandlerDataSourceAop.class);

	/**
	 * 方式1 注解切换
	 * @within匹配类上的注解
	 * @annotation匹配方法上的注解
	 */
//	@Pointcut("@within(com.wbb.annotation.DynamicRoutingDataSource)||@annotation(com.wbb.annotation.DynamicRoutingDataSource)")
//	public void pointcut(){}
//
//	@Before(value="pointcut()")
//	public void beforeOpt(JoinPoint joinPoint){
//		//先查找方法上的注解，没有的话再去查找类上的注解
//		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//		Method method = methodSignature.getMethod();
//		DynamicRoutingDataSource annotation = method.getAnnotation(DynamicRoutingDataSource.class);
//		if(annotation==null){
//			annotation = joinPoint.getTarget().getClass().getAnnotation(DynamicRoutingDataSource.class);
//			if(annotation==null){
//				return ;
//			}
//		}
//		String dataSourceName = annotation.value();
//		MultiDataSource.setDataSourceKey(dataSourceName);
//		logger.info("切到"+dataSourceName+"数据库");
//	}
//	@After(value="pointcut()")
//	public void afterOpt(){
//		MultiDataSource.toDefault();
//		logger.info("切回默认数据库");
//	}

	/**
	 * 方式2 实现类切换
	 * 根据实现类指定的路径切换
	 */
	@Pointcut("execution(public * com.wbb.service.impl.*.*(..))")
	public void pointcut(){};

	@Before(value="pointcut()")
	public void beforeOpt(JoinPoint joinPoint){
		String dataSourceName = "dataSource1";
		MultiDataSource.setDataSourceKey(dataSourceName);
		logger.info("切到"+dataSourceName+"数据库");
	}
	@After(value="pointcut()")
	public void afterOpt(){
		MultiDataSource.toDefault();
		logger.info("切回默认数据库");
	}

}
