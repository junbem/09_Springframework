package com.ohgiraffers.chap05cookiesessionlecturesource.section02.session;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/session-redirect")
public class SessionRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("session.getId() = " + session.getId());

        // request.setAttribute(키, 값) > request.getAttribute(키)
        String firstName = (String)session.getAttribute("firstName");
        String lastName = (String)session.getAttribute("lastName");
        session.removeAttribute("firstName");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>your firstName is " + firstName +", and lastName is "+lastName +"</h1>");
        out.flush();
        out.close();
    }
}
