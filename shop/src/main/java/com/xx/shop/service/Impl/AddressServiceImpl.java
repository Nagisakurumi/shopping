package com.xx.shop.service.Impl;

import com.xx.shop.dao.AddressMapper;
import com.xx.shop.entity.Address;
import com.xx.shop.entity.AddressExample;
import com.xx.shop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> queryAll(Long userId) {

        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return addressMapper.selectByExample(addressExample);
    }

    @Override
    public Address getAddresById(Long addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }

    @Override
     public int modifyaddress(Address address){
//        byte[] bit = {1};
//        if(address.getIsdefault() == bit){
//            modifyDefault();
//        }
        return addressMapper.updateByPrimaryKey(address);


    }

    private void modifyDefault() {
//        AddressExample addressExample = new AddressExample();
//        AddressExample.Criteria criteria = addressExample.createCriteria();
//        criteria.
    }

    @Override
    public int deleteAddress(String ids) {
            String[] id = ids.split(",");
            List idList  = Arrays.asList(id);//字符数组转list
            AddressExample addressExample = new AddressExample();
            AddressExample.Criteria criteria = addressExample.createCriteria();
            criteria.andAddressIdIn(idList);
            return addressMapper.deleteByExample(addressExample);
    }
}
