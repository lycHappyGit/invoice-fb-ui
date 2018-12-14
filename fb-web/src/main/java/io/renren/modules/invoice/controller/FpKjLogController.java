package io.renren.modules.invoice.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.invoice.service.FpKjLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 发票开具日志表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-04 18:33:27
 */
@RestController
@RequestMapping("invoice/fpkjlog")
public class FpKjLogController {
    @Autowired
    private FpKjLogService fpKjLogService;

    /**
     * 查询待反补列表
     */
    @RequestMapping("/selectWait")
    public R selectWait(@RequestParam Map<String, Object> params){
        PageUtils page = fpKjLogService.selectWait(params);
        return R.ok().put("page", page);
    }

    /**
     * 查询正在反补列表
     */
    @RequestMapping("/selectRunning")
    public R selectRunning(@RequestParam Map<String, Object> params){
        PageUtils page = fpKjLogService.selectRunning(params);
        return R.ok().put("page", page);
    }

    /**
     * 重新反补
     */
    @RequestMapping("/fpRetry")
    public R fpRetry(@RequestBody String[] fpids){
        fpKjLogService.fpRetry(fpids);
        return R.ok();
    }

}
