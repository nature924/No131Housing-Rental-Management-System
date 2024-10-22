package com.entity.vo;

import com.entity.ZufanghetongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 租房合同
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zufanghetong")
public class ZufanghetongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 租房订单
     */

    @TableField(value = "fangyuan_order_id")
    private Integer fangyuanOrderId;


    /**
     * 租房合同
     */

    @TableField(value = "zufanghetong_name")
    private String zufanghetongName;


    /**
     * 上传租房合同
     */

    @TableField(value = "zufanghetong_file")
    private String zufanghetongFile;


    /**
     * 备注
     */

    @TableField(value = "shoufanghetong_text")
    private String shoufanghetongText;


    /**
     * 逻辑删除
     */

    @TableField(value = "zufanghetong_delete")
    private Integer zufanghetongDelete;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：租房订单
	 */
    public Integer getFangyuanOrderId() {
        return fangyuanOrderId;
    }


    /**
	 * 获取：租房订单
	 */

    public void setFangyuanOrderId(Integer fangyuanOrderId) {
        this.fangyuanOrderId = fangyuanOrderId;
    }
    /**
	 * 设置：租房合同
	 */
    public String getZufanghetongName() {
        return zufanghetongName;
    }


    /**
	 * 获取：租房合同
	 */

    public void setZufanghetongName(String zufanghetongName) {
        this.zufanghetongName = zufanghetongName;
    }
    /**
	 * 设置：上传租房合同
	 */
    public String getZufanghetongFile() {
        return zufanghetongFile;
    }


    /**
	 * 获取：上传租房合同
	 */

    public void setZufanghetongFile(String zufanghetongFile) {
        this.zufanghetongFile = zufanghetongFile;
    }
    /**
	 * 设置：备注
	 */
    public String getShoufanghetongText() {
        return shoufanghetongText;
    }


    /**
	 * 获取：备注
	 */

    public void setShoufanghetongText(String shoufanghetongText) {
        this.shoufanghetongText = shoufanghetongText;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getZufanghetongDelete() {
        return zufanghetongDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setZufanghetongDelete(Integer zufanghetongDelete) {
        this.zufanghetongDelete = zufanghetongDelete;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
