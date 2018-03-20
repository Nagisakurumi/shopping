package com.xx.shop.controller;

import com.xx.shop.ResultModel.ResultMap;
import com.xx.shop.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    /**
     * 添加一个店铺接口
     * @param storeName
     * @param logoimage
     * @param describtion
     * @return
     */
    @RequestMapping(value = "/addstore", method = RequestMethod.POST)
    public ResultMap addStore(long userid, String storeName, String logoimage, String describtion) throws Exception {
        if(storeService.addStore(userid, storeName, logoimage, describtion)){
            return ResultMap.getResultMap(true, "添加店铺成功", null);
        }else{
            return ResultMap.getResultMap(false, "添加店铺失败", null);
        }
    }

    /**
     * 获取店铺列表
      * @param isup 排序 1.升序,2.降序,其他不排序
     * @param startindex 分页页码
     * @param length 分页每页长度
     * @param byranktype 排序的字段1.排名排序 2.信用排序 其他不排序
     * @return
     */
    @RequestMapping(value = "/stroelist" , method = RequestMethod.POST)
    public ResultMap getStoreList(int isup, int startindex, int length, int byranktype){
        if(isup == 1 || isup == 2){
            if(byranktype == 1){
                return ResultMap.getResultMap(true, "获取按照排名店铺内容成功",
                        storeService.getStoreByRank(isup == 1 ? true : false, startindex, length));
            }else if(byranktype == 2){
                return ResultMap.getResultMap(true, "获取按照信用店铺内容成功",
                        storeService.getStoreByHonesties(isup == 1 ? true : false, startindex, length));
            }else{
                return ResultMap.getResultMap(true, "获取店铺列表成功", storeService.getStoreList(startindex, length));
            }
        }else{
            return ResultMap.getResultMap(true, "获取店铺列表成功", storeService.getStoreList(startindex, length));
        }
    }

    /**
     * 根据店铺名模糊查询
     * @param storename
     * @return
     */
    @RequestMapping(value = "/storefind", method = RequestMethod.POST)
    public ResultMap getStoreByName(String storename){
        return ResultMap.getResultMap(true, "获取店铺列表", storeService.getStoreByName(storename));
    }

    /**
     * 注销店铺接口
     * @param userid
     * @return
     */
    @RequestMapping(value = "/deletestore", method = RequestMethod.POST)
    public ResultMap deleteStore(long userid) throws Exception {
        return storeService.deleteStore(userid);
    }
}
