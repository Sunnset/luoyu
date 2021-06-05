package org.luo.common.platform.impl;

import org.luo.common.enviroment.BaseEnvironment;
import org.luo.common.platform.Platform;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;

/**
 * @author wangzb
 * @program Jetbrains产品授权重置
 * @description windows平台下收集安装的Jetbrains产品信息
 * @create 2021-06-05  07-
 **/
public class PlatformWindows extends Platform {


    /**
     * 收集本地安装的Jetbrains产品信息
     *
     * @return list
     */
    @Override
    public Platform collectProdcut() {
        StringBuilder defaultFolder = new StringBuilder(System.getProperty("user.home")).append(File.separator);
        for (String path : BaseEnvironment.JETBRAIN_CONFIG_PATH) {
            defaultFolder.append(path).append(File.separator);
        }
        File jetbrainConfig = new File(defaultFolder.toString());
        if (!jetbrainConfig.exists()) {
            System.err.println("not found jetbrains info.....");
            return this;
        }
        File[] produceFiles = jetbrainConfig.listFiles();
        if (produceFiles==null  || produceFiles.length == 0) {
            System.err.println("未找到Jetbrains的配置文件夹");
            return this;
        }
        ArrayList<File> produceFolder = new ArrayList<File>(produceFiles.length);
        Arrays.stream(produceFiles).filter(File::isDirectory).forEach(e ->{
            Matcher matcher = numberPattern.matcher(e.getName());
            if(matcher.find()){
                String productName = e.getName().substring(0, matcher.start());
                if (Arrays.stream(BaseEnvironment.JETBRAINS_PRODUCE_LIST).anyMatch(productName::equalsIgnoreCase)) {
                    produceFolder.add(e);
                    products.add(e.getAbsolutePath());
                }
            }
        });
        if (produceFolder.size() == 0) {
            System.err.println("未找到Jetbrains产品的配置文件夹");
        }
        return this;
    }

    @Override
    protected void handlerEval() {
        try {
            Runtime.getRuntime().exec("reg delete \"HKEY_CURRENT_USER\\Software\\JavaSoft\\Prefs\\jetbrains\" /f");
        } catch (IOException e) {
            System.err.println("Error clearing registry information......");
        }
    }
}
