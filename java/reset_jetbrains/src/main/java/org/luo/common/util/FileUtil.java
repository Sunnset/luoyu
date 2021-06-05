package org.luo.common.util;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author wangzb
 * @program Jetbrains产品授权重置
 * @description 文件操作工具类
 * @create 2021-06-05  12-
 **/
public class FileUtil {
    public static boolean delete(File file) {
        if (Objects.isNull(file)) {
            return false;
        }
        if (!file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach(FileUtil::delete);
        }
        return file.delete();
    }
}
