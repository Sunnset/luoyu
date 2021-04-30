package org.luo.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static Properties props =  null;

    public PropertiesUtil(String path){
        new PropertiesUtil(new File(path));
    }

    public PropertiesUtil(File properties){
        try(FileInputStream inputStream = new FileInputStream(properties)){
            props = new Properties();
            props.load(inputStream);
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("未找到指定配置文件");
            System.exit(-1);
        }
    }

    public String get(String key) {
        return props.getProperty(key, null);
    }
}
