package com.doney.service.impl;

import com.doney.entity.TradType;
import com.doney.dao.TradTypeDao;
import com.doney.service.TradTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 交易类型(TradType)表服务实现类
 *
 * @author makejava
 * @since 2021-08-16 19:38:35
 */
@Service("tradTypeService")
public class TradTypeServiceImpl implements TradTypeService {
    @Resource
    private TradTypeDao tradTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TradType queryById(Long id) {
        return this.tradTypeDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TradType> queryAllByLimit(int offset, int limit) {
        return this.tradTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tradType 实例对象
     * @return 实例对象
     */
    @Override
    public TradType insert(TradType tradType) {
        this.tradTypeDao.insert(tradType);
        return tradType;
    }

    /**
     * 修改数据
     *
     * @param tradType 实例对象
     * @return 实例对象
     */
    @Override
    public TradType update(TradType tradType) {
        this.tradTypeDao.update(tradType);
        return this.queryById(tradType.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tradTypeDao.deleteById(id) > 0;
    }
}