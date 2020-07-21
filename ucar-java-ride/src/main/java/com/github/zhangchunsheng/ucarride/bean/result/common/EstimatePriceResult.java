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
public class EstimatePriceResult extends BaseUcarResult {
    private static final long serialVersionUID = -1707576958339934210L;

    @SerializedName("content")
    private Content content;

    /**
     * {"busiCode":"BASE000","code":1,"content":{"distance":130430,"duration":109,"estimateId":"2b3e760728f54e75b0444234fc500be8","priceStrategyFlag":0,"prices":[{"carGroupId":2,"companyDiscountAmount":0,"floatFactor":1.0,"initFloatFactor":1.0,"initPrice":715.52,"kilometrePrice":179.8,"longDistancePrice":34.63,"longDistancePriceLimit":15.0,"name":"公务车型","outCityPrice":87.89,"perKilometrePrice":1.4,"perLongDistancePrice":0.3,"perTimePrice":2.9,"pickupServiceFee":0,"pickupServicePrice":0,"possibleGenerateOutCityPrice":87.89,"price":715.52,"priceType":2,"productKilometre":2.0,"productTime":1.0,"startPrice":100.0,"timePrice":313.2},{"carGroupId":3,"companyDiscountAmount":0,"floatFactor":1.0,"initFloatFactor":1.0,"initPrice":1509.93,"kilometrePrice":573.44,"longDistancePrice":188.15,"longDistancePriceLimit":5.0,"name":"商务7座","outCityPrice":362.54,"perKilometrePrice":4.5,"perLongDistancePrice":1.5,"perTimePrice":3.1,"pickupServiceFee":0,"pickupServicePrice":0,"possibleGenerateOutCityPrice":362.54,"price":1509.93,"priceType":2,"productKilometre":3.0,"productTime":1.0,"startPrice":51.0,"timePrice":334.8},{"carGroupId":4,"companyDiscountAmount":0,"floatFactor":1.0,"initFloatFactor":1.0,"initPrice":1334.35,"kilometrePrice":362.4,"longDistancePrice":179.84,"longDistancePriceLimit":11.33,"name":"豪华车型","outCityPrice":146.11,"perKilometrePrice":2.8,"perLongDistancePrice":1.51,"perTimePrice":4.0,"pickupServiceFee":0,"pickupServicePrice":0,"possibleGenerateOutCityPrice":146.11,"price":1334.35,"priceType":2,"productKilometre":1.0,"productTime":10.0,"startPrice":250.0,"timePrice":396.0}],"thirdWithholdRate":1.5},"handler":"CLIENT","msg":"成功","status":"SUCCESS","uid":"3220985e-7c75-4f34-824e-8ca423d170b9","version":"001"}
     */
    public static class Content {
        private List<Price> prices;
        private double distance;
        private double duration;
        private double thirdWithholdRate;
        private String estimateId;
        private int priceStrategyFlag;
    }

    /**
     * {
     *         "carGroupId": 1,
     *         "companyDiscountAmount": 0,
     *         "floatFactor": 1,
     *         "kilometrePrice": 375.9,
     *         "longDistancePrice": 0,
     *         "longDistancePriceLimit": 0,
     *         "name": "优驾舒享",
     *         "outCityPrice": 0,
     *         "perKilometrePrice": 2.2,
     *         "perLongDistancePrice": 0,
     *         "perTimePrice": 0.8,
     *         "price": 470.9,
     *         "priceType": 1,
     *         "productKilometre": 0,
     *         "productTime": 0,
     *         "startPrice": 25,
     *         "timePrice": 70,
     *         "pickupServicePrice":0,
     *         "possibleGenerateOutCityPrice":0
     *       }
     *
     * {
     *         "carGroupId": 1,
     *         "companyDiscountAmount": 0,
     *         "couponAmount": 0,
     *         "couponId": "",
     *         "couponKind": 0,
     *         "couponTitle": "",
     *         "floatFactor": 1,
     *         "kilometrePrice": 375.9,
     *         "longDistancePrice": 0,
     *         "longDistancePriceLimit": 0,
     *         "name": "优驾舒享",
     *         "outCityPrice": 0,
     *         "perKilometrePrice": 2.2,
     *         "perLongDistancePrice": 0,
     *         "perTimePrice": 0.8,
     *         "price": 470.9,
     *         "priceType": 1,
     *         "productKilometre": 0,
     *         "productTime": 0,
     *         "startPrice": 25,
     *         "timePrice": 70,
     *         "pickupServicePrice":0,
     *         "possibleGenerateOutCityPrice":0
     *       }
     *
     */
    public static class Price {
        private int carGroupId;
        private double companyDiscountAmount;
        private double couponAmount;
        private String couponId;
        private int couponKind;
        private String couponTitle;
        private double floatFactor;
        private double kilometrePrice;
        private double longDistancePrice;
        private double longDistancePriceLimit;
        private String name;
        private double outCityPrice;
        private double perKilometrePrice;
        private double perLongDistancePrice;
        private double perTimePrice;
        private double price;
        private int priceType;
        private double productKilometre;
        private double productTime;
        private double startPrice;
        private double timePrice;
        private double pickupServicePrice;
        private double possibleGenerateOutCityPrice;
    }

    public static EstimatePriceResult fromJson(String json) {
        return UcarGsonBuilder.create().fromJson(json, EstimatePriceResult.class);
    }

    @Override
    public String toString() {
        return UcarGsonBuilder.create().toJson(this);
    }

}
