package com.doney.controller;

import com.doney.entity.Account;
import com.doney.service.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Account)表控制层
 *
 * @author makejava
 * @since 2021-08-14 02:35:14
 */
@RestController
@RequestMapping("account")
public class AccountController {
    /**
     * 服务对象
     */
    @Resource
    private AccountService accountService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Account selectOne(Long id) {
        return this.accountService.queryById(id);
    }

    /**
     * 查询所有账号
     */
    @GetMapping("getAll")
    public List<Account> getAll() {
        return this.accountService.queryAll();
    }

}