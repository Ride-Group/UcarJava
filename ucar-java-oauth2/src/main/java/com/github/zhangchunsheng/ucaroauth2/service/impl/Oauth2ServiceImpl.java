package com.github.zhangchunsheng.ucaroauth2.service.impl;

import com.github.zhangchunsheng.ucaroauth2.bean.result.TokenResult;
import com.github.zhangchunsheng.ucaroauth2.service.Oauth2Service;
import me.zhangchunsheng.ucar.common.constant.UcarConstants;
import me.zhangchunsheng.ucar.common.exception.UcarException;
import me.zhangchunsheng.ucar.common.service.impl.UcarServiceApacheHttpImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 神州专车接口请求实现类，默认使用Apache HttpClient实现
 * Created by Chunsheng Zhang on 2020/7/17.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class Oauth2ServiceImpl extends UcarServiceApacheHttpImpl implements Oauth2Service {
    @Override
    public TokenResult clientToken() throws UcarException {
        Map<String, Object> params = new HashMap<>();
        params.put("client_id", this.getConfig().getClientId());
        params.put("client_secret", this.getConfig().getClientSecret());
        params.put("grant_type", "client_credentials");
        String responseContent = this.post(this.getConfig().getOauth2BaseUrl() + UcarConstants.Url.OAUTH_TOKEN, params);
        return TokenResult.fromJson(responseContent);
    }
}
