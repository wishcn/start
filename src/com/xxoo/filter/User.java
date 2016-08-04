package com.xxoo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by xxstop on 14-6-23.
 */
public class User implements Filter {
    FilterConfig config;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest hsr = (HttpServletRequest)req;

        if (hsr.getSession().getAttribute("username") != null) {
            chain.doFilter(req,resp);
        } else {
            throw new ServletException("亲，你还没有登录呢!");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
