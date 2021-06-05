package org.luo.reset.jetbrains;

import org.luo.common.platform.Platform;

/**
 * @author wangzb
 * @program Jetbrains产品授权重置
 * @description 启动接口
 * @create 2021-06-05  07-
 **/
public class ResetStarter {
    public static void main(String[] args) {
        Platform.getInstance().collectProdcut().resetEval();
    }
}
