package com.github.zuihou.base.dao;


import com.github.zuihou.base.entity.BaseEntity;
import com.github.zuihou.example.BaseExample;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 包含 appId字段 的类， 需要继承该dao
 *
 * @author zuihou
 * @createTime 2017-12-08 17:37
 */
public interface BaseDao<I extends Serializable, T extends BaseEntity<I>, TE extends BaseExample> extends BaseNormalDao<I, T, TE> {

    int deleteByAppIdAndId(@Param("appId") String appId, @Param("id") I id);//1

    /**
     * add
     *
     * @param list
     * @return
     */
    int deleteByAppIdAndIds(@Param("appId") String appId, @Param("list") Collection<I> list);//1

    /**
     * add
     *
     * @param list
     * @return
     */
    int removeByAppIdAndIds(@Param("appId") String appId, @Param("list") Collection<I> list);//1

    /**
     * add
     *
     * @param id
     * @return
     */
    int removeByAppIdAndId(@Param("appId") String appId, @Param("id") I id);//1

    /**
     * add
     *
     * @param appId
     * @param id
     * @return
     */
    T selectByAppIdAndId(@Param("appId") String appId, @Param("id") I id); //1

    /**
     * 根据appId+id，修改不为null的字段
     *
     * @param record 实体
     */
    int updateByAppIdAndIdSelective(T record);

    /**
     * 根据appId+id，覆盖修改所有的字段
     *
     * @param record 实体
     */
    int updateByAppIdAndId(T record);

    /**
     * 查询 appId
     *
     * @param id 主键
     * @return
     */
    String selectAppIdById(I id);
}
