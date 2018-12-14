package io.renren;


import com.alibaba.fastjson.JSON;
import io.renren.common.utils.PageUtils;
import io.renren.modules.invoice.service.FpKjLogService;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.service.DataSourceTestService;
import lombok.extern.java.Log;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class DynamicDataSourceTest {

    @Autowired
    private DataSourceTestService dataSourceTestService;
    @Autowired
    private FpKjLogService fpKjLogService;

    @Test
    public void test(){
        //数据源1
        SysUserEntity user1 = dataSourceTestService.queryUser(1L);
        System.out.println(ToStringBuilder.reflectionToString(user1));

        //数据源2
        SysUserEntity user2 = dataSourceTestService.queryUser2(1L);
        System.out.println(ToStringBuilder.reflectionToString(user2));

        //数据源1
        SysUserEntity user3 = dataSourceTestService.queryUser(1L);
        System.out.println(ToStringBuilder.reflectionToString(user3));
    }

    @Test
    public void test2(){


        Map<String, Object> params = new HashMap<>();
        params.put("page","1");
        params.put("limit","3");
        PageUtils pageUtils = fpKjLogService.selectWait(params);
        log.info("result: " + JSON.toJSON(pageUtils) );
    }

}
