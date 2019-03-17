package cn.itcast.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.ssm.domain.Customer;
import cn.itcast.ssm.domain.QueryVo;
import cn.itcast.ssm.mapper.CustomerMapper;
import cn.itcast.ssm.service.ICustomerService;
import cn.itcast.ssm.utils.PageBean;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Resource
	private CustomerMapper customerMapper;
	
	@Override
	public PageBean<Customer> findPageList(QueryVo queryVo) {
		//1.查询当前页的数据集合
		//1.1计算当前页第一条数据的索引：(当前页-1)*每页条数=当前页第一条数据的索引值
		Integer currentPage = queryVo.getCurrentPage();
		Integer pageSize = queryVo.getPageSize();
		queryVo.setStart((currentPage - 1) * pageSize);
		List<Customer> list = customerMapper.findCurrenPageList(queryVo);
		//2.查询总条数
		Integer totalCount = customerMapper.findCount(queryVo);
		//3.将数据封装到PageBean返回
		PageBean<Customer> pageBean = new PageBean<Customer>();
		pageBean.setList(list);
		pageBean.setTotalCount(totalCount);
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		return pageBean;
	}

	@Override
	public Customer findCustomerById(Long id) {
		return customerMapper.findCustomerById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerMapper.deleteCustomer(id);
	}

}
