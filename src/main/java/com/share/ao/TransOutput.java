package com.share.ao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 接口通用返回信息
 */
@ApiModel(description = "通用返回信息")
public class TransOutput implements Serializable {
    /**
     * 余额不足错误码
     */
    public final static int BALANCE_NOT_ENOUGH_CODE = 2;
    /**
     * 成功码
     */
    public final static int SUCCESS_CODE = 1;
    /**
     * 通用失败码
     */
    public final static int FAILED_CODE = 0;
    /**
     * 成功msg
     */
    public final static String SUCCESS_MSG = "OK";
    /**
     * 重复
     */
    public final static String SUCCESS_REPEAT_MSG = "重复";

    /**
     * 错误码。1：成功，0：失败，<0：其它业务相关的失败错误码（参见TransException）
     */
    @ApiModelProperty(value = "错误码。1：成功，0：失败，<0：其它业务相关的失败错误码（参见接口文档）")
    private int transCode;

    /**
     * 错误信息。成功：“OK” 失败：“失败对应的msg”
     */
    @ApiModelProperty(value = "错误信息。成功：“OK” 失败：“失败对应的msg”")
    private String transMessage;

    public TransOutput() {
        //默认构造为成功情况。子类继承时无需再设置
        this.transCode = SUCCESS_CODE;
        this.transMessage = SUCCESS_MSG;
    }

    public TransOutput(int transCode, String transMessage) {
        this.transCode = transCode;
        this.transMessage = transMessage;
    }

    public int getTransCode() {
        return transCode;
    }

    public void setTransCode(int transCode) {
        this.transCode = transCode;
    }

    public String getTransMessage() {
        return transMessage;
    }

    public void setTransMessage(String transMessage) {
        this.transMessage = transMessage;
    }
}
