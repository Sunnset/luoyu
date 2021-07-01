package com.luoyu.common.entity.resource;

import java.io.Serializable;

/**
 * @author wangzb
 * @program: common
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFile() {
        return file;
    }

    public void setFile(long file) {
        this.file = file;
    }

    public long getLabel() {
        return label;
    }

    public void setLabel(long label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "FileLabel{" +
                "id=" + id +
                ", file=" + file +
                ", label=" + label +
                '}';
    }
}
