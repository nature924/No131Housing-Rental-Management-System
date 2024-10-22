package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZufanghetongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 租房合同
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zufanghetong")
public class ZufanghetongView extends ZufanghetongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 房源租赁
		/**
		* 订单编号
		*/

		@ColumnInfo(comment="订单编号",type="varchar(200)")
		private String fangyuanOrderUuidNumber;
										 
		/**
		* 房源租赁 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer fangyuanOrderYonghuId;
		/**
		* 购买数量
		*/

		@ColumnInfo(comment="购买数量",type="int(11)")
		private Integer buyNumber;
		/**
		* 预约时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="预约时间",type="timestamp")
		private Date fangyuanOrderTime;
		/**
		* 实付价格
		*/
		@ColumnInfo(comment="实付价格",type="decimal(10,2)")
		private Double fangyuanOrderTruePrice;
		/**
		* 订单类型
		*/
		@ColumnInfo(comment="订单类型",type="int(11)")
		private Integer fangyuanOrderTypes;
			/**
			* 订单类型的值
			*/
			@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
			private String fangyuanOrderValue;



	public ZufanghetongView() {

	}

	public ZufanghetongView(ZufanghetongEntity zufanghetongEntity) {
		try {
			BeanUtils.copyProperties(this, zufanghetongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 房源租赁

		/**
		* 获取： 订单编号
		*/
		public String getFangyuanOrderUuidNumber() {
			return fangyuanOrderUuidNumber;
		}
		/**
		* 设置： 订单编号
		*/
		public void setFangyuanOrderUuidNumber(String fangyuanOrderUuidNumber) {
			this.fangyuanOrderUuidNumber = fangyuanOrderUuidNumber;
		}
		/**
		* 获取：房源租赁 的 用户
		*/
		public Integer getFangyuanOrderYonghuId() {
			return fangyuanOrderYonghuId;
		}
		/**
		* 设置：房源租赁 的 用户
		*/
		public void setFangyuanOrderYonghuId(Integer fangyuanOrderYonghuId) {
			this.fangyuanOrderYonghuId = fangyuanOrderYonghuId;
		}

		/**
		* 获取： 购买数量
		*/
		public Integer getBuyNumber() {
			return buyNumber;
		}
		/**
		* 设置： 购买数量
		*/
		public void setBuyNumber(Integer buyNumber) {
			this.buyNumber = buyNumber;
		}

		/**
		* 获取： 预约时间
		*/
		public Date getFangyuanOrderTime() {
			return fangyuanOrderTime;
		}
		/**
		* 设置： 预约时间
		*/
		public void setFangyuanOrderTime(Date fangyuanOrderTime) {
			this.fangyuanOrderTime = fangyuanOrderTime;
		}

		/**
		* 获取： 实付价格
		*/
		public Double getFangyuanOrderTruePrice() {
			return fangyuanOrderTruePrice;
		}
		/**
		* 设置： 实付价格
		*/
		public void setFangyuanOrderTruePrice(Double fangyuanOrderTruePrice) {
			this.fangyuanOrderTruePrice = fangyuanOrderTruePrice;
		}
		/**
		* 获取： 订单类型
		*/
		public Integer getFangyuanOrderTypes() {
			return fangyuanOrderTypes;
		}
		/**
		* 设置： 订单类型
		*/
		public void setFangyuanOrderTypes(Integer fangyuanOrderTypes) {
			this.fangyuanOrderTypes = fangyuanOrderTypes;
		}


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


	@Override
	public String toString() {
		return "ZufanghetongView{" +
			", fangyuanOrderUuidNumber=" + fangyuanOrderUuidNumber +
			", buyNumber=" + buyNumber +
			", fangyuanOrderTime=" + DateUtil.convertString(fangyuanOrderTime,"yyyy-MM-dd") +
			", fangyuanOrderTruePrice=" + fangyuanOrderTruePrice +
			"} " + super.toString();
	}
}
