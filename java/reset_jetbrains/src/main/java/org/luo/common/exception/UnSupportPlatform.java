package org.luo.common.exception;

/**
 * @author wangzb
 * @program Jetbrains产品授权重置
 * @description 不支持的平台
 * @create 2021-06-05  07-
 **/
public class UnSupportPlatform extends RuntimeException{
    private String msg;

    public UnSupportPlatform(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
