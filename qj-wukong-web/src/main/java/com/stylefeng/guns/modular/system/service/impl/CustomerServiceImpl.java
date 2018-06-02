package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.common.persistence.model.Customer;
import com.stylefeng.guns.common.persistence.dao.CustomerMapper;
import com.stylefeng.guns.modular.system.service.ICustomerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户信息表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-05-06
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {
	
}
