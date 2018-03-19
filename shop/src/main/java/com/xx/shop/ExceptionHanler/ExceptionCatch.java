package com.xx.shop.ExceptionHanler;


import com.xx.shop.ResultModel.ResultMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionCatch {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultMap exceptionCatchHandle(HttpServletRequest seq, Exception e){
        return ResultMap.getResultMap(false, e.getMessage(), null);
    }
}
