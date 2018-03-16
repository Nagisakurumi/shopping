package com.xx.shop.controller;

import com.xx.shop.entity.Address;
import com.xx.shop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
    @RequestMapping(value = "/{userId}/getaddresslist", method = RequestMethod.GET)
    public Map<String, Object> getAddressList(@PathVariable("userId") Long userId) {
        Map<String, Object> obj = new HashMap<>();
        return (Map<String, Object>) obj.put("addressList", addressService.queryAll(userId));
    }

    /**
     * 根据地址id获取地址的详细
     *
     * @param addressId
     * @return
     */
    @RequestMapping(value = "/{addressId}/getaddressbyid", method = RequestMethod.GET)
    public Address getAddresById(@PathVariable("addressId") Long addressId) {
        return addressService.getAddresById(addressId);
    }
    @RequestMapping(value = "/updateaddress", method = RequestMethod.POST)
    public boolean updateAddress(Address address) throws Exception {
        return addressService.updateAddress(address);
    }
}
