package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.FangyuanCommentbackDao;
import com.entity.FangyuanCommentbackEntity;
import com.service.FangyuanCommentbackService;
import com.entity.view.FangyuanCommentbackView;

/**
 * 租房评价 服务实现类
 */
@Service("fangyuanCommentbackService")
@Transactional
public class FangyuanCommentbackServiceImpl extends ServiceImpl<FangyuanCommentbackDao, FangyuanCommentbackEntity> implements FangyuanCommentbackService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<FangyuanCommentbackView> page =new Query<FangyuanCommentbackView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
