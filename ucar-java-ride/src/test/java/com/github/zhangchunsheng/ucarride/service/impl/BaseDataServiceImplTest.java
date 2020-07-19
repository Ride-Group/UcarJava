package com.github.zhangchunsheng.ucarride.service.impl;

import com.github.zhangchunsheng.ucarride.bean.result.common.EstimatePriceResult;
import com.github.zhangchunsheng.ucarride.bean.result.common.GetCityServiceDetailResult;
import com.github.zhangchunsheng.ucarride.bean.result.common.GetCityServiceResult;
import com.github.zhangchunsheng.ucarride.bean.result.common.GetNearbyCarInfoResult;
import com.github.zhangchunsheng.ucarride.service.BaseDataService;
import com.github.zhangchunsheng.ucarride.service.BaseTest;
import com.github.zhangchunsheng.ucarride.testbase.ApiTestModule;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import me.zhangchunsheng.ucar.common.exception.UcarException;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testGetNearbyCarInfo() throws UcarException {
        GetNearbyCarInfoResult result = this.baseDataService.getNearbyCarInfo(ACCESS_TOKEN, 39.159693, 117.393305);
        assertEquals("SUCCESS", result.getStatus());
    }

    @Test
    public void testEstimatePrice() throws UcarException {
        /**
         * access_token	string	否	授权后的access token
         * slat	double	是	出发地纬度（服务类型为“接机”时可为空）
         * slng	double	是	出发地经度（服务类型为“接机”时可为空）
         * elat	double	是	目的地纬度（服务类型为“包车（8小时）”或"包车（4小时）"时为空）
         * elng	double	是	目的地经度（服务类型为“包车（8小时）”或"包车（4小时）"时为空）
         * serviceId	integer	否	服务类型id(7:接机 8:送机 11:包车（4小时） 12:包车（8小时） 13:预约用车 14:立即叫车)
         * cityId	integer	是	出发城市id（如果为空，则根据出发地经纬度定位城市）
         * departureTime	long	是
         * 出发时间（unix时间戳，服务类型为"立即叫车"或“接机”时可为空）
         *
         * 时间范围：立即叫车为当前日期，预约用车/包车（8小时）/包车（4小时）为当前日期 至 当前日期+30天
         *
         * 例如：当前日期为2016-3-4 10:00，则日期范围：2016-3-4 10:00（含） 至 2016-4-3 23:59（含）
         *
         * flt	string	是	航班号
         * flightDate	long	是
         * 航班起飞日期(unix时间戳)
         *
         * 日期范围：当前日期-3天 至 当前日期+30天
         *
         * 例如：当前日期为2016-3-4，则日期范围：2016-3-1（含） 至 2016-4-3（含）
         *
         * flightDelayTime	integer	是
         * 航班到达后，延时N分钟后用车
         *
         * 时间范围：10（含） 至 90（含）
         *
         * airCode	string	是	接机机场三字码
         * isPickupVip	boolean	是	是否使用接机礼宾服务(服务类型为接机时有效)
         */
        long time = System.currentTimeMillis();
        time = time / 1000;
        Map<String, Object> params = new HashMap<>();
        params.put("access_token", ACCESS_TOKEN);
        params.put("slat", String.valueOf(SLAT));
        params.put("slng", String.valueOf(SLNG));
        params.put("elat", "39.159693");
        params.put("elng", "117.393305");
        params.put("serviceId", String.valueOf(SERVICE));
        params.put("cityId", String.valueOf(CITY));
        /*params.put("departureTime", time);
        params.put("flt", "");
        params.put("flightDate", time);
        params.put("flightDelayTime", 10);
        params.put("airCode", "");
        params.put("isPickupVip", 1);*/
        EstimatePriceResult result = this.baseDataService.estimatePrice(params);
        assertEquals("SUCCESS", result.getStatus());
    }
}
