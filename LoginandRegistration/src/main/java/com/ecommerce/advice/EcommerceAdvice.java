package com.ecommerce.advice;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class EcommerceAdvice
{
	static final Logger logs= Logger.getLogger(EcommerceAdvice.class);
	@Pointcut(value = "execution(* com.ecommerce.*.*.*(..))")
	public void myPointcut()
	{
		
	}
	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable
	{
		ObjectMapper mapper = new ObjectMapper();
		String methodName=pjp.getSignature().getName();
		String className=pjp.getSignature().getClass().toString();
		Object[] array=pjp.getArgs();
		logs.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
				+ mapper.writeValueAsString(array));
		Object object = pjp.proceed();
		logs.info(className + " : " + methodName + "()" + "Response : "
				+ mapper.writeValueAsString(object));
		return object;
	}

} 
