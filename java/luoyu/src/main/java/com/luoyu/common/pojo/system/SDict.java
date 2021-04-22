package com.luoyu.common.pojo.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * s_dict 字典表
 * @author wangzb
 */
@TableName(value = "s_dict")
public class SDict implements Serializable {
    /**
     * 字典表主键
     */
    @TableId
    private Integer uid;

    /**
     * 父字典主键
     */
    @TableField
    private Integer ptnUid;

    /**
     * 字典名称
     */
    @TableField
    private String dictName;

    /**
     * 字典编码
     */
    @TableField
    private String dictCode;

    /**
     * 字典说明
     */
    @TableField
    private String dictRemark;

    /**
     * 字典类型
     */
    @TableField
    private String dictType;

    /**
     * 删除标识
     */
    @TableField
    private Integer delFlag;
    /**
     * 字典序号
     */
    @TableField
    private Integer orderNum;

    private static final long serialVersionUID = 1L;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPtnUid() {
        return ptnUid;
    }

    public void setPtnUid(Integer ptnUid) {
        this.ptnUid = ptnUid;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictRemark() {
        return dictRemark;
    }

    public void setDictRemark(String dictRemark) {
        this.dictRemark = dictRemark;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SDict other = (SDict) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getPtnUid() == null ? other.getPtnUid() == null : this.getPtnUid().equals(other.getPtnUid()))
            && (this.getDictName() == null ? other.getDictName() == null : this.getDictName().equals(other.getDictName()))
            && (this.getDictCode() == null ? other.getDictCode() == null : this.getDictCode().equals(other.getDictCode()))
            && (this.getDictRemark() == null ? other.getDictRemark() == null : this.getDictRemark().equals(other.getDictRemark()))
            && (this.getDictType() == null ? other.getDictType() == null : this.getDictType().equals(other.getDictType()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getPtnUid() == null) ? 0 : getPtnUid().hashCode());
        result = prime * result + ((getDictName() == null) ? 0 : getDictName().hashCode());
        result = prime * result + ((getDictCode() == null) ? 0 : getDictCode().hashCode());
        result = prime * result + ((getDictRemark() == null) ? 0 : getDictRemark().hashCode());
        result = prime * result + ((getDictType() == null) ? 0 : getDictType().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("uid=").append(uid);
        sb.append(", ptnUid=").append(ptnUid);
        sb.append(", dictName=").append(dictName);
        sb.append(", dictCode=").append(dictCode);
        sb.append(", dictRemark=").append(dictRemark);
        sb.append(", dictType=").append(dictType);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", orderNum=").append(orderNum);
        sb.append("]");
        return sb.toString();
    }
}