package com.xx.shop.service;

import com.xx.shop.entity.Address;

import java.util.List;

public interface AddressService {
    /**
     * 根据用户id查询所有地址列表
     * @param userId
     * @return
     */
    public List<Address> queryAll(Long userId);

    /**
     * 根据Id查询详细地址
     * @param addressId
     * @return
     */
    public Address getAddresById(Long addressId);

    /**
     * 新增地址
     * @param address
     * @return
     */
    public int insertAddress(Address address);
    /**
     * 更新地址
     * @param address
     * @return
     * @throws Exception
     */
    public int modifyaddress (Address address);

    /**
     * 删除地址
     * @param ids
     * @return
     */
    public int deleteAddress(String ids);
}
