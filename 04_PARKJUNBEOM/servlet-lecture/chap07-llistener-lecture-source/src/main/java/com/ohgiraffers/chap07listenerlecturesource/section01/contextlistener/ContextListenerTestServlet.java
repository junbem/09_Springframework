package com.ohgiraffers.chap07listenerlecturesource.section01.contextlistener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(value="/context")
public class ContextListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("context listener 확인용 서블릿");

        ServletContext context = request.getServletContext();
        System.out.println("context = " + context);

        /* context에 attr을 추가*/
        context.setAttribute("test", "value");

        /* 동일한 eky로 context에 attr을 추가하면 attributeReplaecd()메소드가 동작*/
        context.setAttribute("test", "value2");

        /* context에서 attr을 제거하면 attributeRemoved()메소드가 동작*/
        context.removeAttribute("test");

    }
}
