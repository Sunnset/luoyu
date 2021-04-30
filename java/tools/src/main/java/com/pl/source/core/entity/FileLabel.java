package com.pl.source.core.entity;

import java.io.Serializable;

/**
 * @author wangzb
 * @program: tools
 * @description 文件管理系统-文件与标签关联信息
 * @create: 2021-04-30 22:26
 */
public class FileLabel implements Serializable {
    private static final long serialVersionUID = 4070575180619659420L;
    /**
     * 唯一标识
     */
    private long id;
    /**
     * 文件的唯一标识
     */
    private long file;
    /**
     * 标签的唯一标识
     */
    private long label;
}
