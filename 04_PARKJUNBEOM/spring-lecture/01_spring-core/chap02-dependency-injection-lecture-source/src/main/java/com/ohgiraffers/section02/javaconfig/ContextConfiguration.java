package com.ohgiraffers.section02.javaconfig;

import org.springframework.context.annotation.Bean;

public class ContextConfiguration {

    @Bean
    public Account accountGenerator() {
        return new PersonalAccount(20, "110-234-567890");
    }

    /* bean 등록에 상요된 메소드를 호출하여 의존성 주입을 처리할 수 있다.*/

    @Bean
    public MemberDTO memberGenerator() {
        /* MemberDTO 생성자를 통해 Account를 생성하는 메소드를 호출한 리턴 값을 전달하여 bean을 조립할 수 있다. */
        return new MemberDTO(1, "홍길동", "010-1234-5678", "hong123@gmail.com", accountGenerator());
    }

}
