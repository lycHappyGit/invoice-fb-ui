package io.renren.modules.invoice.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.invoice.entity.FpKjLogEntity;

import java.util.Map;

/**
 * 发票开具日志表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-04 18:33:27
 */
public interface FpKjLogService {

    PageUtils selectWait(Map<String, Object> params);

    PageUtils selectRunning(Map<String, Object> params);

    void fpRetry(String[] fpids);
}

