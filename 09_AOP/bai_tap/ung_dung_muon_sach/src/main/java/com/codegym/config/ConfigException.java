package com.codegym.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;

import java.util.Arrays;

public class ConfigException {
    @AfterThrowing(pointcut = "execution(public * com.book.service.BookService.update(..))",throwing = "e")
    public void borrowError(JoinPoint joinPoint, Exception e){
        String argName= Arrays.toString(joinPoint.getArgs());
        System.err.printf("Da het sach %s",argName);
    }
}
