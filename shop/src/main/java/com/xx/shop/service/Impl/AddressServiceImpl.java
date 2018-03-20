package com.xx.shop.service.Impl;

import com.xx.shop.Enum.AddressEnum;
import com.xx.shop.dao.AddressMapper;
import com.xx.shop.entity.Address;
import com.xx.shop.entity.AddressExample;
import com.xx.shop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public int insertAddress(Address address) {
        modifyDefault(address.getIsdefault());
        return addressMapper.insert(address);
    }

    @Transactional
    @Override
    public int modifyaddress(Address address) {
        modifyDefault(address.getIsdefault());
        return addressMapper.updateByPrimaryKey(address);
    }

    private void modifyDefault(int isDefault) {
        AddressEnum defaultType = AddressEnum.Default;
        //如果新增或修改的试默认的地址
        if (isDefault == defaultType.getValue()) {
            AddressExample addressExample = new AddressExample();
            AddressExample.Criteria criteria = addressExample.createCriteria();
            criteria.andIsdefaultEqualTo(isDefault);
            List<Address> defaultAddList = addressMapper.selectByExample(addressExample);
            AddressEnum noDefault = AddressEnum.NoDefault;
            for (Address add : defaultAddList
                    ) {
                //将原来默认地址改成非默认
                add.setIsdefault(noDefault.getValue());
                addressMapper.updateByPrimaryKey(add);
            }
        }
    }

    @Override
    public int deleteAddress(String ids) {
        String[] id = ids.split(",");
        List idList = Arrays.asList(id);//字符数组转list
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andAddressIdIn(idList);
        return addressMapper.deleteByExample(addressExample);
    }
}
