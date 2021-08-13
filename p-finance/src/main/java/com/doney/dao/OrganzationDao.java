package com.doney.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doney.entity.Organzation;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 单位机构表(Organzation)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-14 02:35:15
 */
public interface OrganzationDao extends BaseMapper<Organzation> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Organzation queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Organzation> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param organzation 实例对象
     * @return 对象列表
     */
    List<Organzation> queryAll(Organzation organzation);

    /**
     * 新增数据
     *
     * @param organzation 实例对象
     * @return 影响行数
     */
    int insert(Organzation organzation);

    /**
     * 修改数据
     *
     * @param organzation 实例对象
     * @return 影响行数
     */
    int update(Organzation organzation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}