package com.github.zhangchunsheng.ucarride.bean.result.common;

import com.github.zhangchunsheng.ucarride.util.json.UcarGsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zhangchunsheng.ucar.common.bean.result.BaseUcarResult;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 产品总类结果对象类
 * Created by Chunsheng Zhang on 2020/7/18.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GetNearbyCarInfoResult extends BaseUcarResult {
    private static final long serialVersionUID = 1707576958339934210L;

    @SerializedName("content")
    private Content content;

    public static class Content {
        private List<Position> carList;
        private int number;
        private int shortestTimeOfArrival;
    }

    /**
     * "desc": "奥迪A6 宝马5系或类似5座车型",
     *         "freeDistance": "0.0",
     *         "freeTime": "0.0",
     *         "id": 4,
     *         "kilometreUnitPrice": "4.6",
     *         "longDistanceUnitPrice": "0.0",
     *         "name": "豪华轿车",
     *         "outCityUnitPrice": "0.0",
     *         "startPrice": "23.0",
     *         "timeUnitPrice": "0.8",
     *         "image":"https://s.10101111cdn.com/ucarcdnstore/image/app/haohua.png",
     *         "sort": 5
     */
    public static class CarGroup {
        private String desc;
        private String freeDistance;
        private String freeTime;
        private int id;
        private String kilometreUnitPrice;
        private String longDistanceUnitPrice;
        private String name;
        private String outCityUnitPrice;
        private String startPrice;
        private String timeUnitPrice;
        private String image;
        private int sort;
    }

    public static GetNearbyCarInfoResult fromJson(String json) {
        return UcarGsonBuilder.create().fromJson(json, GetNearbyCarInfoResult.class);
    }

    @Override
    public String toString() {
        return UcarGsonBuilder.create().toJson(this);
    }

}
