package com.ohgiraffers.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* 해당 어노테이션이 적용된 클래스의 @ExceptionHandler는 전역적으로 가능하다. */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException ex){
        System.out.println("전역 범위의 Exception Handler 동작");
        System.out.println("message: " + ex.getMessage());
        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(MemberRegistException ex, Model model){
        System.out.println("전역 범위의 Exception Handler 동작");
        System.out.println("message: " + ex.getMessage());
        model.addAttribute("exception", ex);
        return "error/memberRegist";
    }

    /* 모든 타입의 Exception에 대응하기 위해 상위 타입으로 선언된 핸들러 작성*/
    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception e) {
        return "error/default";
    }
}
