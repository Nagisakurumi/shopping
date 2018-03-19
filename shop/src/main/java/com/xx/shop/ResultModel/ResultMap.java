package com.xx.shop.ResultModel;

public class ResultMap {
    /**
     * 是否操作接口成功
     */
    public boolean success = false;
    /**
     * 接口返回的提示消息
     */
    public String msg = "";
    /**
     * 接口返回的数据
     */
    public Object data = null;

    /**
     * 获取统一返回信息类
     * @param success
     * @param msg
     * @param data
     * @return
     */
    public static  ResultMap getResultMap(boolean success, String msg, Object data){
        ResultMap resultMap = new ResultMap();
        resultMap.success = success;
        resultMap.msg = msg;
        resultMap.data = data;
        return resultMap;
    }
}
