package com.xx.shop.dao;

import com.xx.shop.entity.Store;
import com.xx.shop.entity.StoreExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface StoreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    long countByExample(StoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int deleteByExample(StoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int deleteByPrimaryKey(Long storeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int insert(Store record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int insertSelective(Store record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    List<Store> selectByExample(StoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    Store selectByPrimaryKey(Long storeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int updateByExampleSelective(@Param("record") Store record, @Param("example") StoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int updateByExample(@Param("record") Store record, @Param("example") StoreExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int updateByPrimaryKeySelective(Store record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_store
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int updateByPrimaryKey(Store record);
}