package com.jayne.dao;

import com.jayne.util.PageInfo;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Dao实现的基类，定义了Dao层的基本方法，所有Dao层类都应该继承自该类
 */
public abstract class BaseDao {

    /** 我们使用了一个轻量级的Dao层框架Nutz，这个就是NutzDao的实例 */
    @Autowired
    protected Dao dao;

    protected Pager createPager(PageInfo pageInfo) {
        return dao.createPager(pageInfo.getPage(), pageInfo.getCount());
    }
}
