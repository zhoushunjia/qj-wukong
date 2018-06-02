package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.common.persistence.model.Customer;
import com.stylefeng.guns.modular.system.service.ICustomerService;

/**
 * 客户信息控制器
 *
 * @author fengshuonan
 * @Date 2018-05-06 01:35:07
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {

    private String PREFIX = "/system/customer/";
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ICustomerService customerService;

    /**
     * 跳转到客户信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "customer.html";
    }

    /**
     * 跳转到添加客户信息
     */
    @RequestMapping("/customer_add")
    public String customerAdd() {
        return PREFIX + "customer_add.html";
    }

    /**
     * 跳转到修改客户信息
     */
    @RequestMapping("/customer_update/{customerId}")
    public String customerUpdate(@PathVariable Integer customerId, Model model) {
        Customer customer = customerService.selectById(customerId);
        model.addAttribute("item",customer);
        LogObjectHolder.me().set(customer);
        return PREFIX + "customer_edit.html";
    }

    /**
     * 获取客户信息列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return customerService.selectList(null);
    }

    /**
     * 新增客户信息
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Customer customer) {
        customerService.insert(customer);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除客户信息
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer customerId) {
        customerService.deleteById(customerId);
        return SUCCESS_TIP;
    }

    /**
     * 修改客户信息
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Customer customer) {
        customerService.updateById(customer);
        return super.SUCCESS_TIP;
    }

    /**
     * 客户信息详情
     */
    @RequestMapping(value = "/detail/{customerId}")
    @ResponseBody
    public Object detail(@PathVariable("customerId") Integer customerId) {
        return customerService.selectById(customerId);
    }
}
