package io.renren.modules.invoice.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.invoice.entity.FpRetryEntity;

import java.util.Map;

/**
 * 发票开具状态与发票ID的映射关系表，可用于反补
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-11 18:15:53
 */
public interface FpRetryService extends IService<FpRetryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

