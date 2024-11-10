package com.naruto.ssm.springMVC_practise.common.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author
 * @Date 2024/11/11 0:32
 * @Description:
 */
@Component
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤器前置工作......");
        chain.doFilter(request, response);
        System.out.println("过滤器后置工作......");
    }

    @Override
    public void destroy() {

    }
}
