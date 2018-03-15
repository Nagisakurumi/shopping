package com.xx.shop.dao;

import com.xx.shop.entity.ProductImages;
import com.xx.shop.entity.ProductImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductImagesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product_images
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    long countByExample(ProductImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product_images
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int deleteByExample(ProductImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product_images
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int deleteByPrimaryKey(Long imgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product_images
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int insert(ProductImages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product_images
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int insertSelective(ProductImages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product_images
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    List<ProductImages> selectByExample(ProductImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product_images
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    ProductImages selectByPrimaryKey(Long imgId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product_images
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int updateByExampleSelective(@Param("record") ProductImages record, @Param("example") ProductImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product_images
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int updateByExample(@Param("record") ProductImages record, @Param("example") ProductImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product_images
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int updateByPrimaryKeySelective(ProductImages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product_images
     *
     * @mbg.generated Thu Mar 15 15:46:48 CST 2018
     */
    int updateByPrimaryKey(ProductImages record);
}