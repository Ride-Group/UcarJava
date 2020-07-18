package com.github.zhangchunsheng.ucarride.service.impl;

import com.github.zhangchunsheng.ucarride.bean.result.common.GetCityServiceResult;
import com.github.zhangchunsheng.ucarride.service.BaseDataService;
import com.github.zhangchunsheng.ucarride.testbase.ApiTestModule;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import me.zhangchunsheng.ucar.common.exception.UcarException;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

/**
 * 测试GEO相关接口
 * Created by Chunsheng Zhang on 2020/7/18.
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Slf4j
@Test
@Guice(modules = ApiTestModule.class)
public class BaseDataServiceImplTest {

    @Inject
    private BaseDataService baseDataService;

    @Test
    public void testGetCityService() throws UcarException {
        //{"busiCode":"BASE000","code":15,"content":null,"handler":"CLIENT","msg":"TOKEN失效","status":"TOKEN_INVALID","uid":"","version":"001"}
        //b57e48cb-103a-49e2-a209-a385957e96c9
        //06342a58-1c90-4ac4-acc7-b62bb83188cd
        GetCityServiceResult result = this.baseDataService.getCityService("06342a58-1c90-4ac4-acc7-b62bb83188cd", 39.955538, 116.458637);
        assertEquals("SUCCESS", result.getStatus());
    }
}
