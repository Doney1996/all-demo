package com.doney.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.doney.entity.TradDetail;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 交易详情(TradDetail)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-14 02:35:17
 */
public interface TradDetailDao extends BaseMapper<TradDetail> {
}