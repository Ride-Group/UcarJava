package me.zhangchunsheng.ucar.common.exception;

import com.google.common.base.Joiner;
import lombok.Data;
import lombok.EqualsAndHashCode;
import me.zhangchunsheng.ucar.common.bean.result.BaseUcarResult;

/**
 * <pre>
 * 神州专车异常结果类
 * Created by Chunsheng Zhang on 2020-4-20.
 * </pre>
 *
 * @author ChunshengZhang
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UcarException extends Exception {
    private static final long serialVersionUID = 2020381471513460742L;

    /**
     * 自定义错误讯息.
     */
    private String customErrorMsg;
    /**
     * 返回状态码.
     */
    private String returnStatus;
    /**
     * 返回信息.
     */
    private String returnMsg;

    /**
     * 业务结果.
     */
    private int returnCode;

    /**
     * Instantiates a new Ucar exception.
     *
     * @param customErrorMsg the custom error msg
     */
    public UcarException(String customErrorMsg) {
        super(customErrorMsg);
        this.customErrorMsg = customErrorMsg;
    }

    /**
     * Instantiates a new Ucar exception.
     *
     * @param customErrorMsg the custom error msg
     * @param tr             the tr
     */
    public UcarException(String customErrorMsg, Throwable tr) {
        super(customErrorMsg, tr);
        this.customErrorMsg = customErrorMsg;
    }

    private UcarException(Builder builder) {
        super(builder.buildErrorMsg());
        returnStatus = builder.returnStatus;
        returnMsg = builder.returnMsg;
        returnCode = builder.returnCode;
    }

    /**
     * 通过BaseUcarResult生成异常对象.
     *
     * @param baseResult the base result
     * @return the ucar exception
     */
    public static UcarException from(BaseUcarResult baseResult) {
        return UcarException.newBuilder()
                .returnStatus(baseResult.getStatus())
                .returnMsg(baseResult.getMsg())
                .returnCode(baseResult.getCode())
                .build();
    }

    /**
     * New builder builder.
     *
     * @return the builder
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * The type Builder.
     */
    public static final class Builder {
        private String returnStatus;
        private String returnMsg;
        private int returnCode;

        private Builder() {
        }

        /**
         * Return status builder.
         *
         * @param returnStatus the return status
         * @return the builder
         */
        public Builder returnStatus(String returnStatus) {
            this.returnStatus = returnStatus;
            return this;
        }

        /**
         * Return info builder.
         *
         * @param returnMsg the return info
         * @return the builder
         */
        public Builder returnMsg(String returnMsg) {
            this.returnMsg = returnMsg;
            return this;
        }

        /**
         * Result code builder.
         *
         * @param returnCode the result code
         * @return the builder
         */
        public Builder returnCode(int returnCode) {
            this.returnCode = returnCode;
            return this;
        }

        /**
         * Build ucar oauth2 exception.
         *
         * @return the ucar oauth2 exception
         */
        public UcarException build() {
            return new UcarException(this);
        }

        /**
         * Build error msg string.
         *
         * @return the string
         */
        public String buildErrorMsg() {
            return Joiner.on("，").skipNulls().join(
                    returnStatus == null ? null : String.format("返回代码：[%s]", returnStatus),
                    returnMsg == null ? null : String.format("返回信息：[%s]", returnMsg),
                    String.format("结果代码：[%s]", returnCode)
            );
        }
    }
}
