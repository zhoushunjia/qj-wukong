package com.stylefeng.guns.modular.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.GunsApplication;
import com.stylefeng.guns.common.annotion.BussinessLog;
import com.stylefeng.guns.common.annotion.Permission;
import com.stylefeng.guns.common.constant.Const;
import com.stylefeng.guns.common.constant.dictmap.DictMap;
import com.stylefeng.guns.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.common.exception.BizExceptionEnum;
import com.stylefeng.guns.common.persistence.dao.DictMapper;
import com.stylefeng.guns.common.persistence.model.Dict;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.modular.system.dao.DictDao;
import com.stylefeng.guns.modular.system.dao.CategoryDao;
import com.stylefeng.guns.modular.system.service.IDictService;
import com.stylefeng.guns.modular.system.warpper.DictWarpper;

/**
 * 产品类目
 *
 * @author Huqibo
 * @Date 2017年4月26日 12:55:31
 */
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {

    @Resource
    CategoryDao dategoryDao;

    @Resource
    DictMapper dictMapper;

    @Resource
    IDictService dictService;

    protected final static Logger logger = LoggerFactory.getLogger(GunsApplication.class);

    
    @RequestMapping("/queryDoods")
    @ResponseBody
    public Map<String, Object> queryDoods() {
    	logger.info("查询所有的类别目录 开始：");
    	Map<String,Object> resMap = new HashMap<String,Object>();
    	resMap.put("code", SUCCESS);
    	resMap.put("data", dategoryDao.queryAllGoods("1"));
    	logger.info("查询所有的类别目录结果："+resMap);
        return resMap;
    }
    
    
    @RequestMapping("/queryProductsByCategoryId")
    @ResponseBody
    public Map<String, Object> queryProductsByCategoryId(String categoryId,String nameLike) {
    	logger.info("根据类目查询产品信息开始：",categoryId,nameLike);
    	Map<String,Object> resMap = new HashMap<String,Object>();
    	resMap.put("code", SUCCESS);
    	resMap.put("data", dategoryDao.queryProducts("",nameLike,categoryId,"1","1","1"));
    	logger.info("根据类目查询产品信息结果："+resMap);
        return resMap;
    }
    
    @RequestMapping("/queryAllBanner")
    @ResponseBody
    public Map<String, Object> queryAllBanner() {
    	logger.info("查询顶部banner图：类目id");
    	Map<String,Object> resMap = new HashMap<String,Object>();
    	resMap.put("code", SUCCESS);
    	resMap.put("data", dategoryDao.queryProducts("1","","","1","1","1"));
    	logger.info("查询顶部banner图结果："+resMap);
        return resMap;
    }

}
