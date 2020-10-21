package com.qfedu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author: Elegent(丁文渊)
 * @date: 2020/10/19 19:24
 * @description:
 */
@WebFilter("/*")
public class CROSfilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
