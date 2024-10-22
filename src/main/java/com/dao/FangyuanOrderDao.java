package com.dao;

import com.entity.FangyuanOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangyuanOrderView;

/**
 * 房源租赁 Dao 接口
 *
 * @author 
 */
public interface FangyuanOrderDao extends BaseMapper<FangyuanOrderEntity> {

   List<FangyuanOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
