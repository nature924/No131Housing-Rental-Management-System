
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 租房预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fangyuanYuyue")
public class FangyuanYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(FangyuanYuyueController.class);

    private static final String TABLE_NAME = "fangyuanYuyue";

    @Autowired
    private FangyuanYuyueService fangyuanYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BaoxiuService baoxiuService;//报修
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private FangyuanService fangyuanService;//租房房源
    @Autowired
    private FangyuanCommentbackService fangyuanCommentbackService;//租房评价
    @Autowired
    private FangyuanOrderService fangyuanOrderService;//房源租赁
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private LiuyanService liuyanService;//投诉建议
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZufanghetongService zufanghetongService;//租房合同
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = fangyuanYuyueService.queryPage(params);

        //字典表数据转换
        List<FangyuanYuyueView> list =(List<FangyuanYuyueView>)page.getList();
        for(FangyuanYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangyuanYuyueEntity fangyuanYuyue = fangyuanYuyueService.selectById(id);
        if(fangyuanYuyue !=null){
            //entity转view
            FangyuanYuyueView view = new FangyuanYuyueView();
            BeanUtils.copyProperties( fangyuanYuyue , view );//把实体数据重构到view中
            //级联表 租房房源
            //级联表
            FangyuanEntity fangyuan = fangyuanService.selectById(fangyuanYuyue.getFangyuanId());
            if(fangyuan != null){
            BeanUtils.copyProperties( fangyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setFangyuanId(fangyuan.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(fangyuanYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FangyuanYuyueEntity fangyuanYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangyuanYuyue:{}",this.getClass().getName(),fangyuanYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            fangyuanYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<FangyuanYuyueEntity> queryWrapper = new EntityWrapper<FangyuanYuyueEntity>()
            .eq("fangyuan_id", fangyuanYuyue.getFangyuanId())
            .eq("yonghu_id", fangyuanYuyue.getYonghuId())
            .in("fangyuan_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangyuanYuyueEntity fangyuanYuyueEntity = fangyuanYuyueService.selectOne(queryWrapper);
        if(fangyuanYuyueEntity==null){
            fangyuanYuyue.setFangyuanYuyueYesnoTypes(1);
            fangyuanYuyue.setInsertTime(new Date());
            fangyuanYuyue.setCreateTime(new Date());
            fangyuanYuyueService.insert(fangyuanYuyue);
            return R.ok();
        }else {
            if(fangyuanYuyueEntity.getFangyuanYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(fangyuanYuyueEntity.getFangyuanYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangyuanYuyueEntity fangyuanYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,fangyuanYuyue:{}",this.getClass().getName(),fangyuanYuyue.toString());
        FangyuanYuyueEntity oldFangyuanYuyueEntity = fangyuanYuyueService.selectById(fangyuanYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            fangyuanYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            fangyuanYuyueService.updateById(fangyuanYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody FangyuanYuyueEntity fangyuanYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,fangyuanYuyueEntity:{}",this.getClass().getName(),fangyuanYuyueEntity.toString());

        FangyuanYuyueEntity oldFangyuanYuyue = fangyuanYuyueService.selectById(fangyuanYuyueEntity.getId());//查询原先数据

//        if(fangyuanYuyueEntity.getFangyuanYuyueYesnoTypes() == 2){//通过
//            fangyuanYuyueEntity.setFangyuanYuyueTypes();
//        }else if(fangyuanYuyueEntity.getFangyuanYuyueYesnoTypes() == 3){//拒绝
//            fangyuanYuyueEntity.setFangyuanYuyueTypes();
//        }
        fangyuanYuyueEntity.setFangyuanYuyueShenheTime(new Date());//审核时间
        fangyuanYuyueService.updateById(fangyuanYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FangyuanYuyueEntity> oldFangyuanYuyueList =fangyuanYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        fangyuanYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<FangyuanYuyueEntity> fangyuanYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FangyuanYuyueEntity fangyuanYuyueEntity = new FangyuanYuyueEntity();
//                            fangyuanYuyueEntity.setFangyuanYuyueUuidNumber(data.get(0));                    //报名唯一编号 要改的
//                            fangyuanYuyueEntity.setFangyuanId(Integer.valueOf(data.get(0)));   //房源 要改的
//                            fangyuanYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            fangyuanYuyueEntity.setFangyuanYuyueText(data.get(0));                    //报名理由 要改的
//                            fangyuanYuyueEntity.setFangyuanYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            fangyuanYuyueEntity.setFangyuanYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            fangyuanYuyueEntity.setFangyuanYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            fangyuanYuyueEntity.setFangyuanYuyueTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            fangyuanYuyueEntity.setInsertTime(date);//时间
//                            fangyuanYuyueEntity.setCreateTime(date);//时间
                            fangyuanYuyueList.add(fangyuanYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //报名唯一编号
                                if(seachFields.containsKey("fangyuanYuyueUuidNumber")){
                                    List<String> fangyuanYuyueUuidNumber = seachFields.get("fangyuanYuyueUuidNumber");
                                    fangyuanYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> fangyuanYuyueUuidNumber = new ArrayList<>();
                                    fangyuanYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("fangyuanYuyueUuidNumber",fangyuanYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名唯一编号
                        List<FangyuanYuyueEntity> fangyuanYuyueEntities_fangyuanYuyueUuidNumber = fangyuanYuyueService.selectList(new EntityWrapper<FangyuanYuyueEntity>().in("fangyuan_yuyue_uuid_number", seachFields.get("fangyuanYuyueUuidNumber")));
                        if(fangyuanYuyueEntities_fangyuanYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FangyuanYuyueEntity s:fangyuanYuyueEntities_fangyuanYuyueUuidNumber){
                                repeatFields.add(s.getFangyuanYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fangyuanYuyueService.insertBatch(fangyuanYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = fangyuanYuyueService.queryPage(params);

        //字典表数据转换
        List<FangyuanYuyueView> list =(List<FangyuanYuyueView>)page.getList();
        for(FangyuanYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangyuanYuyueEntity fangyuanYuyue = fangyuanYuyueService.selectById(id);
            if(fangyuanYuyue !=null){


                //entity转view
                FangyuanYuyueView view = new FangyuanYuyueView();
                BeanUtils.copyProperties( fangyuanYuyue , view );//把实体数据重构到view中

                //级联表
                    FangyuanEntity fangyuan = fangyuanService.selectById(fangyuanYuyue.getFangyuanId());
                if(fangyuan != null){
                    BeanUtils.copyProperties( fangyuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangyuanId(fangyuan.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(fangyuanYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FangyuanYuyueEntity fangyuanYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangyuanYuyue:{}",this.getClass().getName(),fangyuanYuyue.toString());
        Wrapper<FangyuanYuyueEntity> queryWrapper = new EntityWrapper<FangyuanYuyueEntity>()
            .eq("fangyuan_yuyue_uuid_number", fangyuanYuyue.getFangyuanYuyueUuidNumber())
            .eq("fangyuan_id", fangyuanYuyue.getFangyuanId())
            .eq("yonghu_id", fangyuanYuyue.getYonghuId())
            .eq("fangyuan_yuyue_text", fangyuanYuyue.getFangyuanYuyueText())
            .in("fangyuan_yuyue_yesno_types", new Integer[]{1,2})
            .eq("fangyuan_yuyue_yesno_text", fangyuanYuyue.getFangyuanYuyueYesnoText())
//            .notIn("fangyuan_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangyuanYuyueEntity fangyuanYuyueEntity = fangyuanYuyueService.selectOne(queryWrapper);
        if(fangyuanYuyueEntity==null){
            fangyuanYuyue.setFangyuanYuyueYesnoTypes(1);
            fangyuanYuyue.setInsertTime(new Date());
            fangyuanYuyue.setCreateTime(new Date());
        fangyuanYuyueService.insert(fangyuanYuyue);

            return R.ok();
        }else {
            if(fangyuanYuyueEntity.getFangyuanYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(fangyuanYuyueEntity.getFangyuanYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

