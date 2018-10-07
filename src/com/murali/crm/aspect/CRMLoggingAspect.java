package com.murali.crm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author muralinutalapati
 */
@Aspect
@Component
@Order(1)
public class CRMLoggingAspect {
  private final Logger log = Logger.getLogger(getClass().getName());

  @Pointcut("execution(* com.murali.crm.controller.*.*(..))")
  public void forControllerPackage() {
    // log before controller
  }

  @Pointcut("execution(* com.murali.crm.service.*.*(..))")
  public void forServicePackage() {
    //log before service
  }

  @Pointcut("execution(* com.murali.crm.dao.*.*(..))")
  public void forDAOPackage() {
    //log before DAO
  }

  @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
  public void forAppFlow() {
    // log for controller or service or DAO
  }

  @Before("forAppFlow()")
  public void before(JoinPoint theJoinPoint) {
    final String methodName = theJoinPoint.getSignature().toShortString();
    log.info("@Before: calling method: " + methodName);

    //display the arguments
    Object[] args = theJoinPoint.getArgs();

    for (Object arg : args) {
      log.info("arguments---->>" + arg);
    }

  }

  @AfterReturning(
        pointcut = "forAppFlow()",
        returning = "theResult"
  )
  public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
    final String methodName = theJoinPoint.getSignature().toShortString();
    log.info("@AfterReturning: calling method: " + methodName);

    // display data returned
    log.info("data returned::::---->>>" + theResult);
  }
}
