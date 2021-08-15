package com.doney.service.impl;

import com.doney.entity.RelAccountOrganzation;
import com.doney.dao.RelAccountOrganzationDao;
import com.doney.service.RelAccountOrganzationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RelAccountOrganzation)表服务实现类
 *
 * @author makejava
 * @since 2021-08-14 02:35:15
 */
@Service("relAccountOrganzationService")
public class RelAccountOrganzationServiceImpl implements RelAccountOrganzationService {
    @Resource
    private RelAccountOrganzationDao relAccountOrganzationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RelAccountOrganzation queryById(Long id) {
        return this.relAccountOrganzationDao.selectById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RelAccountOrganzation> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 新增数据
     *
     * @param relAccountOrganzation 实例对象
     * @return 实例对象
     */
    @Override
    public RelAccountOrganzation insert(RelAccountOrganzation relAccountOrganzation) {
        this.relAccountOrganzationDao.insert(relAccountOrganzation);
        return relAccountOrganzation;
    }

    /**
     * 修改数据
     *
     * @param relAccountOrganzation 实例对象
     * @return 实例对象
     */
    @Override
    public RelAccountOrganzation update(RelAccountOrganzation relAccountOrganzation) {
        this.relAccountOrganzationDao.update(relAccountOrganzation,null);
        return this.queryById(relAccountOrganzation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.relAccountOrganzationDao.deleteById(id) > 0;
    }
}