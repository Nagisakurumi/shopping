package com.xx.shop.controller;

import com.xx.shop.common.SessionHelper;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

public class BaseController {
    /** 日志 */
    protected Logger logger = Logger.getLogger(String.valueOf(this.getClass()));
    /**打印日志*/
    protected void logInfo(HttpServletRequest request, String msg){
        logger.info(SessionHelper.getLogHead(request)+msg);
    }
    protected void logError(HttpServletRequest request,String msg,Throwable e){
        logger.error(SessionHelper.getLogHead(request)+msg,e);
    }protected void logError(String msg,Throwable e){
        logger.error(msg,e);
    }
}
