package me.zhangchunsheng.ucar.common.service.impl;

import me.zhangchunsheng.ucar.common.bean.UcarApiData;
import me.zhangchunsheng.ucar.common.config.UcarConfig;
import me.zhangchunsheng.ucar.common.service.UcarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/**
 * <pre>
 *  神州专车接口请求抽象实现类
 *  Created by Chunsheng Zhang on 2020/7/17.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public abstract class BaseServiceImpl implements UcarService {
    /**
     * The Log.
     */
    final Logger log = LoggerFactory.getLogger(this.getClass());
    /**
     * The constant ucarApiData.
     */
    static ThreadLocal<UcarApiData> ucarApiData = new ThreadLocal<>();

    /**
     * The Config.
     */
    protected UcarConfig config;

    @Override
    public UcarConfig getConfig() {
        return this.config;
    }

    @Override
    public void setConfig(UcarConfig config) {
        this.config = config;
    }

    @Override
    public String getBaseUrl() {
        return this.getConfig().getBaseUrl();
    }

    /**
     * 只要确保你的编码输入是正确的,就可以忽略掉 UnsupportedEncodingException
     *
     * @param source 参数
     * @return String
     */
    public static String getUrlParams(Map<String, Object> source) {
        Iterator<String> it = source.keySet().iterator();
        StringBuilder paramStr = new StringBuilder();
        while (it.hasNext()) {
            String key = it.next();
            String value = source.get(key).toString();
            if (value.isEmpty()) {
                continue;
            }
            try {
                // URL 编码
                value = URLEncoder.encode(value, "utf-8");
            } catch (UnsupportedEncodingException e) {
                // do nothing
            }
            paramStr.append("&").append(key).append("=").append(value);
        }
        // 去掉第一个&
        return paramStr.substring(1);
    }
}
