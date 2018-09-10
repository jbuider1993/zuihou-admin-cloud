package com.github.zuihou.base.dao;

import java.io.Serializable;

import com.github.zuihou.base.dao.normal.Delete;
import com.github.zuihou.base.dao.normal.Insert;
import com.github.zuihou.base.dao.normal.Remove;
import com.github.zuihou.base.dao.normal.Select;
import com.github.zuihou.base.dao.normal.Update;
import com.github.zuihou.base.entity.BaseEntity;
import com.github.zuihou.example.BaseExample;


/**
 *
 * 字段不含 appid 的类 继承这个dao
 * @auth tangyh
 * @date 2018/09/04
 */
public interface BaseNormalDao<I extends Serializable, T extends BaseEntity<I>, TE extends BaseExample>
        extends Insert<I, T, TE>, Update<I, T, TE>, Delete<I, T, TE>, Remove<I, T, TE>, Select<I, T, TE> {


}
