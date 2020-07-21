package me.zhangchunsheng.ucar.common.constant;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.Format;
import java.util.List;

/**
 * <pre>
 * 神州专车常量类
 * Created by Chunsheng Zhang on 2020/7/17.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class UcarConstants {
    /**
     * 产品信息.
     */
    public static class Service {
        /**
         * 立即叫车.
         */
        public static final int ASAP = 14;

        /**
         * 预约用车.
         */
        public static final int TIME_RENT = 13;

        /**
         * 接机.
         */
        public static final int FROM_AIRPORT = 7;

        /**
         * 送机.
         */
        public static final int TO_AIRPORT = 8;

        /**
         * 包车（4小时）.
         */
        public static final int HOURLY_COMBO = 11;
    }

    /**
     * 车型.
     */
    public static class CarGroup {
        /**
         * 优驾舒享.
         */
        public static final int YOU_XIANG = 1;

        /**
         * 公务轿车.
         */
        public static final int GONG_WU = 2;

        /**
         * 商务7座.
         */
        public static final int SHANG_WU = 3;

        /**
         * 豪华轿车.
         */
        public static final int HAO_HUA = 4;
    }

    /**
     * 结果代码.
     */
    public static class ResultStatus {
        /**
         * 成功.
         */
        public static final String SUCCESS = "1";

        /**
         * 失败.
         */
        public static final String FAIL = "0";
    }

    public static class Url {
        public static final String OAUTH_AUTHORIZE = "/oauth/authorize?client_id=%s&redirect_uri=%s&response_type=code&scope=read&state=%s&mobile=%s";
        public static final String OAUTH_ACCESS_TOKEN = "/oauth/token?client_id=%s&client_secret=%s&grant_type=authorization_code&code=%scode&redirect_uri=%s";
        public static final String OAUTH_REFRESH_TOKEN = "/oauth/token?client_id=%s&client_secret=%s&grant_type=refresh_token&refresh_token=%s";
        public static final String OAUTH_PASSWORD_TOKEN = "/oauth/token?client_id=%s&client_secret=%s&grant_type=password&username=%s&password=%s";
        public static final String OAUTH_TOKEN = "/oauth/token";
        public static final String OAUTH_CLIENT_TOKEN = "client_id=%s&client_secret=%s&grant_type=client_credentials";

        public static final String RESOURCE_COMMON_GETCITYSERVICE = "/v1/resource/common/getCityService?access_token=%s&slat=%s&slng=%s";
        public static final String RESOURCE_COMMON_GETCITYSERVICE_DETAIL = "/v1/resource/common/getCityServiceDetail?access_token=%s&slat=%s&slng=%s&serviceId=%s&cityId=%s";
        public static final String RESOURCE_COMMON_GETNEARBYCARINFO = "/v1/resource/common/getNearbyCarInfo?access_token=%s&slat=%s&slng=%s";
        public static final String RESOURCE_COMMON_ESTIMATE_PRICE = "/v1/resource/common/estimate/price";
        public static final String RESOURCE_COMMON_ESTIMATE_PRICEWITHCOUPON = "/v1/resource/common/estimate/priceWithCoupon";
    }
}
