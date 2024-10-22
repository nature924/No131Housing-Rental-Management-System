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
 * 租房预约
 *
 * @author 
 * @email
 */
@TableName("fangyuan_yuyue")
public class FangyuanYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangyuanYuyueEntity() {

	}

	public FangyuanYuyueEntity(T t) {
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
     * 报名唯一编号
     */
    @ColumnInfo(comment="报名唯一编号",type="varchar(200)")
    @TableField(value = "fangyuan_yuyue_uuid_number")

    private String fangyuanYuyueUuidNumber;


    /**
     * 房源
     */
    @ColumnInfo(comment="房源",type="int(11)")
    @TableField(value = "fangyuan_id")

    private Integer fangyuanId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 报名理由
     */
    @ColumnInfo(comment="报名理由",type="text")
    @TableField(value = "fangyuan_yuyue_text")

    private String fangyuanYuyueText;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "fangyuan_yuyue_yesno_types")

    private Integer fangyuanYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="text")
    @TableField(value = "fangyuan_yuyue_yesno_text")

    private String fangyuanYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "fangyuan_yuyue_shenhe_time")

    private Date fangyuanYuyueShenheTime;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "fangyuan_yuyue_time")

    private Date fangyuanYuyueTime;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：报名唯一编号
	 */
    public String getFangyuanYuyueUuidNumber() {
        return fangyuanYuyueUuidNumber;
    }
    /**
	 * 设置：报名唯一编号
	 */

    public void setFangyuanYuyueUuidNumber(String fangyuanYuyueUuidNumber) {
        this.fangyuanYuyueUuidNumber = fangyuanYuyueUuidNumber;
    }
    /**
	 * 获取：房源
	 */
    public Integer getFangyuanId() {
        return fangyuanId;
    }
    /**
	 * 设置：房源
	 */

    public void setFangyuanId(Integer fangyuanId) {
        this.fangyuanId = fangyuanId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：报名理由
	 */
    public String getFangyuanYuyueText() {
        return fangyuanYuyueText;
    }
    /**
	 * 设置：报名理由
	 */

    public void setFangyuanYuyueText(String fangyuanYuyueText) {
        this.fangyuanYuyueText = fangyuanYuyueText;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getFangyuanYuyueYesnoTypes() {
        return fangyuanYuyueYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setFangyuanYuyueYesnoTypes(Integer fangyuanYuyueYesnoTypes) {
        this.fangyuanYuyueYesnoTypes = fangyuanYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getFangyuanYuyueYesnoText() {
        return fangyuanYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setFangyuanYuyueYesnoText(String fangyuanYuyueYesnoText) {
        this.fangyuanYuyueYesnoText = fangyuanYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getFangyuanYuyueShenheTime() {
        return fangyuanYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setFangyuanYuyueShenheTime(Date fangyuanYuyueShenheTime) {
        this.fangyuanYuyueShenheTime = fangyuanYuyueShenheTime;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getFangyuanYuyueTime() {
        return fangyuanYuyueTime;
    }
    /**
	 * 设置：预约时间
	 */

    public void setFangyuanYuyueTime(Date fangyuanYuyueTime) {
        this.fangyuanYuyueTime = fangyuanYuyueTime;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "FangyuanYuyue{" +
            ", id=" + id +
            ", fangyuanYuyueUuidNumber=" + fangyuanYuyueUuidNumber +
            ", fangyuanId=" + fangyuanId +
            ", yonghuId=" + yonghuId +
            ", fangyuanYuyueText=" + fangyuanYuyueText +
            ", fangyuanYuyueYesnoTypes=" + fangyuanYuyueYesnoTypes +
            ", fangyuanYuyueYesnoText=" + fangyuanYuyueYesnoText +
            ", fangyuanYuyueShenheTime=" + DateUtil.convertString(fangyuanYuyueShenheTime,"yyyy-MM-dd") +
            ", fangyuanYuyueTime=" + DateUtil.convertString(fangyuanYuyueTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
