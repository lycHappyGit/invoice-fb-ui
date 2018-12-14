package io.renren.modules.invoice.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.modules.invoice.entity.FpRetryEntity;

/**
 * 发票开具状态与发票ID的映射关系表，可用于反补
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-11 18:15:53
 */
public interface FpRetryDao extends BaseMapper<FpRetryEntity> {

    void insert1(FpRetryEntity fpRetryEntity);
}
