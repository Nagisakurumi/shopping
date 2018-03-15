package com.xx.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class ShopCart implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_shopcart.cart_id
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    private Integer cartId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_shopcart.user_id
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_shopcart.product_id
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    private Long productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_shopcart.num
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    private Integer num;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_shopcart.create_time
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_shopcart.update_time
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_shopcart.store_id
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    private Date storeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_shopcart
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_shopcart.cart_id
     *
     * @return the value of t_shopcart.cart_id
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public Integer getCartId() {
        return cartId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_shopcart.cart_id
     *
     * @param cartId the value for t_shopcart.cart_id
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_shopcart.user_id
     *
     * @return the value of t_shopcart.user_id
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_shopcart.user_id
     *
     * @param userId the value for t_shopcart.user_id
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_shopcart.product_id
     *
     * @return the value of t_shopcart.product_id
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_shopcart.product_id
     *
     * @param productId the value for t_shopcart.product_id
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_shopcart.num
     *
     * @return the value of t_shopcart.num
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public Integer getNum() {
        return num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_shopcart.num
     *
     * @param num the value for t_shopcart.num
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_shopcart.create_time
     *
     * @return the value of t_shopcart.create_time
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_shopcart.create_time
     *
     * @param createTime the value for t_shopcart.create_time
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_shopcart.update_time
     *
     * @return the value of t_shopcart.update_time
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_shopcart.update_time
     *
     * @param updateTime the value for t_shopcart.update_time
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_shopcart.store_id
     *
     * @return the value of t_shopcart.store_id
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public Date getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_shopcart.store_id
     *
     * @param storeId the value for t_shopcart.store_id
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    public void setStoreId(Date storeId) {
        this.storeId = storeId;
    }
}