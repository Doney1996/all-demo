package com.doney.controller;

import com.doney.entity.TradType;
import com.doney.service.TradTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 交易类型(TradType)表控制层
 *
 * @author makejava
 * @since 2021-08-16 19:38:35
 */
@RestController
@RequestMapping("tradType")
public class TradTypeController {
    /**
     * 服务对象
     */
    @Resource
    private TradTypeService tradTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TradType selectOne(Long id) {
        return this.tradTypeService.queryById(id);
    }

}