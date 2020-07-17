package me.zhangchunsheng.ucar.common.constant;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.Format;
import java.util.List;

/**
 * <pre>
 * 神州专车常量类
 * Created by Chunsheng Zhang on 2020/7/17.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class UcarConstants {
    /**
     * 结果代码.
     */
    public static class ResultStatus {
        /**
         * 成功.
         */
        public static final String SUCCESS = "1";

        /**
         * 失败.
         */
        public static final String FAIL = "0";
    }

    public static class Url {
        public static final String OAUTH_AUTHORIZE = "/oauth/authorize?client_id=%s&redirect_uri=%s&response_type=code&scope=read&state=%s&mobile=%s";
        public static final String OAUTH_ACCESS_TOKEN = "/oauth/token?client_id=%s&client_secret=%s&grant_type=authorization_code&code=%scode&redirect_uri=%s";
        public static final String OAUTH_REFRESH_TOKEN = "/oauth/token?client_id=%s&client_secret=%s&grant_type=refresh_token&refresh_token=%s";
        public static final String OAUTH_PASSWORD_TOKEN = "/oauth/token?client_id=%s&client_secret=%s&grant_type=password&username=%s&password=%s";
        public static final String OAUTH_TOKEN = "/oauth/token";
        public static final String OAUTH_CLIENT_TOKEN = "client_id=%s&client_secret=%s&grant_type=client_credentials";
    }
}
