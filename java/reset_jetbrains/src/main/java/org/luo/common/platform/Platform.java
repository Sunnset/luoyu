package org.luo.common.platform;

import org.luo.common.exception.UnSupportPlatform;
import org.luo.common.platform.impl.PlatformMac;
import org.luo.common.platform.impl.PlatformWindows;
import org.luo.common.util.FileUtil;
import org.luo.common.util.PropertiesUtil;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class Platform {

    protected Pattern numberPattern = Pattern.compile("[0-9]");
    /**
     * 本地安装的产品信息
     */
    protected List<String> products = new ArrayList<>();

    protected Set<String> delFiles = new HashSet<String>();

    /**
     * 收集本地安装的Jetbrains产品信息
     * @return list
     */
    public abstract Platform collectProdcut();

    /**
     * 获取各平台的操作实例
     * @return platform
     */
    public static Platform getInstance() {
        String osName = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        if (osName.contains("windows")) {
            return new PlatformWindows();
        }
        if (osName.contains("mac")) {
            return new PlatformMac();
        }
        throw new UnSupportPlatform("unsupport platform:" + osName);
    }

    public void resetEval(){
        products.forEach(path -> {
            List<File> props = Arrays.stream(Objects.requireNonNull(new File(path).listFiles()))
                                .filter(file -> file.getName().endsWith(".properties")).collect(Collectors.toList());
            if (props.size() == 1) {
                PropertiesUtil prop = new PropertiesUtil(props.get(0));
                String configPath = prop.getLike("config.path");
                if (!Objects.isNull(configPath) && configPath.length() != 0) {
                    path = configPath;
                }
            }
            delFiles.add(path + File.separator + "options" + File.separator + "other.xml");
            delFiles.add(path + File.separator + "eval");
        });
        handlerEval();
        delFiles.forEach(e ->{
            FileUtil.delete(new File(e));
        });
    }

    protected abstract void handlerEval();

    public List<String> getProducts() {
        return products;
    }
}
