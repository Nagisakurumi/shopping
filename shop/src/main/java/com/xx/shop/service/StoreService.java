package com.xx.shop.service;

import com.xx.shop.ResultModel.ResultMap;
import com.xx.shop.entity.Store;

import java.util.List;

public interface StoreService {
    /**
     * 添加一个店铺
      * @param userid
     * @param storeName
     * @param logoimage
     * @param describtion
     * @return
     */
    public boolean addStore(long userid, String storeName, String logoimage, String describtion) throws Exception;

    /**
     * 根据店铺名称获取店铺
     * @param storeName
     * @return
     */
    public List<Store> getStoreByName(String storeName);

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

    /**
     * 获取店铺列表
     * @param startindex
     * @param length
     * @return
     */
    public List<Store> getStoreList(int startindex, int length);

    /**
     * 修改店铺信息
     * @param storeName
     * @param logoimage
     * @param describtion
     */
    public boolean midifyStoreInfo(String storeName, String newstorename, String logoimage, String describtion);

    /**
     * 删除店铺
     * @param userid
     * @return
     */
    public ResultMap deleteStore(long userid) throws Exception;
}
