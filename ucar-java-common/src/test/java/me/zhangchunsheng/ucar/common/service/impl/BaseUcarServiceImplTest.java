package me.zhangchunsheng.ucar.common.service.impl;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import me.zhangchunsheng.ucar.common.exception.UcarException;
import me.zhangchunsheng.ucar.common.service.UcarService;
import me.zhangchunsheng.ucar.common.testbase.ApiTestModule;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

/**
 * 测试GEO相关接口
 * Created by Chunsheng Zhang on 2020/7/17.
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Slf4j
@Test
@Guice(modules = ApiTestModule.class)
public class BaseUcarServiceImplTest {

    @Inject
    private UcarService ucarService;

    @Test
    public void testOauth2() throws UcarException {
        String clientId = this.ucarService.getConfig().getClientId();
        assertNotNull(clientId);
    }
}
