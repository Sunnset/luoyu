package com.pl.source.core;

import com.pl.source.core.entity.File;

import java.io.Serializable;

/**
 * 文件管理结构
 */
public interface IFileManager extends Serializable {
    /**
     * 上传文件
     * @return string
     */
    public String upload();

    /**
     * 获取文件信息
     * @author wangzb
     * @param id 文件的唯一标识
     * @return file
     */
    public File get(long id);

    /**
     * 删除文件
     * @return boolean
     */
    public Boolean remove();

    /**
     * 文件重命名
     * @return
     */
    public Boolean rename();
}
