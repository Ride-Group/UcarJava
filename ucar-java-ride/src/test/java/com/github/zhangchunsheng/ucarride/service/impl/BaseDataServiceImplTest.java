package com.github.zhangchunsheng.ucarride.service.impl;

import com.github.zhangchunsheng.ucarride.bean.result.common.GetCityServiceDetailResult;
import com.github.zhangchunsheng.ucarride.bean.result.common.GetCityServiceResult;
import com.github.zhangchunsheng.ucarride.service.BaseDataService;
import com.github.zhangchunsheng.ucarride.service.BaseTest;
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
public class BaseDataServiceImplTest extends BaseTest {

    @Inject
    private BaseDataService baseDataService;

    @Test
    public void testGetCityService() throws UcarException {
        //{"busiCode":"BASE000","code":15,"content":null,"handler":"CLIENT","msg":"TOKEN失效","status":"TOKEN_INVALID","uid":"","version":"001"}
        //b57e48cb-103a-49e2-a209-a385957e96c9
        //06342a58-1c90-4ac4-acc7-b62bb83188cd
        GetCityServiceResult result = this.baseDataService.getCityService(ACCESS_TOKEN, SLAT, SLNG);
        assertEquals("SUCCESS", result.getStatus());
    }

    @Test
    public void testGetCityServiceDetail() throws UcarException {
        //{"busiCode":"BASE000","code":15,"content":null,"handler":"CLIENT","msg":"TOKEN失效","status":"TOKEN_INVALID","uid":"","version":"001"}
        //{"busiCode":"BASE000","code":1,"content":{"carGroups":{"3":{"desc":"别克GL8或类似7座车型","freeDistance":"3.0","freeTime":"1.0","id":3,"image":"https://s.10101111cdn.com/ucarcdnstore/image/app/shangwu.png","kilometreUnitPrice":"4.5","longDistanceUnitPrice":"1.5","name":"商务7座","outCityUnitPrice":"3.3","sort":3,"startPrice":"51.0","timeUnitPrice":"3.1"},"2":{"desc":"大众帕萨特 丰田凯美瑞或类似5座车型","freeDistance":"2.0","freeTime":"1.0","id":2,"image":"https://s.10101111cdn.com/ucarcdnstore/image/app/gongwu.png","kilometreUnitPrice":"1.4","longDistanceUnitPrice":"0.3","name":"公务车型","outCityUnitPrice":"0.8","sort":1,"startPrice":"100.0","timeUnitPrice":"2.9"},"4":{"desc":"奔驰S 或 奥迪A6 宝马5系或类似5座车型","freeDistance":"1.0","freeTime":"10.0","id":4,"image":"https://s.10101111cdn.com/ucarcdnstore/image/app/haohua.png","kilometreUnitPrice":"2.8","longDistanceUnitPrice":"1.51","name":"豪华车型","outCityUnitPrice":"1.33","sort":4,"startPrice":"250.0","timeUnitPrice":"4.0"}},"cityId":1,"cityName":"北京","priceDateType":0,"priceStrategyFlag":0,"serviceId":14,"serviceName":"立即叫车"},"handler":"CLIENT","msg":"成功","status":"SUCCESS","uid":"3220985e-7c75-4f34-824e-8ca423d170b9","version":"001"}
        GetCityServiceDetailResult result = this.baseDataService.getCityServiceDetail(ACCESS_TOKEN, SLAT, SLNG, SERVICE, CITY);
        assertEquals("SUCCESS", result.getStatus());
    }
}
