package com.xxoo.servlet;

import javax.servlet.RequestDispatcher;
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
public class Login extends HttpServlet {

    String dbUsername = "xxstop";
    String dbPassword = "123456";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // set respone utf-8
        response.setContentType("text/html;charset=utf-8");

        // get param
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // compare username and password
        if (username.equals(dbUsername) &&
                password.equals(dbPassword)) {

            // for user session
            HttpSession hs = request.getSession();
            hs.setAttribute("username", username);

            // redirect
            response.sendRedirect("/index.jsp");
        } else {

            // return and show attr
            String error = "用户名或者密码错误!";
            request.setAttribute("username",username);
            request.setAttribute("password",password);
            request.setAttribute("error", error);
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new ServletException("不能直接get请求!");
    }
}
