package com.doney.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doney.entity.Trad;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 交易表(Trad)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-14 02:35:16
 */
public interface TradDao extends BaseMapper<Trad> {

}