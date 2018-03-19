package com.xx.shop.controller;

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
    public Map<String, Object> getAddressList(Long userId) {
        return  ReturnHelper.getReturnMap(true,"",addressService.queryAll(userId));
    }

    /**
     * 根据地址id获取地址的详细
     * @param addressId
     * @return
     */
    @RequestMapping(value = "/{addressId}/getaddressbyid", method = RequestMethod.GET)
    public Map<String, Object> getAddresById(@PathVariable("addressId") Long addressId) {
        return  ReturnHelper.getReturnMap(true,"",addressService.getAddresById(addressId));
    }

    /**
     * 更新地址
     * @param address
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/modifyaddress", method = RequestMethod.POST)
    public int modifyaddress(Address address){
        return addressService.modifyaddress(address);
    }

    /**
     * 根据id串删除地址
     * @param ids
     * @return
     */
    @RequestMapping(value = "/deleteaddress", method = RequestMethod.POST)
    public Map<String,Object> deleteAddress(String ids){
        if(ids.isEmpty()){
            return ReturnHelper.getReturnMap(false,"地址为空","");
        } else{
            addressService.deleteAddress(ids);
            return ReturnHelper.getReturnMap(true,"","");
        }
    }

}
