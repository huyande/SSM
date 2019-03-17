package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Customer;
import cn.itcast.ssm.domain.QueryVo;
import cn.itcast.ssm.utils.PageBean;

public interface ICustomerService {

	PageBean<Customer> findPageList(QueryVo queryVo);

	Customer findCustomerById(Long id);

	void updateCustomer(Customer customer);

	void deleteCustomer(Long id);

}
