package io.renren.modules.invoice.service.impl;

import io.renren.datasources.DataSourceNames;
import io.renren.datasources.annotation.DataSource;
import io.renren.modules.invoice.dao.FpRetryDao;
import io.renren.modules.invoice.entity.FpRetryEntity;
import io.renren.modules.invoice.service.FpRetryService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;



@Service("fpRetryService")
public class FpRetryServiceImpl extends ServiceImpl<FpRetryDao, FpRetryEntity> implements FpRetryService {
    @Override
    @DataSource(name = DataSourceNames.SECOND)
    public boolean insert(FpRetryEntity fpRetryEntity){
        return super.insert(fpRetryEntity);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FpRetryEntity> page = this.selectPage(
                new Query<FpRetryEntity>(params).getPage(),
                new EntityWrapper<FpRetryEntity>()
        );

        return new PageUtils(page);
    }

}
