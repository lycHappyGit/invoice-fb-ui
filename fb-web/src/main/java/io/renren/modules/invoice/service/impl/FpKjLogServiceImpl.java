package io.renren.modules.invoice.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.FpztUtil;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.StatusConstants;
import io.renren.datasources.DataSourceNames;
import io.renren.datasources.annotation.DataSource;
import io.renren.modules.invoice.dao.FpKjLogDao;
import io.renren.modules.invoice.dao.FpRetryDao;
import io.renren.modules.invoice.entity.FpKjLogEntity;
import io.renren.modules.invoice.entity.FpRetryEntity;
import io.renren.modules.invoice.service.FpKjLogService;
import io.renren.modules.invoice.service.FpRetryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("fpKjLogService")
@Slf4j
public class FpKjLogServiceImpl implements FpKjLogService {

    @Autowired
    private FpKjLogDao fpKjLogDao;
    @Autowired
    private FpRetryDao fpRetryDao;

    @Override
    @DataSource(name = DataSourceNames.SECOND)
    public PageUtils selectWait(Map<String, Object> params) {

        Query<FpKjLogEntity> query = new Query<>(params);
        Page<FpKjLogEntity> page = query.getPage();
        return new PageUtils(page.setRecords(fpKjLogDao.selectWait(page, query)));
    }

    @Override
    @DataSource(name = DataSourceNames.SECOND)
    public PageUtils selectRunning(Map<String, Object> params) {

        Query<FpKjLogEntity> query = new Query<>(params);
        Page<FpKjLogEntity> page = query.getPage();
        return new PageUtils(page.setRecords(fpKjLogDao.selectRunning(page, query)));
    }

    @Override
    @DataSource(name = DataSourceNames.SECOND)
    public void fpRetry(String[] fpids) {
        for(String fpid : fpids){
            FpKjLogEntity fpKjLogEntity = fpKjLogDao.selectByFpid(fpid);
            String fpkjZt = fpKjLogEntity.getFpkjZt();
            String fpRetryZt = null;
            if(FpztUtil.contancns(FpztUtil.tofm, fpkjZt)){
                //待附码
                fpRetryZt = StatusConstants.STATUS_DATABASE_FPQQFM_FAILED.getCODE();
            }else if(FpztUtil.contancns(FpztUtil.toqz, fpkjZt)){
                //待签章
                fpRetryZt = StatusConstants.STATUS_DATABASE_FPQQSC_FAILED.getCODE();
            }
            if(StringUtils.isBlank(fpRetryZt)){
                log.info("发票id:{},的发票状态为:{},不进行反补!", fpKjLogEntity.getFpid(), fpkjZt);
                return;
            }
            //重置反补次数
            fpKjLogEntity.setFbCs(0);
            fpKjLogDao.updateByLogId(fpKjLogEntity);
            //插入fp_retry表
            FpRetryEntity fpRetryEntity = new FpRetryEntity();
            fpRetryEntity.setFpkjZt(fpRetryZt);
            fpRetryEntity.setFpkjId(fpKjLogEntity.getFpid());
            fpRetryDao.insert(fpRetryEntity);
        }
    }
}
