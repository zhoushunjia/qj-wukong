package com.stylefeng.guns.modular.wx.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stylefeng.guns.common.persistence.model.Customer;
import com.stylefeng.guns.common.persistence.model.User;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.exception.GunsExceptionEnum;

/**
 * 
 * @author zhou
 *
 */
@Controller
@RequestMapping("/wx/receivingAddress")
public class ReceivingAddressController extends BaseController {

	//页面前缀
	private String PREFIX = "/official";


    
    /**
     * 查询列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
    	List<User>  list = new ArrayList<User>();
    	User user1 = new User();
    	user1.setId(1);
    	user1.setName("小明");
        return list;
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Customer customer) {
//        customerService.insert(customer);
        return super.SUCCESS_TIP;
    }
    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer customerId) {
//        customerService.deleteById(customerId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Customer customer) {
//        customerService.updateById(customer);
        return super.SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{id}")
    @ResponseBody
    public Object detail(@PathVariable("id") Integer customerId) {
    	User user1 = new User();
    	user1.setId(1);
    	user1.setName("小明");
        return user1;
    }
    
    /**
     * 错误
     * 80-成功
     * 90-错误
     */
    @RequestMapping(value = "/error")
    @ResponseBody
    public ErrorTip error() {
    	 return new ErrorTip(8010, "运行报错");
    }
}
