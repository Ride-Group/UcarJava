package com.github.zhangchunsheng.spring.starter.ucarjava.oauth2.config;

import com.github.zhangchunsheng.ucaroauth2.service.Oauth2Service;
import com.github.zhangchunsheng.ucaroauth2.service.impl.Oauth2ServiceImpl;
import com.github.zhangchunsheng.spring.starter.ucarjava.oauth2.properties.UcarOauth2Properties;
import me.zhangchunsheng.ucar.common.config.UcarConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 *  神州专车自动配置
 *  Created by Chunsheng Zhang on 2020/7/17.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Configuration
@EnableConfigurationProperties(UcarOauth2Properties.class)
@ConditionalOnClass(Oauth2Service.class)
@ConditionalOnProperty(prefix = "ucar", value = "enabled", matchIfMissing = true)
public class UcarOauth2AutoConfiguration {
    private UcarOauth2Properties properties;

    @Autowired
    public UcarOauth2AutoConfiguration(UcarOauth2Properties properties) {
        this.properties = properties;
    }

    /**
     * 构造神州专车地理服务对象.
     *
     * @return 神州专车地理service
     */
    @Bean
    @ConditionalOnMissingBean(Oauth2Service.class)
    public Oauth2Service oauth2Service() {
        final Oauth2ServiceImpl oauth2Service = new Oauth2ServiceImpl();
        UcarConfig ucarConfig = new UcarConfig();
        ucarConfig.setClientId(StringUtils.trimToNull(this.properties.getClientId()));
        ucarConfig.setClientSecret(StringUtils.trimToNull(this.properties.getClientSecret()));

        oauth2Service.setConfig(ucarConfig);
        return oauth2Service;
    }
}
