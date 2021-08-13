package com.doney.service;

import com.doney.entity.RelAccountOrganzation;
import java.util.List;

/**
 * (RelAccountOrganzation)表服务接口
 *
 * @author makejava
 * @since 2021-08-14 02:35:15
 */
public interface RelAccountOrganzationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RelAccountOrganzation queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RelAccountOrganzation> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param relAccountOrganzation 实例对象
     * @return 实例对象
     */
    RelAccountOrganzation insert(RelAccountOrganzation relAccountOrganzation);

    /**
     * 修改数据
     *
     * @param relAccountOrganzation 实例对象
     * @return 实例对象
     */
    RelAccountOrganzation update(RelAccountOrganzation relAccountOrganzation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}