package com.xx.shop.controller;

import com.xx.shop.ResultModel.ResultMap;
import com.xx.shop.common.ReturnHelper;
import com.xx.shop.entity.Address;
import com.xx.shop.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/address")
@Api(tags = "Swagger演示")
public class AddressController {

    @Autowired
    private AddressService addressService;
    /**
     * 根据用户查询所有用户的地址
     * @param userId 用户id
     * @return 地址列表
     */
    @RequestMapping(value = "/getAddressList", method = RequestMethod.GET)
    @ApiOperation("根据用户查询所有用户的地址")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="userId",dataType="Long",required=true,value="用户Id",defaultValue="1 ")
    })
    public ResultMap getAddressList(Long userId) {
        return ResultMap.getResultMap(addressService.queryAll(userId));
    }

    /**
     * 根据地址id获取地址的详细
     * @param addressId 地址Id
     * @return
     */
    @RequestMapping(value = "/getAddressById", method = RequestMethod.GET)
    public ResultMap getAddressById(Long addressId) {
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
    @RequestMapping(value = "/insertAddress", method = RequestMethod.POST)
    public ResultMap insertAddress(@RequestParam("isdefault") int  isdefault, @RequestParam("consignee") String consignee, @RequestParam("mobile") String mobile, @RequestParam("provice") String provice, @RequestParam("city") String city, @RequestParam("town") String town , @RequestParam("address") String address){
        Address add = new Address();
        add.setIsdefault(isdefault);
        add.setConsignee(consignee);
        add.setMobile(mobile);
        add.setProvice(provice);
        add.setCity(city);
        add.setTown(town);
        add.setAddress(address);
        add.setUserId((long) 1);
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
    @RequestMapping(value = "/modifyAddress", method = RequestMethod.POST)
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
    @RequestMapping(value = "/deleteAddress", method = RequestMethod.POST)
    public ResultMap deleteAddress(String ids){
        if(ids.isEmpty()){
            return ResultMap.getErrorResultMap("地址为空");
        } else{
            return ResultMap.getResultMap(addressService.deleteAddress(ids));
        }
    }

}
