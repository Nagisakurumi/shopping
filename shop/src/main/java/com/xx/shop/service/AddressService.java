package com.xx.shop.service;

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
