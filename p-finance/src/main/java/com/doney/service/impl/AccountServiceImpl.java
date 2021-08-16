package com.doney.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.doney.entity.Account;
import com.doney.dao.AccountDao;
import com.doney.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Account)表服务实现类
 *
 * @author makejava
 * @since 2021-08-14 02:35:13
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Account queryById(Long id) {
        return this.accountDao.selectById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Account> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    @Override
    public Account insert(Account account) {
        this.accountDao.insert(account);
        return account;
    }

    /**
     * 修改数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    @Override
    public Account update(Account account) {
        this.accountDao.update(account,null);
        return this.queryById(account.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.accountDao.deleteById(id) > 0;
    }

    @Override
    public List<Account> queryAll() {
        QueryWrapper<Account> wrapper = new QueryWrapper<Account>();
        wrapper.ne("account_type","6");
        return accountDao.selectList(wrapper);
    }
}