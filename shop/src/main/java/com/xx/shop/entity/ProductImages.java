package com.xx.shop.entity;

import java.io.Serializable;

public class ProductImages implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_images.img_id
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    private Long imgId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_images.pid
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    private Long pid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_images.img_url
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    private String imgUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_images.ismain
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    private Byte ismain;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_images.sort
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    private Integer sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_images.store_id
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    private Long storeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_product_images
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_images.img_id
     *
     * @return the value of t_product_images.img_id
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    public Long getImgId() {
        return imgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_images.img_id
     *
     * @param imgId the value for t_product_images.img_id
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_images.pid
     *
     * @return the value of t_product_images.pid
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    public Long getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_images.pid
     *
     * @param pid the value for t_product_images.pid
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_images.img_url
     *
     * @return the value of t_product_images.img_url
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_images.img_url
     *
     * @param imgUrl the value for t_product_images.img_url
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_images.ismain
     *
     * @return the value of t_product_images.ismain
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    public Byte getIsmain() {
        return ismain;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_images.ismain
     *
     * @param ismain the value for t_product_images.ismain
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    public void setIsmain(Byte ismain) {
        this.ismain = ismain;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_images.sort
     *
     * @return the value of t_product_images.sort
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_images.sort
     *
     * @param sort the value for t_product_images.sort
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_images.store_id
     *
     * @return the value of t_product_images.store_id
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_images.store_id
     *
     * @param storeId the value for t_product_images.store_id
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}