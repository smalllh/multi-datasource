package com.wbb.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

//@Aspect
//@Component
public class LogsAspect {
	/**
	 * (1)pointcut切入点
	 * (2)Before:在目标方法被调用之前做增强处理,@Before只需要指定切入点表达式即可
	 * (3)AfterReturning:在目标方法正常完成后做增强,@AfterReturning除了指定切入点表达式后，还可以指定一个返回值形参名returning,代表目标方法的返回值
	 * (4)AfterThrowing:主要用来处理程序中未处理的异常,@AfterThrowing除了指定切入点表达式后，还可以指定一个throwing的返回值形参名,可以通过该形参名
	 * 来访问目标方法中所抛出的异常对象
	 * (5)After:在目标方法完成之后做增强，无论目标方法时候成功完成。@After可以指定一个切入点表达式
	 * (6)Around:环绕通知,在目标方法完成前后做增强处理,环绕通知是最重要的通知类型,像事务,日志等都是环绕通知,注意编程中核心是一个ProceedingJoinPoint
	 */
	@Pointcut(value = "execution(public Object com.wbb.web.exception.GlobalExceptionHandler.handlerException(..))")
	public void pointcut() {
	}

	@Before(value = "com.wbb.aop.LogsAspect.pointcut()")
	public void logStart(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println(name+",运行前,参数:"+Arrays.asList(joinPoint.getArgs()));
	}

	@After(value = "pointcut()")
	public void logEnd(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println(name+",运行结束,参数:"+Arrays.asList(joinPoint.getArgs()));
	}

	@AfterReturning(value = "pointcut()",returning="object")
	public void logReturn(Object object) {
		System.out.println("运行后返回:"+JSONObject.toJSONString(object));
	}

	@AfterThrowing(value = "pointcut()",throwing="exception")
	public void logAfterThrowing(Exception exception) {
		System.out.println("运行异常:"+JSON.toJSONString(exception));
	}

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) {
		System.out.println("AOP Aronud before...");
		try {
			return pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("AOP Aronud after...");
		return null;
	}
}
