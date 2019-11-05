package com.talkplatform.dubbo.provider.aop;

import com.google.common.collect.Maps;
import com.talkplatform.dubbo.provider.annotation.Database;
import com.talkplatform.dubbo.provider.datasource.DataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

@Aspect
@Component
@Order(-1)
public class DynamicDataSourceAspect {

	public static final Map<String, String> DB_MAP = Maps.newConcurrentMap();

	@Around("execution(* com.talkplatform.dubbo.provider.dao..*(..))")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		try {
			DataSourceContextHolder.set(this.choose(point));
			return point.proceed();
		} finally {
			DataSourceContextHolder.remove();
		}
	}

	@SuppressWarnings("unchecked")
	public String choose(ProceedingJoinPoint point) {
		try {
			String methodName = point.getTarget().getClass().getName() + "." + point.getSignature().getName();
			if (!DB_MAP.containsKey(methodName)) {
				MethodSignature signature = (MethodSignature) point.getSignature();
				Method method = signature.getDeclaringType().getMethod(signature.getMethod().getName(), signature.getMethod().getParameterTypes());
				if (method.isAnnotationPresent(Database.class)) {
					DB_MAP.put(methodName, method.getAnnotation(Database.class).value());
				} else {
					String className = signature.getDeclaringTypeName();
					if (!DB_MAP.containsKey(className)) {
						DB_MAP.put(className, Class.forName(className).getAnnotation(Database.class).value());
					}
					DB_MAP.put(methodName, DB_MAP.get(className));
				}
			}
			return DB_MAP.get(methodName);
		} catch (Exception e) {
			return null;
		}
	}

}
