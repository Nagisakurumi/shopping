package com.xx.shop.dao;

import com.xx.shop.entity.Address;
import com.xx.shop.entity.AddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    long countByExample(AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int deleteByExample(AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int deleteByPrimaryKey(Long addressId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int insert(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int insertSelective(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    List<Address> selectByExample(AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    Address selectByPrimaryKey(Long addressId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int updateByPrimaryKeySelective(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_address
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int updateByPrimaryKey(Address record);
}