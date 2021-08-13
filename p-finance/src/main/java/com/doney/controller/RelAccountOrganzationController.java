package com.doney.controller;

import com.doney.entity.RelAccountOrganzation;
import com.doney.service.RelAccountOrganzationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RelAccountOrganzation)表控制层
 *
 * @author makejava
 * @since 2021-08-14 02:35:15
 */
@RestController
@RequestMapping("relAccountOrganzation")
public class RelAccountOrganzationController {
    /**
     * 服务对象
     */
    @Resource
    private RelAccountOrganzationService relAccountOrganzationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RelAccountOrganzation selectOne(Long id) {
        return this.relAccountOrganzationService.queryById(id);
    }

}