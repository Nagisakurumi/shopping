package com.xx.shop.service;

import com.xx.shop.entity.Store;

import java.util.List;

public interface StoreService {
    /**
     * 添加一个店铺
     * @param storeName
     * @param logoimage
     * @return
     */
    public boolean addStore(String storeName, String logoimage, String describtion);

    /**
     * 根据店铺名称获取店铺
     * @param storeName
     * @return
     */
    public Store getStoreByName(String storeName);

    /**
     * \根据排序获取店铺列表
     * @param isup
     * @return
     */
    public List<Store>getStoreByRank(boolean isup, int startindex, int length);

    /**
     * 根据信誉获取店铺
     * @param isup
     * @param startindex
     * @param length
     * @return
     */
    public List<Store> getStoreByHonesties(boolean isup, int startindex, int length);
}
