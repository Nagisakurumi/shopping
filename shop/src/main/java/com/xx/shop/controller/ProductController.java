package com.xx.shop.controller;

import com.xx.shop.ResultModel.ResultMap;
import com.xx.shop.entity.Product;
import com.xx.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    public ProductService proService;

    @RequestMapping(value = "/queryprolist", method = RequestMethod.GET)
    public ResultMap queryProList(int pageSize, int pageIndex, String order, boolean isAsc) {
        if (pageIndex < 1000) {
            return ResultMap.getResultMap(proService.queryProList(pageSize, pageIndex, order, isAsc));
        } else {
            return ResultMap.getErrorResultMap("请求数据过多");

        }
    }

    @RequestMapping(value = "/querylistbycate", method = RequestMethod.GET)
    public ResultMap queryListByCate(int pageSize, int pageIndex, int cateId, String order, boolean isAsc) {
        if (pageIndex < 1000) {
            return ResultMap.getResultMap(proService.queryListByCate(pageSize, pageIndex, cateId, order, isAsc));
        } else {
            return ResultMap.getErrorResultMap("请求数据过多");
        }
    }
    @RequestMapping(value = "/getdetail", method = RequestMethod.GET)
    public ResultMap getDetail(long proId) {
            return ResultMap.getResultMap(proService.getDetail(proId));
    }


}
