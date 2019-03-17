package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.domain.Customer;
import cn.itcast.ssm.domain.QueryVo;

public interface CustomerMapper {

	List<Customer> findCurrenPageList(QueryVo queryVo);

	Integer findCount(QueryVo queryVo);

	Customer findCustomerById(Long id);

	void updateCustomer(Customer customer);

	void deleteCustomer(Long id);

}
