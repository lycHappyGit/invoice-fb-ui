package io.renren.modules.invoice.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import io.renren.common.utils.Query;
import io.renren.datasources.DataSourceNames;
import io.renren.datasources.annotation.DataSource;
import io.renren.modules.invoice.entity.FpKjLogEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 发票开具日志表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-04 18:33:27
 */
public interface FpKjLogDao extends BaseMapper<FpKjLogEntity> {

    List<FpKjLogEntity> selectWait(Pagination page, Query<FpKjLogEntity> query);

    List<FpKjLogEntity> selectRunning(Pagination page, Query<FpKjLogEntity> query);

    FpKjLogEntity selectByFpid(String fpid);

    void updateByLogId(FpKjLogEntity fpKjLogEntity);
}
