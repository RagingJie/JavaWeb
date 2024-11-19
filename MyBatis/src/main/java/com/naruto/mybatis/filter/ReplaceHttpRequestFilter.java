package com.naruto.mybatis.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 将 默认的请求对象 替换为 缓存body的请求对象，即 HttpServletRequest -> CacheBodyRequest
 * @author Naruto
 */
@Component
public class ReplaceHttpRequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // 替换请求对象 HttpServletRequest -> CacheBodyRequest
        CacheBodyRequest cacheBodyRequest = new CacheBodyRequest(httpServletRequest);

        chain.doFilter(cacheBodyRequest, httpServletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}