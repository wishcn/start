package com.xxoo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.xml.ws.Response;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xxstop on 14-6-23.
 */
public class Hello extends HttpServlet {

    public void init() throws ServletException {
        System.out.println("我是init()方法！用来进行初始化工作");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        PrintWriter pw = response.getWriter();

        HttpSession ss = request.getSession();
        ss.setAttribute("xxoo", "Session");

        Cookie ck = new Cookie("xxoo", "Cookie");
        ck.setValue("Setcookie");

        String st = "This is a simple example!";

        pw.print("<title>Hello World</title>");
        pw.print((request.getParameter("xxoo") != null ? request.getParameter("xxoo") : "")+"\n");
        pw.print(ck.getValue()+"\n");
        pw.print(ss.getAttribute("xxoo")+"\n");
        pw.print(st.toString()+"\n");
    }
}
