package com.entity.vo;

import com.entity.FangyuanOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房源租赁
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangyuan_order")
public class FangyuanOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "fangyuan_order_uuid_number")
    private String fangyuanOrderUuidNumber;


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
     * 购买数量
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fangyuan_order_time")
    private Date fangyuanOrderTime;


    /**
     * 实付价格
     */

    @TableField(value = "fangyuan_order_true_price")
    private Double fangyuanOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "fangyuan_order_types")
    private Integer fangyuanOrderTypes;


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
	 * 设置：订单编号
	 */
    public String getFangyuanOrderUuidNumber() {
        return fangyuanOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setFangyuanOrderUuidNumber(String fangyuanOrderUuidNumber) {
        this.fangyuanOrderUuidNumber = fangyuanOrderUuidNumber;
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
	 * 设置：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getFangyuanOrderTime() {
        return fangyuanOrderTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setFangyuanOrderTime(Date fangyuanOrderTime) {
        this.fangyuanOrderTime = fangyuanOrderTime;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getFangyuanOrderTruePrice() {
        return fangyuanOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setFangyuanOrderTruePrice(Double fangyuanOrderTruePrice) {
        this.fangyuanOrderTruePrice = fangyuanOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getFangyuanOrderTypes() {
        return fangyuanOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setFangyuanOrderTypes(Integer fangyuanOrderTypes) {
        this.fangyuanOrderTypes = fangyuanOrderTypes;
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
