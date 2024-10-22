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
 * 报修
 *
 * @author 
 * @email
 */
@TableName("baoxiu")
public class BaoxiuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BaoxiuEntity() {

	}

	public BaoxiuEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 报修编号
     */
    @ColumnInfo(comment="报修编号",type="varchar(200)")
    @TableField(value = "baoxiu_uuid_number")

    private String baoxiuUuidNumber;


    /**
     * 报修标题
     */
    @ColumnInfo(comment="报修标题",type="varchar(200)")
    @TableField(value = "baoxiu_address")

    private String baoxiuAddress;


    /**
     * 报修位置
     */
    @ColumnInfo(comment="报修位置",type="varchar(200)")
    @TableField(value = "baoxiu_name")

    private String baoxiuName;


    /**
     * 报修类型
     */
    @ColumnInfo(comment="报修类型",type="int(11)")
    @TableField(value = "baoxiu_types")

    private Integer baoxiuTypes;


    /**
     * 报修内容
     */
    @ColumnInfo(comment="报修内容",type="longtext")
    @TableField(value = "baoxiu_content")

    private String baoxiuContent;


    /**
     * 报修费用
     */
    @ColumnInfo(comment="报修费用",type="decimal(10,2)")
    @TableField(value = "baoxiu_money")

    private Double baoxiuMoney;


    /**
     * 报修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="报修时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报修状态
     */
    @ColumnInfo(comment="报修状态",type="int(11)")
    @TableField(value = "baoxiu_zhuangtai_types")

    private Integer baoxiuZhuangtaiTypes;


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
	 * 获取：报修编号
	 */
    public String getBaoxiuUuidNumber() {
        return baoxiuUuidNumber;
    }
    /**
	 * 设置：报修编号
	 */

    public void setBaoxiuUuidNumber(String baoxiuUuidNumber) {
        this.baoxiuUuidNumber = baoxiuUuidNumber;
    }
    /**
	 * 获取：报修标题
	 */
    public String getBaoxiuAddress() {
        return baoxiuAddress;
    }
    /**
	 * 设置：报修标题
	 */

    public void setBaoxiuAddress(String baoxiuAddress) {
        this.baoxiuAddress = baoxiuAddress;
    }
    /**
	 * 获取：报修位置
	 */
    public String getBaoxiuName() {
        return baoxiuName;
    }
    /**
	 * 设置：报修位置
	 */

    public void setBaoxiuName(String baoxiuName) {
        this.baoxiuName = baoxiuName;
    }
    /**
	 * 获取：报修类型
	 */
    public Integer getBaoxiuTypes() {
        return baoxiuTypes;
    }
    /**
	 * 设置：报修类型
	 */

    public void setBaoxiuTypes(Integer baoxiuTypes) {
        this.baoxiuTypes = baoxiuTypes;
    }
    /**
	 * 获取：报修内容
	 */
    public String getBaoxiuContent() {
        return baoxiuContent;
    }
    /**
	 * 设置：报修内容
	 */

    public void setBaoxiuContent(String baoxiuContent) {
        this.baoxiuContent = baoxiuContent;
    }
    /**
	 * 获取：报修费用
	 */
    public Double getBaoxiuMoney() {
        return baoxiuMoney;
    }
    /**
	 * 设置：报修费用
	 */

    public void setBaoxiuMoney(Double baoxiuMoney) {
        this.baoxiuMoney = baoxiuMoney;
    }
    /**
	 * 获取：报修时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：报修时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报修状态
	 */
    public Integer getBaoxiuZhuangtaiTypes() {
        return baoxiuZhuangtaiTypes;
    }
    /**
	 * 设置：报修状态
	 */

    public void setBaoxiuZhuangtaiTypes(Integer baoxiuZhuangtaiTypes) {
        this.baoxiuZhuangtaiTypes = baoxiuZhuangtaiTypes;
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
        return "Baoxiu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", baoxiuUuidNumber=" + baoxiuUuidNumber +
            ", baoxiuAddress=" + baoxiuAddress +
            ", baoxiuName=" + baoxiuName +
            ", baoxiuTypes=" + baoxiuTypes +
            ", baoxiuContent=" + baoxiuContent +
            ", baoxiuMoney=" + baoxiuMoney +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", baoxiuZhuangtaiTypes=" + baoxiuZhuangtaiTypes +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
