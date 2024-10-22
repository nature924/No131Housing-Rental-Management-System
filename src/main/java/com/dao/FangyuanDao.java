package com.dao;

import com.entity.FangyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangyuanView;

/**
 * 租房房源 Dao 接口
 *
 * @author 
 */
public interface FangyuanDao extends BaseMapper<FangyuanEntity> {

   List<FangyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
