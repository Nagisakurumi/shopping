package com.xx.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class Store implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_store.store_id
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    private Long storeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_store.store_name
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    private String storeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_store.storerank_id
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    private Integer storerankId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_store.logo
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    private String logo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_store.create_time
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_store.describtion
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    private String describtion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_store.honesties
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    private Integer honesties;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_store
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_store.store_id
     *
     * @return the value of t_store.store_id
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_store.store_id
     *
     * @param storeId the value for t_store.store_id
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_store.store_name
     *
     * @return the value of t_store.store_name
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_store.store_name
     *
     * @param storeName the value for t_store.store_name
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_store.storerank_id
     *
     * @return the value of t_store.storerank_id
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    public Integer getStorerankId() {
        return storerankId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_store.storerank_id
     *
     * @param storerankId the value for t_store.storerank_id
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    public void setStorerankId(Integer storerankId) {
        this.storerankId = storerankId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_store.logo
     *
     * @return the value of t_store.logo
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    public String getLogo() {
        return logo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_store.logo
     *
     * @param logo the value for t_store.logo
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_store.create_time
     *
     * @return the value of t_store.create_time
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_store.create_time
     *
     * @param createTime the value for t_store.create_time
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_store.describtion
     *
     * @return the value of t_store.describtion
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    public String getDescribtion() {
        return describtion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_store.describtion
     *
     * @param describtion the value for t_store.describtion
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    public void setDescribtion(String describtion) {
        this.describtion = describtion == null ? null : describtion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_store.honesties
     *
     * @return the value of t_store.honesties
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    public Integer getHonesties() {
        return honesties;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_store.honesties
     *
     * @param honesties the value for t_store.honesties
     *
     * @mbg.generated Mon Mar 19 21:20:53 CST 2018
     */
    public void setHonesties(Integer honesties) {
        this.honesties = honesties;
    }
}