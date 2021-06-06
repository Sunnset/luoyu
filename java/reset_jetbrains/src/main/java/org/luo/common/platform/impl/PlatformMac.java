package org.luo.common.platform.impl;

import org.luo.common.platform.Platform;

/**
 * @author wangzb
 * @program Jetbrains产品授权重置
 * @description Mac平台下收集安装的Jetbrains产品信息
 * @create 2021-06-05  07-
 **/
public class PlatformMac extends Platform {
    /**
     * 收集本地安装的Jetbrains产品信息
     * /Users/wangzb/Library/Application Support/JetBrains/IntelliJIdea2021.1/options
     * @return list
     */
    @Override
    public Platform collectProdcut() {
        return this;
    }

    @Override
    protected void handlerEval() {

    }
}
