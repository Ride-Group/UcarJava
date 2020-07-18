package me.zhangchunsheng.ucar.common.service;

import me.zhangchunsheng.ucar.common.config.UcarConfig;
import me.zhangchunsheng.ucar.common.exception.UcarException;

import java.util.Map;

/**
 * <pre>
 * 神州专车
 * Created by Chunsheng Zhang on 2020/7/17.
 *
 * https://developer.10101111.com/
 *
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public interface UcarService {

    /**
     * 获取神州专车请求url前缀
     *
     * @return the ucar base url
     */
    String getBaseUrl();

    /**
     * 获取神州专车请求url前缀
     *
     * @return the ride base url
     */
    String getRideBaseUrl();

    public UcarConfig getConfig();

    public void setConfig(UcarConfig config);

    public byte[] postForBytes(String url, String requestStr) throws UcarException;

    public String post(String url, String requestStr) throws UcarException;

    public String post(String url, Map<String, Object> params) throws UcarException;

    public String get(String url) throws UcarException;

}
