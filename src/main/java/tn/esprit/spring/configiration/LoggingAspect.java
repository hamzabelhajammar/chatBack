package tn.esprit.spring.configiration;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;



//ToDo#1
//ToDo#2

@Component
@Aspect
public class LoggingAspect {

	@Before("execution(* tn.esprit.spring.service.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
            long start = System.currentTimeMillis();
            long elapsedTime = System.currentTimeMillis() - start;
            String name = joinPoint.getSignature().getName();
            System.out.println("In method " + name + " : ");
    }

}