package tn.esprit.ds.championnat.configuration;



import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
@Slf4j

public class ChampionnatAspect {

    @Pointcut("execution(* tn.esprit.ds.championnat.services.*.*(..))")
    public void servicePointcut() {}

    @Before("servicePointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("===== @Before =====");
        log.info("Méthode appelée : {}", joinPoint.getSignature().getName());
        log.info("Paramètres      : {}", Arrays.toString(joinPoint.getArgs()));
        log.info("===================");
    }

    @After("servicePointcut()")
    public void afterAdvice(JoinPoint joinPoint) {
        log.info("===== @After =====");
        log.info("Méthode terminée : {}", joinPoint.getSignature().getName());
        log.info("==================");
    }

    @Around("servicePointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("===== @Around - DÉBUT =====");
        log.info("Méthode : {}", joinPoint.getSignature().getName());

        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // exécute la méthode

        long endTime = System.currentTimeMillis();

        log.info("Temps d'exécution : {} ms", (endTime - startTime));
        log.info("===== @Around - FIN =====");

        return result;
    }


}
