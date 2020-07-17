# UcarJava
基于神州专车开放平台的SDK

### 使用SDK
```java

```
### Maven 引用方式
```xml
<dependency>
    <groupId>com.github.zhangchunsheng</groupId>
    <artifactId>ucar-java</artifactId>
    <version>1.0.0</version>
</dependency>
```

### ucar接口说明

```
测试环境域名
名称	域名
授权认证	https://sandboxoauth.10101111.com
API	https://sandboxapi.10101111.com
正式环境域名
名称	域名
授权认证	https://oauth.10101111.com
API	https://openapi.10101111.com
```

### 订单推送接口说明
```
订单状态发生变化时，神州服务器会主动请求用户配置的订单状态变化回调url。目前回调状态有两个版本，于2017年9月15号及以后创建的应用都是V2版本回调，之前的应用都是V1版本的回调。如果想由V1切到V2版本回调，可以联系神州工作人员。 注意：回调状态与订单状态不完全一致。收到回调状态后，再通过订单详情接口获取订单详细信息，来完成您的业务操作

回调数据
https://你的订单变化回调url?q={"content":{"status":"compleled",
    "orderId":"6265131711686377123","eventExplanation":"","dOrderId":"123"},"operation":"statusChanged"}
回调数据说明
参数名称	类型	可选	说明
status	string	否	订单回调状态
orderId	string	否	订单ID
operation	string	否	固定值statusChanged
eventExplanation	string	是	对事件的解释说明，例如为何取消，无效，调账等
dOrderId	string	是	渠道订单id，当创建订单的请求参数customData中有传dOrderId时才返回
```