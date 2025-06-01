package com.ohgiraffers.section03.proxy.subsection01.dynamic;

import com.ohgiraffers.section03.proxy.common.OhgiraffersStudent;
import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.Proxy;

public class Application {
    public static void main(String[] args) {

        /*
        * 2. CGLib 방식
        * Target object의 타입이 Class여도 가능하다.
        * */
        OhgiraffersStudent ohgiraffersStudent = new OhgiraffersStudent();
        Handler handler = new Handler(ohgiraffersStudent);

        Student proxy  = (Student) Proxy.newProxyInstance(handler.getClass().getClassLoader(), new Class[]{Student.class}, handler);
        proxy.study(16);

    }
}
