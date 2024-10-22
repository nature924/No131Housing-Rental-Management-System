
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
 * 房源租赁
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fangyuanOrder")
public class FangyuanOrderController {
    private static final Logger logger = LoggerFactory.getLogger(FangyuanOrderController.class);

    private static final String TABLE_NAME = "fangyuanOrder";

    @Autowired
    private FangyuanOrderService fangyuanOrderService;


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
    private FangyuanYuyueService fangyuanYuyueService;//租房预约
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
        PageUtils page = fangyuanOrderService.queryPage(params);

        //字典表数据转换
        List<FangyuanOrderView> list =(List<FangyuanOrderView>)page.getList();
        for(FangyuanOrderView c:list){
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
        FangyuanOrderEntity fangyuanOrder = fangyuanOrderService.selectById(id);
        if(fangyuanOrder !=null){
            //entity转view
            FangyuanOrderView view = new FangyuanOrderView();
            BeanUtils.copyProperties( fangyuanOrder , view );//把实体数据重构到view中
            //级联表 租房房源
            //级联表
            FangyuanEntity fangyuan = fangyuanService.selectById(fangyuanOrder.getFangyuanId());
            if(fangyuan != null){
            BeanUtils.copyProperties( fangyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setFangyuanId(fangyuan.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(fangyuanOrder.getYonghuId());
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
    public R save(@RequestBody FangyuanOrderEntity fangyuanOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangyuanOrder:{}",this.getClass().getName(),fangyuanOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            fangyuanOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        fangyuanOrder.setCreateTime(new Date());
        fangyuanOrder.setInsertTime(new Date());
        fangyuanOrderService.insert(fangyuanOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangyuanOrderEntity fangyuanOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,fangyuanOrder:{}",this.getClass().getName(),fangyuanOrder.toString());
        FangyuanOrderEntity oldFangyuanOrderEntity = fangyuanOrderService.selectById(fangyuanOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            fangyuanOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            fangyuanOrderService.updateById(fangyuanOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FangyuanOrderEntity> oldFangyuanOrderList =fangyuanOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        fangyuanOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<FangyuanOrderEntity> fangyuanOrderList = new ArrayList<>();//上传的东西
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
                            FangyuanOrderEntity fangyuanOrderEntity = new FangyuanOrderEntity();
//                            fangyuanOrderEntity.setFangyuanOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            fangyuanOrderEntity.setFangyuanId(Integer.valueOf(data.get(0)));   //房源 要改的
//                            fangyuanOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            fangyuanOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            fangyuanOrderEntity.setFangyuanOrderTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            fangyuanOrderEntity.setFangyuanOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            fangyuanOrderEntity.setFangyuanOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            fangyuanOrderEntity.setInsertTime(date);//时间
//                            fangyuanOrderEntity.setCreateTime(date);//时间
                            fangyuanOrderList.add(fangyuanOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("fangyuanOrderUuidNumber")){
                                    List<String> fangyuanOrderUuidNumber = seachFields.get("fangyuanOrderUuidNumber");
                                    fangyuanOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> fangyuanOrderUuidNumber = new ArrayList<>();
                                    fangyuanOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("fangyuanOrderUuidNumber",fangyuanOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<FangyuanOrderEntity> fangyuanOrderEntities_fangyuanOrderUuidNumber = fangyuanOrderService.selectList(new EntityWrapper<FangyuanOrderEntity>().in("fangyuan_order_uuid_number", seachFields.get("fangyuanOrderUuidNumber")));
                        if(fangyuanOrderEntities_fangyuanOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FangyuanOrderEntity s:fangyuanOrderEntities_fangyuanOrderUuidNumber){
                                repeatFields.add(s.getFangyuanOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fangyuanOrderService.insertBatch(fangyuanOrderList);
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
        PageUtils page = fangyuanOrderService.queryPage(params);

        //字典表数据转换
        List<FangyuanOrderView> list =(List<FangyuanOrderView>)page.getList();
        for(FangyuanOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangyuanOrderEntity fangyuanOrder = fangyuanOrderService.selectById(id);
            if(fangyuanOrder !=null){


                //entity转view
                FangyuanOrderView view = new FangyuanOrderView();
                BeanUtils.copyProperties( fangyuanOrder , view );//把实体数据重构到view中

                //级联表
                    FangyuanEntity fangyuan = fangyuanService.selectById(fangyuanOrder.getFangyuanId());
                if(fangyuan != null){
                    BeanUtils.copyProperties( fangyuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangyuanId(fangyuan.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(fangyuanOrder.getYonghuId());
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
    public R add(@RequestBody FangyuanOrderEntity fangyuanOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fangyuanOrder:{}",this.getClass().getName(),fangyuanOrder.toString());
            FangyuanEntity fangyuanEntity = fangyuanService.selectById(fangyuanOrder.getFangyuanId());
            if(fangyuanEntity == null){
                return R.error(511,"查不到该租房房源");
            }
            // Double fangyuanNewMoney = fangyuanEntity.getFangyuanNewMoney();

            if(false){
            }
            else if(fangyuanEntity.getFangyuanNewMoney() == null){
                return R.error(511,"租赁价格/月不能为空");
            }
            else if((fangyuanEntity.getFangyuanKucunNumber() -fangyuanOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - fangyuanEntity.getFangyuanNewMoney()*fangyuanOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            fangyuanOrder.setFangyuanOrderTypes(101); //设置订单状态为已缴纳订金
            fangyuanOrder.setFangyuanOrderTruePrice(fangyuanEntity.getFangyuanNewMoney()*fangyuanOrder.getBuyNumber()); //设置实付价格
            fangyuanOrder.setYonghuId(userId); //设置订单支付人id
            fangyuanOrder.setFangyuanOrderUuidNumber(String.valueOf(new Date().getTime()));
            fangyuanOrder.setInsertTime(new Date());
            fangyuanOrder.setCreateTime(new Date());
                fangyuanEntity.setFangyuanKucunNumber( fangyuanEntity.getFangyuanKucunNumber() -fangyuanOrder.getBuyNumber());
                fangyuanService.updateById(fangyuanEntity);
                fangyuanOrderService.insert(fangyuanOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


    /**
    * 退还订金
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            FangyuanOrderEntity fangyuanOrder = fangyuanOrderService.selectById(id);//当前表service
            Integer buyNumber = fangyuanOrder.getBuyNumber();
            Integer fangyuanId = fangyuanOrder.getFangyuanId();
            if(fangyuanId == null)
                return R.error(511,"查不到该租房房源");
            FangyuanEntity fangyuanEntity = fangyuanService.selectById(fangyuanId);
            if(fangyuanEntity == null)
                return R.error(511,"查不到该租房房源");
            Double fangyuanNewMoney = fangyuanEntity.getFangyuanNewMoney();
            if(fangyuanNewMoney == null)
                return R.error(511,"租房房源价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

                //计算金额
                Double money = fangyuanEntity.getFangyuanNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额



            fangyuanEntity.setFangyuanKucunNumber(fangyuanEntity.getFangyuanKucunNumber() + buyNumber);


            fangyuanOrder.setFangyuanOrderTypes(102);//设置订单状态为已退还订金
            fangyuanOrderService.updateById(fangyuanOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            fangyuanService.updateById(fangyuanEntity);//更新订单中租房房源的信息

            return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer fangyuanCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            FangyuanOrderEntity fangyuanOrder = fangyuanOrderService.selectById(id);
        if(fangyuanOrder == null)
            return R.error(511,"查不到该订单");
        Integer fangyuanId = fangyuanOrder.getFangyuanId();
        if(fangyuanId == null)
            return R.error(511,"查不到该租房房源");

        FangyuanCommentbackEntity fangyuanCommentbackEntity = new FangyuanCommentbackEntity();
            fangyuanCommentbackEntity.setId(id);
            fangyuanCommentbackEntity.setFangyuanId(fangyuanId);
            fangyuanCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            fangyuanCommentbackEntity.setFangyuanCommentbackText(commentbackText);
            fangyuanCommentbackEntity.setInsertTime(new Date());
            fangyuanCommentbackEntity.setReplyText(null);
            fangyuanCommentbackEntity.setUpdateTime(null);
            fangyuanCommentbackEntity.setCreateTime(new Date());
            fangyuanCommentbackService.insert(fangyuanCommentbackEntity);

            fangyuanOrder.setFangyuanOrderTypes(105);//设置订单状态为已评价
            fangyuanOrderService.updateById(fangyuanOrder);//根据id更新
            return R.ok();
    }

    /**
     * 上传合同
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        FangyuanOrderEntity  fangyuanOrderEntity = fangyuanOrderService.selectById(id);
        fangyuanOrderEntity.setFangyuanOrderTypes(103);//设置订单状态为已上传合同
        fangyuanOrderService.updateById( fangyuanOrderEntity);

        return R.ok();
    }


    /**
     * 签订合同
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        FangyuanOrderEntity  fangyuanOrderEntity = fangyuanOrderService.selectById(id);
        fangyuanOrderEntity.setFangyuanOrderTypes(104);//设置订单状态为签订合同
        fangyuanOrderService.updateById( fangyuanOrderEntity);
        return R.ok();
    }

}

