package com.xx.shop.common;

import com.xx.shop.ResultModel.ResultMap;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRoleAuthorizationInterceptor extends HandlerInterceptorAdapter {
    /**
     * 用于的sessionkey
     */
    private final static String userSessionName = "userinfo";
    // 在业务处理器处理请求之前被调用
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        // equalsIgnoreCase 与 equals的区别？
        if("GET".equalsIgnoreCase(request.getMethod())){
            //RequestUtil.saveRequest();
        }
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        String username = (String) request.getSession().getAttribute(userSessionName);
        if(null == username){
            // 跳转到登录页面
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return true;
        }
        else{
            return false;
        }
    }

}
