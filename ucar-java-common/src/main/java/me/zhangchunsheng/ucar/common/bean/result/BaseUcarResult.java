package me.zhangchunsheng.ucar.common.bean.result;

import java.io.Serializable;

import me.zhangchunsheng.ucar.common.util.json.UcarGsonBuilder;
import org.apache.commons.lang3.StringUtils;

import lombok.Data;

/**
 * <pre>
 * 神州专车结果共用属性类.
 * Created by Chunsheng Zhang on 2020/7/17.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Data
public abstract class BaseUcarResult implements Serializable {
    private static final long serialVersionUID = 2020652152604850904L;
    protected int code;
    protected String busiCode;
    protected String status;
    protected String msg;
    protected String uid;
    protected String version;

    /**
     * 请求是否成功.
     */
    public boolean isSuccess() {
        return StringUtils.equalsIgnoreCase(status, "SUCCESS");
    }

    public static BaseUcarResult fromJson(String json) {
        return UcarGsonBuilder.create().fromJson(json, BaseUcarResult.class);
    }

    @Override
    public String toString() {
        return UcarGsonBuilder.create().toJson(this);
    }
}
