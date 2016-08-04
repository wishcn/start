package com.xxoo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xxstop on 14-6-23.
 */
public class Loginout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new ServletException("不能直接post请求!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get writer
        PrintWriter pw = response.getWriter();

        // remove session attr
        HttpSession hs = request.getSession();
        hs.removeAttribute("username");

        // print
        pw.print("loginout");

        // redirect
        response.sendRedirect("/");
    }
}
