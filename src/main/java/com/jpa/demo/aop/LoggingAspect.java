package com.jpa.demo.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Description :
 *
 * @author leejinho
 * @version 1.0
 */
@Aspect
@Component
@Log4j2
public class LoggingAspect {

    // controller 패키지에서 *Controller 클래스에 있는 메서드 중 파라미터 0개인 메서드만
    // service 패키지에서 *Service 클래스에 있는 메서드 중 파라미터 0개인 메서드만
    @Around("execution(* com.jpa..controller.*Controller.*()) || execution(* com.jpa..service.*Service.*())")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {


        log.debug("This - '" + joinPoint.getThis() + "'"); // Advice를 행하는 객체
        log.debug("Kind - '" + joinPoint.getKind() + "'"); // 해당 Advice 의 타입
        log.debug("Target - '" + joinPoint.getTarget() + "'"); // Target 객체

        String type = "";
        String name = joinPoint.getSignature().getDeclaringTypeName();
        // getSignature() : 실행되는 대상 객체의 메서드에 대한 정보를 가지고 옴

        if (name.contains("Controller")) {
            type = "Controller - '";

        } else if (name.contains("Service")) {
            type = "Service - '";
        }

        log.debug(type + name + "." + joinPoint.getSignature().getName() + "()'");
        // getName - 메서드 이름
        return joinPoint.proceed();
    }
}
