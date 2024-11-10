package com.naruto.ssm.springMVC_practise.common.interceptor;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author
 * @Date 2024/11/10 23:35
 * @Description: 自定义拦截器
 */
@Component
public class MyHandlerInterceptor0 implements HandlerInterceptor {

    /**
     * @param request  HTTP 请求对象，可以通过它获取请求的相关信息。
     * @param response HTTP 响应对象，可以用来设置响应头或直接写入响应内容。
     * @param handler  即将被调用的处理器对象（通常是Controller中的某个方法）。
     * @return boolean
     * @author Naruto
     * @date 2024/11/10 23:37
     * @description 该方法会在控制器方法调用之前执行。
     * 如果返回值为 true，则继续执行下一个拦截器或控制器方法；
     * 如果返回值为 false，则中断请求处理流程，不再执行后续的拦截器和控制器方法。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyHandlerInterceptor0.......preHandle...");
//        if (request.getHeader("username").equals("zhangsan")) {
//            response.setContentType("application/json;charset=UTF-8");
//            response.getWriter().write("没有权限");
//            return false;
//        }
        return true;
    }

    /**
     * @param request      HTTP 请求对象，可以通过它获取请求的相关信息。
     * @param response     HTTP 响应对象，可以用来设置响应头或直接写入响应内容。
     * @param handler      即将被调用的处理器对象（通常是Controller中的某个方法）。
     * @param modelAndView 包含视图和模型数据的对象，可以在其中添加额外的数据或更改视图。
     * @return void
     * @author Naruto
     * @date 2024/11/10 23:38
     * @description 该方法在控制器方法调用后，但在视图渲染之前执行。
     * 它可以修改 ModelAndView 对象，影响视图的选择或模型数据的添加。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyHandlerInterceptor0.......postHandle...");
    }

    /**
     * @param request  HTTP 请求对象，可以通过它获取请求的相关信息。
     * @param response HTTP 响应对象，可以用来设置响应头或直接写入响应内容。
     * @param handler  即将被调用的处理器对象（通常是Controller中的某个方法）。
     * @param ex       如果请求处理过程中发生了异常，这个参数会包含该异常信息。
     * @return void
     * @author Naruto
     * @date 2024/11/10 23:38
     * @description 该方法在整个请求处理完成后执行，无论是在成功响应还是异常抛出后。它通常用于资源清理工作。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyHandlerInterceptor0.......afterCompletion...");
    }
}
