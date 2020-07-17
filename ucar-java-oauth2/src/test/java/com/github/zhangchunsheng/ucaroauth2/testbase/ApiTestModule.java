package com.github.zhangchunsheng.ucaroauth2.testbase;

import com.github.zhangchunsheng.ucaroauth2.service.Oauth2Service;
import com.github.zhangchunsheng.ucaroauth2.service.impl.Oauth2ServiceImpl;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.thoughtworks.xstream.XStream;
import me.zhangchunsheng.ucar.common.config.UcarConfig;
import me.zhangchunsheng.ucar.common.util.xml.XStreamInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * The type Api test module.
 */
public class ApiTestModule implements Module {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private static final String TEST_CONFIG_XML = "test-config.xml";

    @Override
    public void configure(Binder binder) {
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(TEST_CONFIG_XML)) {
            if (inputStream == null) {
                throw new RuntimeException("测试配置文件【" + TEST_CONFIG_XML + "】未找到，请参照test-config-sample.xml文件生成");
            }

            XmlUcarConfig config = this.fromXml(XmlUcarConfig.class, inputStream);
            Oauth2Service oauth2Service = new Oauth2ServiceImpl();
            oauth2Service.setConfig(config);

            binder.bind(Oauth2Service.class).toInstance(oauth2Service);
            binder.bind(UcarConfig.class).toInstance(config);
        } catch (IOException e) {
            this.log.error(e.getMessage(), e);
        }

    }

    @SuppressWarnings("unchecked")
    private <T> T fromXml(Class<T> clazz, InputStream is) {
        XStream xstream = XStreamInitializer.getInstance();
        xstream.alias("xml", clazz);
        xstream.processAnnotations(clazz);
        return (T) xstream.fromXML(is);
    }

}
