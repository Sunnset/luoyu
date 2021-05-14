package com.luoyu.common.entity.resource;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author wangzb
 * @program: common
 * @description 文件管理系统-文件实体
 * @create: 2021-04-30 22:02
 */
public class File implements Serializable {
    private static final long serialVersionUID = -2734486196226131734L;
    /**
     * 文件唯一标识
     */
    private long id;
    /**
     * 文件名
     */
    private String name;
    /**
     * 文件扩展名
     */
    private String extName;
    /**
     * 文件保存地址
     */
    private String url;
    /**
     * 文件上传时间
     */
    private Date createTime;
    /**
     * 文件更新时间
     */
    private Date updTime;
    /**
     * 文件大小
     */
    private long fileSize;
    /**
     * 文件完整性校验方式
     */
    private String chkType;
    /**
     * 文件完整性校验值
     */
    private String chkCode;
    /**
     * 文件的标签
     */
    private List<Label> labels;
    public File() {
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

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getChkType() {
        return chkType;
    }

    public void setChkType(String chkType) {
        this.chkType = chkType;
    }

    public String getChkCode() {
        return chkCode;
    }

    public void setChkCode(String chkCode) {
        this.chkCode = chkCode;
    }

    /**
     * 获取文件的输出流
     * @return OutputStream
     */
    public OutputStream getOutPutStream(){
        System.err.println("未实现该方法");
        return null;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", extName='" + extName + '\'' +
                ", url='" + url + '\'' +
                ", createTime=" + createTime +
                ", updTime=" + updTime +
                ", fileSize=" + fileSize +
                ", chkType='" + chkType + '\'' +
                ", chkCode='" + chkCode + '\'' +
                '}';
    }
}
