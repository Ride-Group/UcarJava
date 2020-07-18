package com.github.zhangchunsheng.ucarride.service.impl;

import com.github.zhangchunsheng.ucarride.bean.result.common.GetCityServiceResult;
import com.github.zhangchunsheng.ucarride.service.BaseDataService;
import me.zhangchunsheng.ucar.common.constant.UcarConstants;
import me.zhangchunsheng.ucar.common.exception.UcarException;
import me.zhangchunsheng.ucar.common.service.impl.UcarServiceApacheHttpImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 *  神州专车接口请求抽象实现类
 *  Created by Chunsheng Zhang on 2020/7/18.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class BaseDataServiceImpl extends UcarServiceApacheHttpImpl implements BaseDataService {

    @Override
    public GetCityServiceResult getCityService(String accessToken, double slat, double slng) throws UcarException {
        String responseContent = this.get(String.format(this.getConfig().getRideBaseUrl() + UcarConstants.Url.RESOURCE_COMMON_GETCITYSERVICE, accessToken, slat, slng));
        return GetCityServiceResult.fromJson(responseContent);
    }
}
