package com.xx.shop.service.Impl;

import com.github.pagehelper.PageHelper;
import com.xx.shop.ResultModel.ResultMap;
import com.xx.shop.dao.StoreMapper;
import com.xx.shop.entity.Store;
import com.xx.shop.entity.StoreExample;
import com.xx.shop.entity.UserInfo;
import com.xx.shop.service.MailService;
import com.xx.shop.service.StoreService;
import com.xx.shop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StoreServiceImpl implements   StoreService {

    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private MailService mailService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addStore(long userid, String storeName, String logoimage, String describtion) throws Exception {

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
        if(storeMapper.insert(store) != 1){
            throw new Exception("插入店铺信息失败");
        }
        store = null;
        store = getStoreByName(storeName).get(0);
        if(userInfoService.setUserStore(userid, store.getStoreId()) == false){
            throw new Exception("修改用户店铺信息失败");
        }
        return true;
    }

    @Override
    public List<Store> getStoreByName(String storeName) {
        StoreExample storeExample = new StoreExample();
        StoreExample.Criteria criteria = storeExample.createCriteria();
        criteria.andStoreNameGreaterThanOrEqualTo(storeName);
        return storeMapper.selectByExample(storeExample);
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
    public List<Store> getStoreList(int startindex, int length) {
        PageHelper.startPage(startindex, length);
        StoreExample storeExample = new StoreExample();
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
        Store store = getStoreByName(storeName).get(0);
        store.setStoreName(newstorename);
        store.setLogo(logoimage);
        store.setDescribtion(describtion);
        storeMapper.updateByPrimaryKey(store);
        return true;
    }

    @Override
    @Transactional
    public ResultMap deleteStore(long userid) throws Exception {
        UserInfo userInfo =  userInfoService.getUserInfoById(userid);
        if(userInfo == null){
            throw new Exception("不存在的用户");
        }else{
            if(storeMapper.deleteByPrimaryKey(userInfo.getStoreId()) == 1){

                if(userInfoService.setUserStore(userid,-1L)){
                    throw new Exception("修改用户信息失败");
                }else{
                    mailService.send(userInfo.getEmail(), "注销店铺", "您的店铺已经被注销了，如果不是本人操作，请及时联系客服。");
                    return ResultMap.getResultMap(true, "成功注销店铺", null);
                }
            }else{
                throw new Exception("删除失败");
            }
        }
    }
}
