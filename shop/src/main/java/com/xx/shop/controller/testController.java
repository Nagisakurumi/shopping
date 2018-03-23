package com.xx.shop.controller;

import com.xx.shop.dto.Student;
import com.xx.shop.entity.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping(value="/test")
@Api(value = "testController", description = "REST Apis related to Student")
public class testController {
    @ApiOperation(value = "Get specific Student in the System ", tags = "postUser")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "UserInfo")
    @RequestMapping(value="", method= RequestMethod.POST)
    public String postUser(@RequestBody UserInfo user) {

        return  JSON.toJSONString("s");
    }

}
