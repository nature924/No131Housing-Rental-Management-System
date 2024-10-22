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
 * 租房合同
 *
 * @author 
 * @email
 */
@TableName("zufanghetong")
public class ZufanghetongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZufanghetongEntity() {

	}

	public ZufanghetongEntity(T t) {
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
     * 租房订单
     */
    @ColumnInfo(comment="租房订单",type="int(11)")
    @TableField(value = "fangyuan_order_id")

    private Integer fangyuanOrderId;


    /**
     * 租房合同
     */
    @ColumnInfo(comment="租房合同",type="varchar(200)")
    @TableField(value = "zufanghetong_name")

    private String zufanghetongName;


    /**
     * 上传租房合同
     */
    @ColumnInfo(comment="上传租房合同",type="varchar(200)")
    @TableField(value = "zufanghetong_file")

    private String zufanghetongFile;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "shoufanghetong_text")

    private String shoufanghetongText;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "zufanghetong_delete")

    private Integer zufanghetongDelete;


    /**
     * 创建时间   listShow
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
	 * 获取：租房订单
	 */
    public Integer getFangyuanOrderId() {
        return fangyuanOrderId;
    }
    /**
	 * 设置：租房订单
	 */

    public void setFangyuanOrderId(Integer fangyuanOrderId) {
        this.fangyuanOrderId = fangyuanOrderId;
    }
    /**
	 * 获取：租房合同
	 */
    public String getZufanghetongName() {
        return zufanghetongName;
    }
    /**
	 * 设置：租房合同
	 */

    public void setZufanghetongName(String zufanghetongName) {
        this.zufanghetongName = zufanghetongName;
    }
    /**
	 * 获取：上传租房合同
	 */
    public String getZufanghetongFile() {
        return zufanghetongFile;
    }
    /**
	 * 设置：上传租房合同
	 */

    public void setZufanghetongFile(String zufanghetongFile) {
        this.zufanghetongFile = zufanghetongFile;
    }
    /**
	 * 获取：备注
	 */
    public String getShoufanghetongText() {
        return shoufanghetongText;
    }
    /**
	 * 设置：备注
	 */

    public void setShoufanghetongText(String shoufanghetongText) {
        this.shoufanghetongText = shoufanghetongText;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getZufanghetongDelete() {
        return zufanghetongDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setZufanghetongDelete(Integer zufanghetongDelete) {
        this.zufanghetongDelete = zufanghetongDelete;
    }
    /**
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Zufanghetong{" +
            ", id=" + id +
            ", fangyuanOrderId=" + fangyuanOrderId +
            ", zufanghetongName=" + zufanghetongName +
            ", zufanghetongFile=" + zufanghetongFile +
            ", shoufanghetongText=" + shoufanghetongText +
            ", zufanghetongDelete=" + zufanghetongDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
