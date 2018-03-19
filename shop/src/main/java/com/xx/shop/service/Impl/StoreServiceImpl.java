package com.xx.shop.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xx.shop.dao.StoreMapper;
import com.xx.shop.entity.Store;
import com.xx.shop.entity.StoreExample;
import com.xx.shop.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StoreServiceImpl implements   StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public boolean addStore(String storeName, String logoimage, String describtion) {

        if(getStoreByName(storeName) != null){
            return false;
        }

        Store store = new Store();
        store.setStoreName(storeName);
        store.setLogo(logoimage);
        store.setStorerankId(0);
        store.setCreateTime(new Date());
        store.setDescribtion(describtion);
        store.setHonesties(0);
        storeMapper.insert(store);
        return true;
    }

    @Override
    public Store getStoreByName(String storeName) {
        StoreExample storeExample = new StoreExample();
        StoreExample.Criteria criteria = storeExample.createCriteria();
        criteria.andStoreNameEqualTo(storeName);
        return storeMapper.selectByExample(storeExample).get(0);
    }

    @Override
    public List<Store> getStoreByRank(boolean isup, int startindex, int length) {
        PageHelper.startPage(startindex, length);
        StoreExample storeExample = new StoreExample();
        storeExample.setOrderByClause("getStorerankId " +  (isup ? "ASC" : "desc"));
        return storeMapper.selectByExample(storeExample);
    }

    @Override
    public List<Store> getStoreByHonesties(boolean isup, int startindex, int length) {
        PageHelper.startPage(startindex, length);
        StoreExample storeExample = new StoreExample();
        storeExample.setOrderByClause("honesties " +  (isup ? "ASC" : "desc"));
        return storeMapper.selectByExample(storeExample);
    }

    @Override
    public boolean midifyStoreInfo(String storeName, String newstorename, String logoimage, String describtion) {
        if(getStoreByName(newstorename) != null){
            return false;
        }
        if(getStoreByName(storeName) == null){
            return false;
        }
        Store store = getStoreByName(storeName);
        store.setStoreName(newstorename);
        store.setLogo(logoimage);
        store.setDescribtion(describtion);
        storeMapper.updateByPrimaryKey(store);
        return true;
    }
}
