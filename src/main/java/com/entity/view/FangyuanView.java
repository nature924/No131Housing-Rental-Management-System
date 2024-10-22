package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FangyuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 租房房源
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fangyuan")
public class FangyuanView extends FangyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 房源类型的值
	*/
	@ColumnInfo(comment="房源类型的字典表值",type="varchar(200)")
	private String fangyuanValue;




	public FangyuanView() {

	}

	public FangyuanView(FangyuanEntity fangyuanEntity) {
		try {
			BeanUtils.copyProperties(this, fangyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 房源类型的值
	*/
	public String getFangyuanValue() {
		return fangyuanValue;
	}
	/**
	* 设置： 房源类型的值
	*/
	public void setFangyuanValue(String fangyuanValue) {
		this.fangyuanValue = fangyuanValue;
	}




	@Override
	public String toString() {
		return "FangyuanView{" +
			", fangyuanValue=" + fangyuanValue +
			"} " + super.toString();
	}
}
