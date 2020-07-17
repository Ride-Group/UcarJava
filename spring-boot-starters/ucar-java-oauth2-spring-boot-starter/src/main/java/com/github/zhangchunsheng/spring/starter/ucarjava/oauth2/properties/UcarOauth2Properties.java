package com.github.zhangchunsheng.spring.starter.ucarjava.oauth2.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <pre>
 *  神州专车属性配置类
 *  Created by Chunsheng Zhang on 2020/7/17.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Data
@ConfigurationProperties(prefix = "ucar")
public class UcarOauth2Properties {
  /**
   * 神州专车clientId.
   */
  private String clientId;

  private String clientSecret;
}
