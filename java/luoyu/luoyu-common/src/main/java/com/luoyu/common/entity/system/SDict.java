package com.luoyu.common.entity.system;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wangzb
 * @program: luoyu
 * @description 系统-字典项
 * @create: 2021-05-05 19:34
 */
@Table(name = "S_DICT")
public class SDict implements Serializable {

    private static final long serialVersionUID = -3897139595966491278L;

    /**
     * 主键
     */
    @Column(name = "UID")
    private long uid;
    /**
     * 字典项类型
     */
    @Column(name = "TYPE")
    private int type;
    /**
     * 字典编码
     */
    @Column(name = "CODE")
    private String code;
    /**
     * 字典名称
     */
    @Column(name = "NAME")
    private String name;
    /**
     * 字典内容
     */
    @Column(name = "CONTENT")
    private String content;
    /**
     * 字典备注
     */
    @Column(name = "REMARK")
    private String remark;
    /**
     * 上级字典编码
     */
    @Column(name = "PTN_CODE")
    private String ptnCode;
    /**
     * 字典序号
     */
    @Column(name = "ORDER_NUM")
    private int orderNum;
    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;
    /**
     * 更新时间
     */
    @Column(name = "UPD_TIME")
    private Date updTime;

    public SDict() {
    }

    public SDict(long uid, int type, String code, String name, String content, String remark, String ptnCode, int orderNum, Date createTime, Date updTime) {
        this.uid = uid;
        this.type = type;
        this.code = code;
        this.name = name;
        this.content = content;
        this.remark = remark;
        this.ptnCode = ptnCode;
        this.orderNum = orderNum;
        this.createTime = createTime;
        this.updTime = updTime;
    }

    @Override
    public String toString() {
        return "SDict{" +
                "uid=" + uid +
                ", type=" + type +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", remark='" + remark + '\'' +
                ", ptnCode='" + ptnCode + '\'' +
                ", orderNum=" + orderNum +
                ", createTime=" + createTime +
                ", updTime=" + updTime +
                '}';
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPtnCode() {
        return ptnCode;
    }

    public void setPtnCode(String ptnCode) {
        this.ptnCode = ptnCode;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
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
}
