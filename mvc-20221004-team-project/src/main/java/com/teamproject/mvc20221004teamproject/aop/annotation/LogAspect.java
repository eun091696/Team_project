package com.teamproject.mvc20221004teamproject.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//실행 중에사용 가능한 어노테이션
@Retention(RetentionPolicy.RUNTIME)

//클래스, 메소드 위에 어노테이션을 달아도 된다.
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface LogAspect {
}
