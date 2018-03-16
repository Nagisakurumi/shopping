package com.xx.shop.service;

import com.xx.shop.entity.Address;
import com.xx.shop.entity.AddressExample;

import java.util.List;

public interface AddressService {
    public List<Address> queryAll(Long userId);
    public Address getAddresById(Long addressId);
    public boolean updateAddress (Address address) throws Exception;
}
