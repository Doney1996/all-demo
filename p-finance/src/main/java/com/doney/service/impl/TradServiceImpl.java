package com.doney.service.impl;

import com.doney.dao.TradDetailDao;
import com.doney.dto.TradRequest;
import com.doney.entity.Trad;
import com.doney.dao.TradDao;
import com.doney.entity.TradDetail;
import com.doney.service.TradService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 交易表(Trad)表服务实现类
 *
 * @author makejava
 * @since 2021-08-14 02:35:16
 */
@Service("tradService")
public class TradServiceImpl implements TradService {
    @Resource
    private TradDao tradDao;

    @Resource
    private TradDetailDao tradDetailDao;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Trad queryById(Long id) {
        return this.tradDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Trad> queryAllByLimit(int offset, int limit) {
        return this.tradDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param trad 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Trad insert(TradRequest trad) {
        //做该做的事情
        TradDetail detail = new TradDetail();
        tradDetailDao.insert(detail);
        tradDao.insert(trad);
        return trad;
    }

    /**
     * 修改数据
     *
     * @param trad 实例对象
     * @return 实例对象
     */
    @Override
    public Trad update(Trad trad) {
        this.tradDao.update(trad);
        return this.queryById(trad.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tradDao.deleteById(id) > 0;
    }
}