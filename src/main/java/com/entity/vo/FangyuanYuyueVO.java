package com.entity.vo;

import com.entity.FangyuanYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 租房预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangyuan_yuyue")
public class FangyuanYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名唯一编号
     */

    @TableField(value = "fangyuan_yuyue_uuid_number")
    private String fangyuanYuyueUuidNumber;


    /**
     * 房源
     */

    @TableField(value = "fangyuan_id")
    private Integer fangyuanId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 报名理由
     */

    @TableField(value = "fangyuan_yuyue_text")
    private String fangyuanYuyueText;


    /**
     * 报名状态
     */

    @TableField(value = "fangyuan_yuyue_yesno_types")
    private Integer fangyuanYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "fangyuan_yuyue_yesno_text")
    private String fangyuanYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fangyuan_yuyue_shenhe_time")
    private Date fangyuanYuyueShenheTime;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fangyuan_yuyue_time")
    private Date fangyuanYuyueTime;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：报名唯一编号
	 */
    public String getFangyuanYuyueUuidNumber() {
        return fangyuanYuyueUuidNumber;
    }


    /**
	 * 获取：报名唯一编号
	 */

    public void setFangyuanYuyueUuidNumber(String fangyuanYuyueUuidNumber) {
        this.fangyuanYuyueUuidNumber = fangyuanYuyueUuidNumber;
    }
    /**
	 * 设置：房源
	 */
    public Integer getFangyuanId() {
        return fangyuanId;
    }


    /**
	 * 获取：房源
	 */

    public void setFangyuanId(Integer fangyuanId) {
        this.fangyuanId = fangyuanId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：报名理由
	 */
    public String getFangyuanYuyueText() {
        return fangyuanYuyueText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setFangyuanYuyueText(String fangyuanYuyueText) {
        this.fangyuanYuyueText = fangyuanYuyueText;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getFangyuanYuyueYesnoTypes() {
        return fangyuanYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setFangyuanYuyueYesnoTypes(Integer fangyuanYuyueYesnoTypes) {
        this.fangyuanYuyueYesnoTypes = fangyuanYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getFangyuanYuyueYesnoText() {
        return fangyuanYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setFangyuanYuyueYesnoText(String fangyuanYuyueYesnoText) {
        this.fangyuanYuyueYesnoText = fangyuanYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getFangyuanYuyueShenheTime() {
        return fangyuanYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setFangyuanYuyueShenheTime(Date fangyuanYuyueShenheTime) {
        this.fangyuanYuyueShenheTime = fangyuanYuyueShenheTime;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getFangyuanYuyueTime() {
        return fangyuanYuyueTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setFangyuanYuyueTime(Date fangyuanYuyueTime) {
        this.fangyuanYuyueTime = fangyuanYuyueTime;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
