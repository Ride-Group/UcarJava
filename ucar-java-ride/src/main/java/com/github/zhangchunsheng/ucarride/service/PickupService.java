package com.github.zhangchunsheng.ucarride.service;

import com.github.zhangchunsheng.ucarride.bean.result.common.GetCityServiceResult;
import me.zhangchunsheng.ucar.common.exception.UcarException;
import me.zhangchunsheng.ucar.common.service.UcarService;

/**
 * <pre>
 * 接机礼宾
 * Created by Chunsheng Zhang on 2020/7/18.
 *
 * https://developer.10101111.com/resourceCenter/doc?r=api/content#%E6%8E%A5%E6%9C%BA%E7%A4%BC%E5%AE%BE
 *
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public interface PickupService extends UcarService {

    public GetCityServiceResult isOpen(String accessToken, String airCode, long departureTime) throws UcarException;

}
