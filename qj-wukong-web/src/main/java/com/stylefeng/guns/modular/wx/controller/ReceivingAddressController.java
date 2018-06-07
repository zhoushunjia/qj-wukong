package com.stylefeng.guns.modular.wx.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.ErrorTip;
import com.stylefeng.guns.core.base.tips.SuccessTip;
import com.stylefeng.guns.modular.wx.model.ReceivingAddress;
import com.stylefeng.guns.modular.wx.service.IReceivingAddressService;

/**
 * 用户收货地址
 */
@Controller
@RequestMapping("/wx/receivingAddress")
public class ReceivingAddressController extends BaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private IReceivingAddressService addressService;

	/**
	 * 获取收货地址列表
	 */
	@RequestMapping(value = "/getAddressList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Object getAddressList(String wechatId) {
		try {
			return new SuccessTip(SUCCESS_CODE, "添加收货地址成功", addressService.getAddressList(wechatId));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("系统异常", e);
		}
		return null;
	}

	/**
	 * 添加收货地址
	 */
	@RequestMapping(value = "/addAddress", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Object addAddress(ReceivingAddress address) {
		try {
			addressService.addAddress(address);
			return new SuccessTip(SUCCESS_CODE, "添加收货地址成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("系统异常", e);
			return new ErrorTip(ERROR_CODE, "系统异常");
		}
	}

	/**
	 * 根据id查询收货地址
	 */
	@RequestMapping(value = "/selectById", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Object selectById(Integer id) {
		try {
			return new SuccessTip(SUCCESS_CODE, "查询成功", addressService.selectById(id));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("系统异常", e);
			return new ErrorTip(ERROR_CODE, "系统异常");
		}
	}

	/**
	 * 根据id查询收货地址
	 */
	@RequestMapping(value = "/udpateById", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Object udpateById(ReceivingAddress address) {
		try {
			addressService.updateAddressById(address);
			return new SuccessTip(SUCCESS_CODE, "修改成功",null); 
		} catch (Exception e) {
			e.printStackTrace();
			log.error("系统异常", e);
			return new ErrorTip(ERROR_CODE, "系统异常");
		}
	}
}
