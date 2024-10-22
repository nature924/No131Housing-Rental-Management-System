package com.dao;

import com.entity.FangyuanYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangyuanYuyueView;

/**
 * 租房预约 Dao 接口
 *
 * @author 
 */
public interface FangyuanYuyueDao extends BaseMapper<FangyuanYuyueEntity> {

   List<FangyuanYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
