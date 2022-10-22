package com.teamproject.mvc20221004teamproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.CodeSigner;

@Slf4j
@Aspect
@Component
public class LogAop {

    @Pointcut("execution(* com.teamproject.mvc20221004teamproject.api.*Api.*(..))")
    private void pointCut() {}

    @Pointcut("@annotation(com.teamproject.mvc20221004teamproject.aop.annotation.LogAspect)")
    private void annotationPointCut() {}

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws  Throwable {
//        joinpoint안의 매개변수중 getSignature가 있으며 다운캐스팅이 가능.
        CodeSignature codeSignature = (CodeSignature)joinPoint.getSignature();

        String className = codeSignature.getDeclaringTypeName();
        String methodName = codeSignature.getName();
        String[] parameterNames = codeSignature.getParameterNames();
//        매개변수 값 가져오기
        Object[] args = joinPoint.getArgs();

        for(int i = 0; i < parameterNames.length; i++){
//            로그 표현식 사용 가능, 중괄호 안에 차례로 들어간다.
            log.info("<<<< Parameter info >>>> {}.{} >>> [{}: {}]", className, methodName, parameterNames[i], args[i]);
        }

        Object result = joinPoint.proceed();

        log.info("<<<< return >>>> {}.{} >>> [{}]", className, methodName, result);

        return result;
    }

}
