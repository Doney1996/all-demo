package com.doney.controller;

import com.doney.entity.Organzation;
import com.doney.service.OrganzationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 单位机构表(Organzation)表控制层
 *
 * @author makejava
 * @since 2021-08-14 02:35:15
 */
@RestController
@RequestMapping("organzation")
public class OrganzationController {
    /**
     * 服务对象
     */
    @Resource
    private OrganzationService organzationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Organzation selectOne(Long id) {
        return this.organzationService.queryById(id);
    }

}