package me.zhangchunsheng.ucar.common.config;

import org.testng.annotations.Test;

/**
 * <pre>
 *  Created by Chunsheng Zhang on 2020/7/17.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
public class UcarConfigTest {
    private UcarConfig ucarConfig = new UcarConfig();

    @Test
    public void test1() throws Exception {
        ucarConfig.setClientId("1");
        ucarConfig.setClientSecret("1");
    }
}
