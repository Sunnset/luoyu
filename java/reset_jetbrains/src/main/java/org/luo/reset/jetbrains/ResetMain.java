package org.luo.reset.jetbrains;

import org.luo.common.enviroment.BaseEnvironment;
import org.luo.common.enviroment.Product;

import java.io.File;
import java.util.ArrayList;

public class ResetMain {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder(System.getProperty("user.home")).append(File.separator);
        for (String path : BaseEnvironment.JETBRAIN_CONFIG_PATH) {
            stringBuilder.append(path).append(File.separator);
        }
        File jetbrainConfig = new File(stringBuilder.toString());
        if (!jetbrainConfig.exists()) {
            System.err.println("未找到Jetbrains的配置文件夹");
            System.exit(-1);
        }
        File[] produceFiles = jetbrainConfig.listFiles();
        if (produceFiles==null  || produceFiles.length == 0) {
            System.err.println("未找到Jetbrains的配置文件夹");
            System.exit(-1);
        }
        ArrayList<File> produceFolder = new ArrayList<>();
        for (File produce : produceFiles) {
            if (produce.isDirectory()) {
                for (String name : BaseEnvironment.JETBRAINS_PRODUCE_LIST) {
                    if (produce.getName().contains(name)) {
                        produceFolder.add(produce);
                    }
                }
            }
        }
        if (produceFolder.size() == 0) {
            System.err.println("未找到Jetbrains产品的配置文件夹");
            System.exit(-1);
        }
        System.out.println("发现" + produceFolder.size() + "个jetbrains产品配置文件夹");
        for (File folder : produceFolder) {
            for (Product value : Product.values()) {
                if (folder.getName().toLowerCase().contains(value.name().toLowerCase())) {
                    value.delEvalFile(folder);
                    break;
                }
            }
        }
    }
}
