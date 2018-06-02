package com.stylefeng.guns.modular.system.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stylefeng.guns.common.persistence.dao.OperationLogMapper;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.system.dao.LogDao;

/**
 * 
 *
 * @author fengshuonan
 * @Date 2017年4月5日 19:45:36
 */
@Controller
public class HomeController extends BaseController {

	private String PREFIX = "/official/system/";

    @Resource
    private OperationLogMapper operationLogMapper;

    @Resource
    private LogDao logDao;
    
    @RequestMapping(value = "/official/contactUs", method = RequestMethod.GET)
    public String contactUs(Model model) {

        return PREFIX + "/contactUs.html";
    }
    @RequestMapping(value = "/official/team", method = RequestMethod.GET)
    public String team(Model model) {

        return PREFIX + "/team.html";
    }
    @RequestMapping(value = "/official/serviceContent", method = RequestMethod.GET)
    public String serviceContent(Model model) {

        return PREFIX + "/serviceContent.html";
    }
    @RequestMapping(value = "/official/FAQ", method = RequestMethod.GET)
    public String FAQ(Model model) {

        return PREFIX + "/FAQ.html";
    }
    @RequestMapping(value = "/official/aboutUs", method = RequestMethod.GET)
    public String aboutUs(Model model) {

        return PREFIX + "/aboutUs.html";
    }
//  ----------------------- 案例  
    @RequestMapping(value = "/official/al/smartCampus", method = RequestMethod.GET)
    public String smartCampus(Model model) {

        return PREFIX + "/al/smartCampus.html";
    }    
    @RequestMapping(value = "/official/al/worfMan", method = RequestMethod.GET)
    public String worfMan(Model model) {

        return PREFIX + "/al/worfMan.html";
    }    
    @RequestMapping(value = "/official/al/tianhao", method = RequestMethod.GET)
    public String tianhao(Model model) {

        return PREFIX + "/al/tianhao.html";
    }         
    @RequestMapping(value = "/official/al/fly", method = RequestMethod.GET)
    public String fly(Model model) {

        return PREFIX + "/al/fly.html";
    }         
    @RequestMapping(value = "/official/al/weCourse", method = RequestMethod.GET)
    public String weCourse(Model model) {

        return PREFIX + "/al/weCourse.html";
    }         
    @RequestMapping(value = "/official/al/vjian", method = RequestMethod.GET)
    public String vjian(Model model) {

        return PREFIX + "/al/vjian.html";
    }         
    @RequestMapping(value = "/official/al/lx", method = RequestMethod.GET)
    public String lx(Model model) {

        return PREFIX + "/al/lx.html";
    }         
    @RequestMapping(value = "/official/al/kitchen", method = RequestMethod.GET)
    public String kitchen(Model model) {

        return PREFIX + "/al/kitchen.html";
    }             
    
}
