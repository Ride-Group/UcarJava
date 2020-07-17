package com.github.zhangchunsheng.ucaroauth2.testbase;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import me.zhangchunsheng.ucar.common.config.UcarConfig;

/**
 * The type Xml ucar oauth2 config.
 */
@XStreamAlias("xml")
public class XmlUcarConfig extends UcarConfig {
    private String clientId;
    private String clientSecret;

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
