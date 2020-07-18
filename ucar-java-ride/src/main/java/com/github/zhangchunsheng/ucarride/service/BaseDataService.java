package com.github.zhangchunsheng.ucarride.service;

import com.github.zhangchunsheng.ucarride.bean.result.common.GetCityServiceResult;
import me.zhangchunsheng.ucar.common.exception.UcarException;
import me.zhangchunsheng.ucar.common.service.UcarService;

/**
 * <pre>
 * 基础信息
 * Created by Chunsheng Zhang on 2020/7/18.
 *
 * https://developer.10101111.com/resourceCenter/doc?r=api/content#%E5%9F%BA%E7%A1%80%E4%BF%A1%E6%81%AF
 *
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public interface BaseDataService extends UcarService {

    public GetCityServiceResult getCityService(String accessToken, double slat, double slng) throws UcarException;

}
