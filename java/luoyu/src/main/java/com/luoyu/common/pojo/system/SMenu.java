package com.luoyu.common.pojo.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * s_menu
 * @author 
 */
@TableName(value = "s_menu")
public class SMenu implements Serializable {
    /**
     * 菜单主键表
     */
    @TableId
    @JsonProperty(value = "id")
    private Integer uid;
    /**
     * 父菜单UID
     */
    @TableField
    @JsonProperty(value = "rel")
    private Integer ptnUid;

    /**
     * 菜单名
     */
    @TableField
    @JsonProperty(value = "title")
    private String menuName;

    /**
     * 菜单链接地址
     */
    @TableField
    @JsonProperty(value = "href")
    private String menuUrl;

    /**
     * 是否包含子节点，0-不包含，1-包含
     */
    @TableField
    @JsonProperty(value = "childFlag")
    private Boolean ptnFlag;

    /**
     * 菜单层级
     */
    @TableField
    @JsonProperty(value = "level")
    private Integer menuLevel;

    /**
     * 菜单图标
     */
    @TableField
    @JsonProperty(value = "icon")
    private String menuIcon;

    /**
     * 菜单编码
     */
    @TableField
    @JsonProperty(value = "code")
    private String menuCode;

    /**
     * 菜单序号
     */
    @TableField
    @JsonIgnore
    private Integer menuOrderNum;

    /**
     * 菜单开启标识，0-关闭，1-开启
     */
    @TableField
    @JsonIgnore
    private Integer openFlag;

    /**
     * 删除标识，0-删除，1-未删除
     */
    @TableField
    @JsonIgnore
    private Integer deleteFlag;

    private static final long serialVersionUID = 1L;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Boolean getPtnFlag() {
        return ptnFlag;
    }

    public void setPtnFlag(Boolean ptnFlag) {
        this.ptnFlag = ptnFlag;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public Integer getMenuOrderNum() {
        return menuOrderNum;
    }

    public void setMenuOrderNum(Integer menuOrderNum) {
        this.menuOrderNum = menuOrderNum;
    }

    public Integer getOpenFlag() {
        return openFlag;
    }

    public void setOpenFlag(Integer openFlag) {
        this.openFlag = openFlag;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getPtnUid() {
        return ptnUid;
    }

    public void setPtnUid(Integer ptnUid) {
        this.ptnUid = ptnUid;
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
        SMenu other = (SMenu) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(other.getMenuName()))
            && (this.getMenuUrl() == null ? other.getMenuUrl() == null : this.getMenuUrl().equals(other.getMenuUrl()))
            && (this.getPtnFlag() == null ? other.getPtnFlag() == null : this.getPtnFlag().equals(other.getPtnFlag()))
            && (this.getMenuLevel() == null ? other.getMenuLevel() == null : this.getMenuLevel().equals(other.getMenuLevel()))
            && (this.getMenuIcon() == null ? other.getMenuIcon() == null : this.getMenuIcon().equals(other.getMenuIcon()))
            && (this.getMenuCode() == null ? other.getMenuCode() == null : this.getMenuCode().equals(other.getMenuCode()))
            && (this.getMenuOrderNum() == null ? other.getMenuOrderNum() == null : this.getMenuOrderNum().equals(other.getMenuOrderNum()))
            && (this.getOpenFlag() == null ? other.getOpenFlag() == null : this.getOpenFlag().equals(other.getOpenFlag()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()))
            && (this.getPtnUid() == null ? other.getPtnUid() == null : this.getPtnUid().equals(other.getPtnUid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
        result = prime * result + ((getMenuUrl() == null) ? 0 : getMenuUrl().hashCode());
        result = prime * result + ((getPtnFlag() == null) ? 0 : getPtnFlag().hashCode());
        result = prime * result + ((getMenuLevel() == null) ? 0 : getMenuLevel().hashCode());
        result = prime * result + ((getMenuIcon() == null) ? 0 : getMenuIcon().hashCode());
        result = prime * result + ((getMenuCode() == null) ? 0 : getMenuCode().hashCode());
        result = prime * result + ((getMenuOrderNum() == null) ? 0 : getMenuOrderNum().hashCode());
        result = prime * result + ((getOpenFlag() == null) ? 0 : getOpenFlag().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        result = prime * result + ((getPtnUid() == null) ? 0 : getPtnUid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", ptnUid=").append(ptnUid);
        sb.append(", menuName=").append(menuName);
        sb.append(", menuUrl=").append(menuUrl);
        sb.append(", ptnFlag=").append(ptnFlag);
        sb.append(", menuLevel=").append(menuLevel);
        sb.append(", menuIcon=").append(menuIcon);
        sb.append(", menuCode=").append(menuCode);
        sb.append(", menuOrderNum=").append(menuOrderNum);
        sb.append(", openFlag=").append(openFlag);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append("]");
        return sb.toString();
    }
}