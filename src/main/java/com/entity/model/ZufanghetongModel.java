package com.entity.model;

import com.entity.ZufanghetongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 租房合同
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZufanghetongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 租房订单
     */
    private Integer fangyuanOrderId;


    /**
     * 租房合同
     */
    private String zufanghetongName;


    /**
     * 上传租房合同
     */
    private String zufanghetongFile;


    /**
     * 备注
     */
    private String shoufanghetongText;


    /**
     * 逻辑删除
     */
    private Integer zufanghetongDelete;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
