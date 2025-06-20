package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new GenericXmlApplicationContext("seciton01/xmlconfig/spring-config.xml");
        String[] definitionName = applicationContext.getBeanDefinitionNames();
        for (String name : definitionName) {
            System.out.println("definitionName: " + definitionName);
        }
        MemberDTO member = applicationContext.getBean("member", MemberDTO.class);
        System.out.println(member.getPersonalAccount().getBalance());
    }
}
