package com.stylefeng.guns.modular.system.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;



public interface CategoryDao {
	/**
     * 查询所有的类目
     *
     * @param code
     * @return
     * @date 2017年2月13日 下午11:11:28
     */
    List<Map<String,Object>> queryAllGoods(@Param("status") String status);
    
    /**
     * 查询类目下所有产品
     * @param categoryId
     * @param status
     * @param enable
     * @return
     */
    List<Map<String,Object>> queryProducts(@Param("isPush") String isPush,@Param("nameLike") String nameLike,@Param("categoryId") String categoryId,@Param("status") String status,@Param("enable")String enable,@Param("isBanner")String isBanner);
    
}
