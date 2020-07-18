package com.github.zhangchunsheng.ucarride.testbase;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import me.zhangchunsheng.ucar.common.config.UcarConfig;

/**
 * The type Xml ucar config.
 */
@XStreamAlias("xml")
public class XmlUcarConfig extends UcarConfig {
    private boolean useSandbox;
    private String clientId;
    private String clientSecret;

    @Override
    public boolean isUseSandbox() {
        return useSandbox;
    }

    @Override
    public void setUseSandbox(boolean useSandbox) {
        this.useSandbox = useSandbox;
    }

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
