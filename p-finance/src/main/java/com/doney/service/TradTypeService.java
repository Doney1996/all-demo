package com.doney.service;

import com.doney.entity.TradType;
import java.util.List;

/**
 * 交易类型(TradType)表服务接口
 *
 * @author makejava
 * @since 2021-08-16 19:38:35
 */
public interface TradTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TradType queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TradType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tradType 实例对象
     * @return 实例对象
     */
    TradType insert(TradType tradType);

    /**
     * 修改数据
     *
     * @param tradType 实例对象
     * @return 实例对象
     */
    TradType update(TradType tradType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}