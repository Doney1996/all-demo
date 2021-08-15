package com.doney.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.doney.dao.AccountDao;
import com.doney.dao.TradDao;
import com.doney.dao.TradDetailDao;
import com.doney.dto.TradRequest;
import com.doney.entity.Account;
import com.doney.entity.Trad;
import com.doney.entity.TradDetail;
import com.doney.service.TradService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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
    private AccountDao accountDao;

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
        return this.tradDao.selectById(id);
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
        return null;
    }

    /**
     * 新增数据
     *
     * @param tradRequest 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Trad insert(TradRequest tradRequest) {
        Trad trad = new Trad();
        tradRequestToTrad(trad,tradRequest);

        tradDao.insert(trad);
        Long tradId = trad.getId();

        List<TradDetail> detailList = tradRequest.getDetailList();
        detailList.forEach(tradDetail -> {
            //锁账号
            Account fromAccount = accountDao.lockQueryById(tradDetail.getFromAccount());
            Account toAccount = accountDao.lockQueryById(tradDetail.getToAccount());
            fromAccount.setBalance(fromAccount.getBalance() - tradDetail.getAmount());
            toAccount.setBalance(toAccount.getBalance() + tradDetail.getAmount());
            // 更新余额
            UpdateWrapper<Account> wrapper = new UpdateWrapper<Account>();
            wrapper.eq("id",fromAccount.getId());
            accountDao.update(fromAccount,wrapper);
            UpdateWrapper<Account> wrapper2 = new UpdateWrapper<Account>();
            wrapper2.eq("id",toAccount.getId());
            accountDao.update(toAccount,wrapper2);
            // 插入交易明细记录
            tradDetail.setTradId(tradId);
            tradDetailDao.insert(tradDetail);
        });
        return trad;
    }

    /**
     * 类型转换 并做插入前的数据准备
     */
    private void tradRequestToTrad(Trad trad, TradRequest tradRequest) {
        Long tradType = tradRequest.getTradType();
        Date tradDate = tradRequest.getTradDate();
        Long tradClassification = tradRequest.getTradClassification();
        String remark = tradRequest.getRemark();
        String tag = tradRequest.getTag();

        trad.setTradType(tradType);
        trad.setTrandDate(tradDate);
        trad.setTradClassification(tradClassification);
        trad.setRemark(remark);
        trad.setTag(tag);

        trad.setDelFlag(false);
        Date date = new Date();
        trad.setCreateTime(date);
        trad.setUpdateTime(date);
        trad.setStatus(1L);
    }

    /**
     * 修改数据
     *
     * @param trad 实例对象
     * @return 实例对象
     */
    @Override
    public Trad update(Trad trad) {
        this.tradDao.insert(trad);
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