package com.xx.shop.dao;

import com.xx.shop.entity.PointLog;
import com.xx.shop.entity.PointLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PointLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_point_log
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    long countByExample(PointLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_point_log
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int deleteByExample(PointLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_point_log
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int deleteByPrimaryKey(Integer logid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_point_log
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int insert(PointLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_point_log
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int insertSelective(PointLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_point_log
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    List<PointLog> selectByExample(PointLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_point_log
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    PointLog selectByPrimaryKey(Integer logid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_point_log
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int updateByExampleSelective(@Param("record") PointLog record, @Param("example") PointLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_point_log
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int updateByExample(@Param("record") PointLog record, @Param("example") PointLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_point_log
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int updateByPrimaryKeySelective(PointLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_point_log
     *
     * @mbg.generated Thu Mar 22 23:08:19 CST 2018
     */
    int updateByPrimaryKey(PointLog record);
}