package com.doney.service.impl;

import com.doney.entity.TradDetail;
import com.doney.dao.TradDetailDao;
import com.doney.service.TradDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 交易详情(TradDetail)表服务实现类
 *
 * @author makejava
 * @since 2021-08-14 02:35:17
 */
@Service("tradDetailService")
public class TradDetailServiceImpl implements TradDetailService {
    @Resource
    private TradDetailDao tradDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TradDetail queryById(Long id) {
        return this.tradDetailDao.selectById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TradDetail> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param tradDetail 实例对象
     * @return 实例对象
     */
    @Override
    public TradDetail insert(TradDetail tradDetail) {
        this.tradDetailDao.insert(tradDetail);
        return tradDetail;
    }

    /**
     * 修改数据
     *
     * @param tradDetail 实例对象
     * @return 实例对象
     */
    @Override
    public TradDetail update(TradDetail tradDetail) {
        this.tradDetailDao.update(tradDetail,null);
        return this.queryById(tradDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tradDetailDao.deleteById(id) > 0;
    }
}