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
 * 房源租赁
 *
 * @author 
 * @email
 */
@TableName("fangyuan_order")
public class FangyuanOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangyuanOrderEntity() {

	}

	public FangyuanOrderEntity(T t) {
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
     * 订单编号
     */
    @ColumnInfo(comment="订单编号",type="varchar(200)")
    @TableField(value = "fangyuan_order_uuid_number")

    private String fangyuanOrderUuidNumber;


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
     * 购买数量
     */
    @ColumnInfo(comment="购买数量",type="int(11)")
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "fangyuan_order_time")

    private Date fangyuanOrderTime;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "fangyuan_order_true_price")

    private Double fangyuanOrderTruePrice;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "fangyuan_order_types")

    private Integer fangyuanOrderTypes;


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
        return "FangyuanOrder{" +
            ", id=" + id +
            ", fangyuanOrderUuidNumber=" + fangyuanOrderUuidNumber +
            ", fangyuanId=" + fangyuanId +
            ", yonghuId=" + yonghuId +
            ", buyNumber=" + buyNumber +
            ", fangyuanOrderTime=" + DateUtil.convertString(fangyuanOrderTime,"yyyy-MM-dd") +
            ", fangyuanOrderTruePrice=" + fangyuanOrderTruePrice +
            ", fangyuanOrderTypes=" + fangyuanOrderTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
