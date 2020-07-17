package me.zhangchunsheng.ucar.common.config;

import lombok.Data;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.URL;
import java.security.KeyStore;

/**
 * 神州专车配置
 *
 * @author Chunsheng Zhang (https://github.com/zhangchunsheng)
 */
@Data
public class UcarConfig {
    private static final boolean USE_SANDBOX = true;

    private static final String SANDBOX_OAUTH2_BASE_URL = "https://sandboxoauth.10101111.com";
    private static final String SANDBOX_BASE_URL = "https://sandboxapi.10101111.com";
    private static final String DEFAULT_OAUTH2_BASE_URL = "https://oauth.10101111.com";
    private static final String DEFAULT_BASE_URL = "https://openapi.10101111.com";

    /**
     * 神州专车接口请求地址域名部分.
     */
    private String baseUrl = DEFAULT_BASE_URL;

    /**
     * 神州专车接口请求地址域名部分.
     */
    private String oauth2BaseUrl = DEFAULT_OAUTH2_BASE_URL;

    /**
     * http请求连接超时时间.
     */
    private int httpConnectionTimeout = 5000;

    /**
     * http请求数据读取等待时间.
     */
    private int httpTimeout = 10000;

    /**
     * 神州专车clientId.
     */
    private String clientId;

    /**
     * 神州专车clientSecret.
     */
    private String clientSecret;

    /**
     * 是否将接口请求日志信息保存到threadLocal中.
     * 默认不保存
     */
    private boolean ifSaveApiData = false;

    private String httpProxyHost;
    private Integer httpProxyPort;
    private String httpProxyUsername;
    private String httpProxyPassword;

    /**
     * 返回所设置的神州专车接口请求地址域名.
     *
     * @return 神州专车接口请求地址域名
     */
    public String getBaseUrl() {
        if(USE_SANDBOX) {
            return SANDBOX_BASE_URL;
        }
        if (StringUtils.isEmpty(this.baseUrl)) {
            return DEFAULT_BASE_URL;
        }

        return this.baseUrl;
    }

    /**
     * 返回所设置的神州专车接口请求地址域名.
     *
     * @return 神州专车接口请求地址域名
     */
    public String getOauth2BaseUrl() {
        if(USE_SANDBOX) {
            return SANDBOX_OAUTH2_BASE_URL;
        }
        if (StringUtils.isEmpty(this.baseUrl)) {
            return DEFAULT_OAUTH2_BASE_URL;
        }

        return this.baseUrl;
    }
}
