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

}