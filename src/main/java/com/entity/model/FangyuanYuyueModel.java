package com.entity.model;

import com.entity.FangyuanYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 租房预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangyuanYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名唯一编号
     */
    private String fangyuanYuyueUuidNumber;


    /**
     * 房源
     */
    private Integer fangyuanId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 报名理由
     */
    private String fangyuanYuyueText;


    /**
     * 报名状态
     */
    private Integer fangyuanYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String fangyuanYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fangyuanYuyueShenheTime;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fangyuanYuyueTime;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
