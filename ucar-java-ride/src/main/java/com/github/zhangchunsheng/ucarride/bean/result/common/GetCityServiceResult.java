package com.github.zhangchunsheng.ucarride.bean.result.common;

import com.github.zhangchunsheng.ucarride.util.json.UcarGsonBuilder;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zhangchunsheng.ucar.common.bean.result.BaseUcarResult;

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
public class GetCityServiceResult extends BaseUcarResult {
    private static final long serialVersionUID = -5707576958339934210L;

    @SerializedName("content")
    private Content content;

    public static class Content {
        private int cityId;
        private String cityName;
        private Map<Integer, Service> services;
        private int priceStrategyFlag;
    }

    public static class Service {
        private int id;
        private String name;
        private int basePriceSchemeId;
    }

    public static GetCityServiceResult fromJson(String json) {
        return UcarGsonBuilder.create().fromJson(json, GetCityServiceResult.class);
    }

    @Override
    public String toString() {
        return UcarGsonBuilder.create().toJson(this);
    }

}
