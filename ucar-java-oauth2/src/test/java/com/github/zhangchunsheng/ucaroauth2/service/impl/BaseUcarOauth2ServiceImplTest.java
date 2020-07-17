package com.github.zhangchunsheng.ucaroauth2.service.impl;

import com.github.zhangchunsheng.ucaroauth2.bean.result.TokenResult;
import com.github.zhangchunsheng.ucaroauth2.service.Oauth2Service;
import com.github.zhangchunsheng.ucaroauth2.testbase.ApiTestModule;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import me.zhangchunsheng.ucar.common.exception.UcarException;
import org.testng.Assert;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 测试token相关接口
 * Created by Chunsheng Zhang on 2020/7/17.
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Slf4j
@Test
@Guice(modules = ApiTestModule.class)
public class BaseUcarOauth2ServiceImplTest {

    @Inject
    private Oauth2Service oauth2Service;

    @Test
    public void testGetAccessToken() throws UcarException {
        /**
         * client_id=null&client_secret=null&grant_type=client_credentials
         * {"error":"unauthorized","error_description":"An Authentication object was not found in the SecurityContext"}
         * {"error":"invalid_request","error_description":"Missing grant type"}
         *
         * {
         *     "access_token": "b57e48cb-103a-49e2-a209-a385957e96c9",
         *     "token_type": "bearer",
         *     "expires_in": 43046,
         *     "scope": "read"
         * }
         *
         * {"access_token":"b57e48cb-103a-49e2-a209-a385957e96c9","token_type":"bearer","expires_in":39671,"scope":"read"}
         */
        TokenResult result = this.oauth2Service.clientToken();
        Assert.assertNotNull(result.getAccessToken());
    }
}
