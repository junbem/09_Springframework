package com.ohgiraffers.section03.proxy.subsection02.cglib;

import com.ohgiraffers.section03.proxy.common.OhgiraffersStudent;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class Application {
    public static void main(String[] args) {

        /*
        * 1. JDK Dynamic Proxy 방식
        * Target object의 타입이 반드시 interface여야 한다.
        * */

        OhgiraffersStudent ohgiraffersStudent = new OhgiraffersStudent();
        Handler handler = new Handler(ohgiraffersStudent);

        OhgiraffersStudent proxy  = (OhgiraffersStudent) Enhancer.create(OhgiraffersStudent.class,handler);
        proxy.study(16);

    }
}
