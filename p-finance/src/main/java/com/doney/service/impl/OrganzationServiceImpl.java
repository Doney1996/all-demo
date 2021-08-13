package com.doney.service.impl;

import com.doney.entity.Organzation;
import com.doney.dao.OrganzationDao;
import com.doney.service.OrganzationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 单位机构表(Organzation)表服务实现类
 *
 * @author makejava
 * @since 2021-08-14 02:35:15
 */
@Service("organzationService")
public class OrganzationServiceImpl implements OrganzationService {
    @Resource
    private OrganzationDao organzationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Organzation queryById(Long id) {
        return this.organzationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Organzation> queryAllByLimit(int offset, int limit) {
        return this.organzationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param organzation 实例对象
     * @return 实例对象
     */
    @Override
    public Organzation insert(Organzation organzation) {
        this.organzationDao.insert(organzation);
        return organzation;
    }

    /**
     * 修改数据
     *
     * @param organzation 实例对象
     * @return 实例对象
     */
    @Override
    public Organzation update(Organzation organzation) {
        this.organzationDao.update(organzation);
        return this.queryById(organzation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.organzationDao.deleteById(id) > 0;
    }
}