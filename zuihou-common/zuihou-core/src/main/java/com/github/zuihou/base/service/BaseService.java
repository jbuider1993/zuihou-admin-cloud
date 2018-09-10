package com.github.zuihou.base.service;

import java.io.Serializable;

import com.github.zuihou.base.entity.BaseEntity;
import com.github.zuihou.base.service.normal.BaseNormalService;
import com.github.zuihou.base.service.specific.BaseSpecificService;
import com.github.zuihou.example.BaseExample;

/**
 * This is a Description
 *
 * @author tangyh
 * @date 2018/09/04
 */
public interface BaseService<I extends Serializable, T extends BaseEntity<I>, TE extends BaseExample>
        extends BaseNormalService<I, T, TE>, BaseSpecificService<I, T, TE> {

}
