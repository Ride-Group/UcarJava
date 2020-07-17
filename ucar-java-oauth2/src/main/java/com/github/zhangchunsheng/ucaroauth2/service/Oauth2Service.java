package com.github.zhangchunsheng.ucaroauth2.service;

import com.github.zhangchunsheng.ucaroauth2.bean.result.TokenResult;
import me.zhangchunsheng.ucar.common.exception.UcarException;
import me.zhangchunsheng.ucar.common.service.UcarService;

/**
 * <pre>
 * oauth2 API
 * Created by Chunsheng Zhang on 2020/7/17.
 *
 * https://developer.10101111.com/
 *
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public interface Oauth2Service extends UcarService {

    public TokenResult clientToken() throws UcarException;

}
