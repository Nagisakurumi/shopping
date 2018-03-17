package com.xx.shop.service.Impl;

import com.xx.shop.dao.AddressMapper;
import com.xx.shop.entity.Address;
import com.xx.shop.entity.AddressExample;
import com.xx.shop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     public boolean updateAddress(Address address)throws Exception {
        try {
            int i = addressMapper.updateByPrimaryKey(address);
            if (i > 0) {
                return true;
            }else{
                return false;
            }
        }
        catch(Exception e){

            throw new Exception(e);
        }
    }
}
