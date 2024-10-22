package com.entity.model;

import com.entity.FangyuanOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房源租赁
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangyuanOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private String fangyuanOrderUuidNumber;


    /**
     * 房源
     */
    private Integer fangyuanId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 购买数量
     */
    private Integer buyNumber;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fangyuanOrderTime;


    /**
     * 实付价格
     */
    private Double fangyuanOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer fangyuanOrderTypes;


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
	 * 获取：订单编号
	 */
    public String getFangyuanOrderUuidNumber() {
        return fangyuanOrderUuidNumber;
    }


    /**
	 * 设置：订单编号
	 */
    public void setFangyuanOrderUuidNumber(String fangyuanOrderUuidNumber) {
        this.fangyuanOrderUuidNumber = fangyuanOrderUuidNumber;
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
	 * 获取：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 设置：购买数量
	 */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getFangyuanOrderTime() {
        return fangyuanOrderTime;
    }


    /**
	 * 设置：预约时间
	 */
    public void setFangyuanOrderTime(Date fangyuanOrderTime) {
        this.fangyuanOrderTime = fangyuanOrderTime;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getFangyuanOrderTruePrice() {
        return fangyuanOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setFangyuanOrderTruePrice(Double fangyuanOrderTruePrice) {
        this.fangyuanOrderTruePrice = fangyuanOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getFangyuanOrderTypes() {
        return fangyuanOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setFangyuanOrderTypes(Integer fangyuanOrderTypes) {
        this.fangyuanOrderTypes = fangyuanOrderTypes;
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
