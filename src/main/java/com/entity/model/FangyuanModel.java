package com.entity.model;

import com.entity.FangyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 租房房源
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 房源名称
     */
    private String fangyuanName;


    /**
     * 房源编号
     */
    private String fangyuanUuidNumber;


    /**
     * 房源照片
     */
    private String fangyuanPhoto;


    /**
     * 房源类型
     */
    private Integer fangyuanTypes;


    /**
     * 可以时长/月
     */
    private Integer fangyuanKucunNumber;


    /**
     * 租赁价格/月
     */
    private Double fangyuanNewMoney;


    /**
     * 房源介绍
     */
    private String fangyuanContent;


    /**
     * 逻辑删除
     */
    private Integer fangyuanDelete;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 获取：房源名称
	 */
    public String getFangyuanName() {
        return fangyuanName;
    }


    /**
	 * 设置：房源名称
	 */
    public void setFangyuanName(String fangyuanName) {
        this.fangyuanName = fangyuanName;
    }
    /**
	 * 获取：房源编号
	 */
    public String getFangyuanUuidNumber() {
        return fangyuanUuidNumber;
    }


    /**
	 * 设置：房源编号
	 */
    public void setFangyuanUuidNumber(String fangyuanUuidNumber) {
        this.fangyuanUuidNumber = fangyuanUuidNumber;
    }
    /**
	 * 获取：房源照片
	 */
    public String getFangyuanPhoto() {
        return fangyuanPhoto;
    }


    /**
	 * 设置：房源照片
	 */
    public void setFangyuanPhoto(String fangyuanPhoto) {
        this.fangyuanPhoto = fangyuanPhoto;
    }
    /**
	 * 获取：房源类型
	 */
    public Integer getFangyuanTypes() {
        return fangyuanTypes;
    }


    /**
	 * 设置：房源类型
	 */
    public void setFangyuanTypes(Integer fangyuanTypes) {
        this.fangyuanTypes = fangyuanTypes;
    }
    /**
	 * 获取：可以时长/月
	 */
    public Integer getFangyuanKucunNumber() {
        return fangyuanKucunNumber;
    }


    /**
	 * 设置：可以时长/月
	 */
    public void setFangyuanKucunNumber(Integer fangyuanKucunNumber) {
        this.fangyuanKucunNumber = fangyuanKucunNumber;
    }
    /**
	 * 获取：租赁价格/月
	 */
    public Double getFangyuanNewMoney() {
        return fangyuanNewMoney;
    }


    /**
	 * 设置：租赁价格/月
	 */
    public void setFangyuanNewMoney(Double fangyuanNewMoney) {
        this.fangyuanNewMoney = fangyuanNewMoney;
    }
    /**
	 * 获取：房源介绍
	 */
    public String getFangyuanContent() {
        return fangyuanContent;
    }


    /**
	 * 设置：房源介绍
	 */
    public void setFangyuanContent(String fangyuanContent) {
        this.fangyuanContent = fangyuanContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFangyuanDelete() {
        return fangyuanDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setFangyuanDelete(Integer fangyuanDelete) {
        this.fangyuanDelete = fangyuanDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
