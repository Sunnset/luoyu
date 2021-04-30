package com.pl.source.core;


import com.pl.source.core.entity.File;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author wangzb
 * @program: tools
 * @description 文件管理系统-文件工具类
 * @create: 2021-04-30 22:12
 */
public class FileUtil implements Serializable {

    private static final long serialVersionUID = 8957300161572380599L;

    /**
     * 对于文件按照执行大小进行切片
     * @author wangzb
     * @param target 需要切片的文件
     * @param blockSize 切片文件尺寸
     * @param out 切片文件输出路径
     * @return list
     */
    public List<File> splitBlock(File target, long blockSize, String out) {
        System.err.println("未实现该方法.....");
        return Collections.emptyList();
    }
}
