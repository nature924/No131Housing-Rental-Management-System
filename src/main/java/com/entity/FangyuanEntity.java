package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 租房房源
 *
 * @author 
 * @email
 */
@TableName("fangyuan")
public class FangyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangyuanEntity() {

	}

	public FangyuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 房源名称
     */
    @ColumnInfo(comment="房源名称",type="varchar(200)")
    @TableField(value = "fangyuan_name")

    private String fangyuanName;


    /**
     * 房源编号
     */
    @ColumnInfo(comment="房源编号",type="varchar(200)")
    @TableField(value = "fangyuan_uuid_number")

    private String fangyuanUuidNumber;


    /**
     * 房源照片
     */
    @ColumnInfo(comment="房源照片",type="varchar(200)")
    @TableField(value = "fangyuan_photo")

    private String fangyuanPhoto;


    /**
     * 房源类型
     */
    @ColumnInfo(comment="房源类型",type="int(11)")
    @TableField(value = "fangyuan_types")

    private Integer fangyuanTypes;


    /**
     * 可以时长/月
     */
    @ColumnInfo(comment="可以时长/月",type="int(11)")
    @TableField(value = "fangyuan_kucun_number")

    private Integer fangyuanKucunNumber;


    /**
     * 租赁价格/月
     */
    @ColumnInfo(comment="租赁价格/月",type="decimal(10,2)")
    @TableField(value = "fangyuan_new_money")

    private Double fangyuanNewMoney;


    /**
     * 房源介绍
     */
    @ColumnInfo(comment="房源介绍",type="text")
    @TableField(value = "fangyuan_content")

    private String fangyuanContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "fangyuan_delete")

    private Integer fangyuanDelete;


    /**
     * 创建时间     homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：房源名称
	 */
    public String getFangyuanName() {
        return fangyuanName;
    }
    /**
	 * 设置：房源名称
	 */

    public void setFangyuanName(String fangyuanName) {
        this.fangyuanName = fangyuanName;
    }
    /**
	 * 获取：房源编号
	 */
    public String getFangyuanUuidNumber() {
        return fangyuanUuidNumber;
    }
    /**
	 * 设置：房源编号
	 */

    public void setFangyuanUuidNumber(String fangyuanUuidNumber) {
        this.fangyuanUuidNumber = fangyuanUuidNumber;
    }
    /**
	 * 获取：房源照片
	 */
    public String getFangyuanPhoto() {
        return fangyuanPhoto;
    }
    /**
	 * 设置：房源照片
	 */

    public void setFangyuanPhoto(String fangyuanPhoto) {
        this.fangyuanPhoto = fangyuanPhoto;
    }
    /**
	 * 获取：房源类型
	 */
    public Integer getFangyuanTypes() {
        return fangyuanTypes;
    }
    /**
	 * 设置：房源类型
	 */

    public void setFangyuanTypes(Integer fangyuanTypes) {
        this.fangyuanTypes = fangyuanTypes;
    }
    /**
	 * 获取：可以时长/月
	 */
    public Integer getFangyuanKucunNumber() {
        return fangyuanKucunNumber;
    }
    /**
	 * 设置：可以时长/月
	 */

    public void setFangyuanKucunNumber(Integer fangyuanKucunNumber) {
        this.fangyuanKucunNumber = fangyuanKucunNumber;
    }
    /**
	 * 获取：租赁价格/月
	 */
    public Double getFangyuanNewMoney() {
        return fangyuanNewMoney;
    }
    /**
	 * 设置：租赁价格/月
	 */

    public void setFangyuanNewMoney(Double fangyuanNewMoney) {
        this.fangyuanNewMoney = fangyuanNewMoney;
    }
    /**
	 * 获取：房源介绍
	 */
    public String getFangyuanContent() {
        return fangyuanContent;
    }
    /**
	 * 设置：房源介绍
	 */

    public void setFangyuanContent(String fangyuanContent) {
        this.fangyuanContent = fangyuanContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFangyuanDelete() {
        return fangyuanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setFangyuanDelete(Integer fangyuanDelete) {
        this.fangyuanDelete = fangyuanDelete;
    }
    /**
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Fangyuan{" +
            ", id=" + id +
            ", fangyuanName=" + fangyuanName +
            ", fangyuanUuidNumber=" + fangyuanUuidNumber +
            ", fangyuanPhoto=" + fangyuanPhoto +
            ", fangyuanTypes=" + fangyuanTypes +
            ", fangyuanKucunNumber=" + fangyuanKucunNumber +
            ", fangyuanNewMoney=" + fangyuanNewMoney +
            ", fangyuanContent=" + fangyuanContent +
            ", fangyuanDelete=" + fangyuanDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
