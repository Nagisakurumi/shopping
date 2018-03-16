package com.xx.shop.dao;

import com.xx.shop.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTest {

    @Autowired
    private  AddressMapper addressMapper;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void countByExample() {
    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
//        Address address = new Address();
//        address.setUserId((long)0);
//        address.setConsignee("梅精翔");
//        address.setMobile("18368404781");
//        address.setProvice("中国");
//        address.setCity("杭州");
//        address.setTown("滨江");
//        address.setAddress("青松宜家");
//        address.setIsdefault(new byte[]{1});
//
//        addressMapper.insert(address);
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByExampleWithBLOBs() {
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void updateByExampleWithBLOBs() {
    }

    @Test
    public void updateByExample() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKeyWithBLOBs() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}