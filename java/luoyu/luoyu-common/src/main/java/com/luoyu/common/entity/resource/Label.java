package com.luoyu.common.entity.resource;

import java.io.Serializable;

/**
 * @author wangzb
 * @program: common
 * @description 文件管理系统-文件标签
 * @create: 2021-04-30 22:19
 */
public class Label implements Serializable {

    private static final long serialVersionUID = -6403464438321248230L;
    /**
     * 标签的唯一标识
     */
    private long id;
    /**
     * 标签名称
     */
    private String name;

    public Label() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
