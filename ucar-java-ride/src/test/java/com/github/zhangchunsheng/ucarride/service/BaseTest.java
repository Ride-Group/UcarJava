package com.github.zhangchunsheng.ucarride.service;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public final static String ACCESS_TOKEN = "c6a7c6d9-797c-494c-84b9-cff048b988ca";
    protected final static int CITY = 1;
    protected final static int SERVICE = 14;

    protected final static double SLAT = 39.955538;
    protected final static double SLNG = 116.458637;

    public static Map<String, Object> getEstimatePriceParams() {
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

        return params;
    }

    public static Map<String, Object> getEstimatePriceWithCouponParams() {
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
         * isUseCoupon	integer	是	是否使用代金券(1:使用 2:不使用）
         * passengerMobile	string	是	乘客手机号（是否使用代金券为“1”时必填）
         * isPickupVip	boolean	是	是否使用接机礼宾服务(服务类型为接机时有效)
         */
        Map<String, Object> params = getEstimatePriceParams();
        params.put("isUseCoupon", String.valueOf(1));
        params.put("passengerMobile", "18911116666");

        return params;
    }
}
