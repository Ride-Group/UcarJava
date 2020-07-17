package com.github.zhangchunsheng.ucaroauth2.bean.result;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zhangchunsheng.ucar.common.bean.result.BaseUcarResult;
import me.zhangchunsheng.ucar.common.util.json.UcarGsonBuilder;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * 转换短链接结果对象类
 * Created by Chunsheng Zhang on 2020/7/17.
 * </pre>
 *
 * @author <a href="https://github.com/zhangchunsheng">Chunsheng Zhang</a>
 */
@Data
@EqualsAndHashCode()
public class TokenResult implements Serializable {
    private static final long serialVersionUID = -2020914532329687746L;

    /**
     * client_id=null&client_secret=null&grant_type=client_credentials
     * {"error":"unauthorized","error_description":"An Authentication object was not found in the SecurityContext"}
     *
     * {
     *     "access_token": "b57e48cb-103a-49e2-a209-a385957e96c9",
     *     "token_type": "bearer",
     *     "expires_in": 43046,
     *     "scope": "read"
     * }
     */
    @SerializedName("error")
    private String error;

    @SerializedName("error_description")
    private String errorDescription;

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("expires_in")
    private int expiresIn;

    @SerializedName("scope")
    private String scope;

    /**
     * 请求是否成功.
     */
    public boolean isSuccess() {
        return StringUtils.equals(error, null);
    }

    public static TokenResult fromJson(String json) {
        return UcarGsonBuilder.create().fromJson(json, TokenResult.class);
    }

    @Override
    public String toString() {
        return UcarGsonBuilder.create().toJson(this);
    }

}
