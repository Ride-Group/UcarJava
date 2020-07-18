# UcarJava
基于神州专车开放平台的SDK

### 使用SDK
```java
// spring boot, inject oauth2Service
TokenResult result = this.oauth2Service.clientToken();
```
### Maven 引用方式
```xml
<dependency>
    <groupId>com.github.zhangchunsheng</groupId>
    <artifactId>ucar-java-oauth2</artifactId>
    <version>1.0.0</version>
</dependency>
```

<table border="0">
	<tbody>
		<tr>
			<td align="center" valign="middle">
				<a href="https://url.cn/5jVTRwI" target="_blank">
					<!--<img height="120" src="https://wx4.sinaimg.cn/mw690/46b94231ly1ge0pvo2necj209l05kq3c.jpg">-->
					<img height="120" src="https://ride-group.gitee.io/amapjava/images/tencent.jpeg">
				</a>
			</td>
			<td align="right" valign="middle">
				<!--<img height="120" src="https://wx2.sinaimg.cn/mw690/46b94231ly1ge0po9ko70j20fk0fkjsc.jpg">-->
				<img height="120" src="https://ride-group.gitee.io/amapjava/images/fenxiang.jpeg">
			</td>
			<td align="center" valign="middle">
				<a href="https://www.vultr.com/?ref=8546025-6G" target="_blank">
					<!--<img height="120" src="https://wx3.sinaimg.cn/mw1024/46b94231ly1ge0p76k64bj206o06owev.jpg">-->
					<img height="120" src="https://ride-group.gitee.io/amapjava/images/vultr.jpeg">
				</a>
			</td>
			<td align="center" valign="middle">
				<a href="https://www.aliyun.com/minisite/goods?userCode=tewwu0c8" target="_blank">
					<!--<img height="120" src="https://img.alicdn.com/tfs/TB1Gc3zmAL0gK0jSZFxXXXWHVXa-259-194.jpg">-->
					<img height="120" src="https://ride-group.gitee.io/amapjava/images/aliyun.jpeg">
				</a>
			</td>
		</tr>
	</tbody>
</table>

## 捐助 donate

<table border="0">
	<tbody>
	    <tr>
	        <td>支付宝</td>
	        <td>微信</td>
	    </tr>
		<tr>
			<td align="left" valign="middle">
                <!--<img height="120" src="https://wx4.sinaimg.cn/mw690/46b94231ly1ge0okee0fej20ec0e6gp3.jpg">-->
                <img height="120" src="https://ride-group.gitee.io/amapjava/images/alipay.jpeg">
			</td>
			<td align="center" valign="middle">
				<!--<img height="120" src="https://wx4.sinaimg.cn/mw690/46b94231ly1ge0okecldyj20e80e8n0c.jpg">-->
				<img height="120" src="https://ride-group.gitee.io/amapjava/images/wechat.jpeg">
			</td>
		</tr>
	</tbody>
</table>

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