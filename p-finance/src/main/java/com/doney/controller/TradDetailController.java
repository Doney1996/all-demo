package com.doney.controller;

import com.doney.entity.TradDetail;
import com.doney.service.TradDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 交易详情(TradDetail)表控制层
 *
 * @author makejava
 * @since 2021-08-14 02:35:17
 */
@RestController
@RequestMapping("tradDetail")
public class TradDetailController {
    /**
     * 服务对象
     */
    @Resource
    private TradDetailService tradDetailService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TradDetail selectOne(Long id) {
        return this.tradDetailService.queryById(id);
    }

}