package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FangyuanOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 房源租赁
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fangyuan_order")
public class FangyuanOrderView extends FangyuanOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String fangyuanOrderValue;

	//级联表 租房房源
		/**
		* 房源名称
		*/

		@ColumnInfo(comment="房源名称",type="varchar(200)")
		private String fangyuanName;
		/**
		* 房源编号
		*/

		@ColumnInfo(comment="房源编号",type="varchar(200)")
		private String fangyuanUuidNumber;
		/**
		* 房源照片
		*/

		@ColumnInfo(comment="房源照片",type="varchar(200)")
		private String fangyuanPhoto;
		/**
		* 房源类型
		*/
		@ColumnInfo(comment="房源类型",type="int(11)")
		private Integer fangyuanTypes;
			/**
			* 房源类型的值
			*/
			@ColumnInfo(comment="房源类型的字典表值",type="varchar(200)")
			private String fangyuanValue;
		/**
		* 可以时长/月
		*/

		@ColumnInfo(comment="可以时长/月",type="int(11)")
		private Integer fangyuanKucunNumber;
		/**
		* 租赁价格/月
		*/
		@ColumnInfo(comment="租赁价格/月",type="decimal(10,2)")
		private Double fangyuanNewMoney;
		/**
		* 房源介绍
		*/

		@ColumnInfo(comment="房源介绍",type="text")
		private String fangyuanContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer fangyuanDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public FangyuanOrderView() {

	}

	public FangyuanOrderView(FangyuanOrderEntity fangyuanOrderEntity) {
		try {
			BeanUtils.copyProperties(this, fangyuanOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getFangyuanOrderValue() {
		return fangyuanOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setFangyuanOrderValue(String fangyuanOrderValue) {
		this.fangyuanOrderValue = fangyuanOrderValue;
	}


	//级联表的get和set 租房房源

		/**
		* 获取： 房源名称
		*/
		public String getFangyuanName() {
			return fangyuanName;
		}
		/**
		* 设置： 房源名称
		*/
		public void setFangyuanName(String fangyuanName) {
			this.fangyuanName = fangyuanName;
		}

		/**
		* 获取： 房源编号
		*/
		public String getFangyuanUuidNumber() {
			return fangyuanUuidNumber;
		}
		/**
		* 设置： 房源编号
		*/
		public void setFangyuanUuidNumber(String fangyuanUuidNumber) {
			this.fangyuanUuidNumber = fangyuanUuidNumber;
		}

		/**
		* 获取： 房源照片
		*/
		public String getFangyuanPhoto() {
			return fangyuanPhoto;
		}
		/**
		* 设置： 房源照片
		*/
		public void setFangyuanPhoto(String fangyuanPhoto) {
			this.fangyuanPhoto = fangyuanPhoto;
		}
		/**
		* 获取： 房源类型
		*/
		public Integer getFangyuanTypes() {
			return fangyuanTypes;
		}
		/**
		* 设置： 房源类型
		*/
		public void setFangyuanTypes(Integer fangyuanTypes) {
			this.fangyuanTypes = fangyuanTypes;
		}


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

		/**
		* 获取： 可以时长/月
		*/
		public Integer getFangyuanKucunNumber() {
			return fangyuanKucunNumber;
		}
		/**
		* 设置： 可以时长/月
		*/
		public void setFangyuanKucunNumber(Integer fangyuanKucunNumber) {
			this.fangyuanKucunNumber = fangyuanKucunNumber;
		}

		/**
		* 获取： 租赁价格/月
		*/
		public Double getFangyuanNewMoney() {
			return fangyuanNewMoney;
		}
		/**
		* 设置： 租赁价格/月
		*/
		public void setFangyuanNewMoney(Double fangyuanNewMoney) {
			this.fangyuanNewMoney = fangyuanNewMoney;
		}

		/**
		* 获取： 房源介绍
		*/
		public String getFangyuanContent() {
			return fangyuanContent;
		}
		/**
		* 设置： 房源介绍
		*/
		public void setFangyuanContent(String fangyuanContent) {
			this.fangyuanContent = fangyuanContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getFangyuanDelete() {
			return fangyuanDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setFangyuanDelete(Integer fangyuanDelete) {
			this.fangyuanDelete = fangyuanDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "FangyuanOrderView{" +
			", fangyuanOrderValue=" + fangyuanOrderValue +
			", fangyuanName=" + fangyuanName +
			", fangyuanUuidNumber=" + fangyuanUuidNumber +
			", fangyuanPhoto=" + fangyuanPhoto +
			", fangyuanKucunNumber=" + fangyuanKucunNumber +
			", fangyuanNewMoney=" + fangyuanNewMoney +
			", fangyuanContent=" + fangyuanContent +
			", fangyuanDelete=" + fangyuanDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", newMoney=" + newMoney +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
