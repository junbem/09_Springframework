package com.ohgiraffers.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
/*
* proxyTargetclass = true : Proxy 객체 생성의 방식으로 CGLib방식을 사용
* target object가 class 인 경우에도 proxy 객체 생성 가능
* */
@EnableAspectJAutoProxy(proxyTargetClass = true)
// Aspect(분리된 횡단 관심사) : point-cut (심입 시점) + Advice(부가코드)
public class ContextConfiguration {

}
