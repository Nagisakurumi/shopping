package com.xx.shop.common;

import java.util.HashMap;
import java.util.Map;

public class ReturnHelper<T> {

//    /**
//     * 获取一个用于返回的规范格式
//     * @param stuta
//     * @param msg
//     * @param data
//     * @return
//     */
//    public static Map<String, Object> getReturnMap(boolean stuta, String msg, Object data){
//        Map<String, Object> model = new HashMap<>();
//        model.put("success", stuta);
//        model.put("msg", msg);
//        model.put("data", data);
//        return model;
//    }
    public boolean success =false;
    public T data;
    public String msg;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ReturnHelper(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public ReturnHelper(String msg) {
        this.msg = msg;
    }
}
