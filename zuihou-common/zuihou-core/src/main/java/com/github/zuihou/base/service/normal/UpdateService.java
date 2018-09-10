
package com.github.zuihou.base.service.normal;

import java.io.Serializable;
import java.util.Collection;

import com.github.zuihou.base.entity.BaseEntity;
import com.github.zuihou.example.BaseExample;


public interface UpdateService<I extends Serializable, T extends BaseEntity<I>,  TE extends BaseExample> {

	/**
     * 更新
     *
     * @param entity
     * @return 影响行数
     */
    int updateById(T entity);
    
    /**
     * 批量更新
     * @param entityList
     * @return 影响行数
     */
    int updateByIds(Collection<T> entityList);
    
    /**
     * 更新非空字段的值
     * @param entity
     * @return 影响行数
     */
    int updateByIdSelective(T entity);
    
    /**
     * 批量更新非空字段的值
     * @param entityList
     * @return 影响行数
     */
    int updateByIdSelective(Collection<T> entityList);
}