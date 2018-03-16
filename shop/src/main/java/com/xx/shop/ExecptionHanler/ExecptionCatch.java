package com.xx.shop.ExecptionHanler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExecptionCatch {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> exceptionCatchHandle(HttpServletRequest seq, Exception e){
        Map<String, Object> resobj = new HashMap<String, Object>();
        resobj.put("success", "false");
        resobj.put("message", e.getMessage());
        return resobj;
    }
}
