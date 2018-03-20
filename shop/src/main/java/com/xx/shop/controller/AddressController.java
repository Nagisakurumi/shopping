package com.xx.shop.controller;

import com.xx.shop.ResultModel.ResultMap;
import com.xx.shop.common.ReturnHelper;
import com.xx.shop.entity.Address;
import com.xx.shop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * 根据用户查询所有用户的地址
     *
     * @param userId
     * @return 地址列表
     */
    @RequestMapping(value = "/getaddresslist", method = RequestMethod.GET)
    public ResultMap getAddressList(Long userId) {
        return ResultMap.getResultMap(true,"",addressService.queryAll(userId));
    }

    /**
     * 根据地址id获取地址的详细
     * @param addressId
     * @return
     */
    @RequestMapping(value = "/{addressId}/getaddressbyid", method = RequestMethod.GET)
    public ResultMap getAddressById(@PathVariable("addressId") Long addressId) {
        addressService.getAddresById(addressId);
        return  ResultMap.getResultMap(true,"",null);
    }

    /**
     * 新增地址
     * @param isdefault
     * @param consignee
     * @param mobile
     * @param provice
     * @param city
     * @param town
     * @param address
     * @return
     */
    @RequestMapping(value = "/insertaddress", method = RequestMethod.POST)
    public ResultMap insertAddress(int isdefault,String consignee,String mobile,String provice,String city,String town ,String address){
        Address add = new Address();
        add.setIsdefault(isdefault);
        add.setConsignee(consignee);
        add.setMobile(mobile);
        add.setProvice(provice);
        add.setCity(city);
        add.setTown(town);
        add.setAddress(address);
        addressService.insertAddress(add);
        return  ResultMap.getResultMap(true,"",null);
    }

    /**
     * 修改地址
     * @param isdefault
     * @param consignee
     * @param mobile
     * @param provice
     * @param city
     * @param town
     * @param address
     * @return
     */
    @RequestMapping(value = "/modifyaddress", method = RequestMethod.POST)
    public ResultMap modifyAddress(int isdefault,String consignee,String mobile,String provice,String city,String town ,String address){
        Address add = new Address();
        add.setIsdefault(isdefault);
        add.setConsignee(consignee);
        add.setMobile(mobile);
        add.setProvice(provice);
        add.setCity(city);
        add.setTown(town);
        add.setAddress(address);
        addressService.modifyaddress(add);
        return  ResultMap.getResultMap(true,"",null);
    }

    /**
     * 根据id串删除地址
     * @param ids
     * @return
     */
    @RequestMapping(value = "/deleteaddress", method = RequestMethod.POST)
    public ResultMap deleteAddress(String ids){
        if(ids.isEmpty()){
            return ResultMap.getErrorResultMap("地址为空");
        } else{
            return ResultMap.getResultMap(addressService.deleteAddress(ids));
        }
    }

}
