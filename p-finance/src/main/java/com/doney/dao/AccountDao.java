package com.doney.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doney.entity.Account;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Account)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-14 02:35:11
 */
public interface AccountDao extends BaseMapper<Account> {

    /**
     * 带锁查询
     * @param id 主键
     * @return 实例对象
     */
    Account lockQueryById(Long id);
}