package com.doney.controller;

import com.doney.dto.TradRequest;
import com.doney.entity.Trad;
import com.doney.service.TradService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 交易表(Trad)表控制层
 *
 * @author makejava
 * @since 2021-08-14 02:35:16
 */
@RestController
@RequestMapping("trad")
public class TradController {
    /**
     * 服务对象
     */
    @Resource
    private TradService tradService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Trad selectOne(Long id) {
        return this.tradService.queryById(id);
    }

    @PostMapping("add")
    public Trad add(@RequestBody TradRequest trad){
        return this.tradService.insert(trad);
    }

}