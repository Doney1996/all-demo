package com.doney.service;

import com.doney.entity.Organzation;
import java.util.List;

/**
 * 单位机构表(Organzation)表服务接口
 *
 * @author makejava
 * @since 2021-08-14 02:35:15
 */
public interface OrganzationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Organzation queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Organzation> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param organzation 实例对象
     * @return 实例对象
     */
    Organzation insert(Organzation organzation);

    /**
     * 修改数据
     *
     * @param organzation 实例对象
     * @return 实例对象
     */
    Organzation update(Organzation organzation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}