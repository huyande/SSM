package cn.itcast.ssm.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.ssm.domain.BaseDict;
import cn.itcast.ssm.domain.Customer;
import cn.itcast.ssm.domain.QueryVo;
import cn.itcast.ssm.service.IBaseDictService;
import cn.itcast.ssm.service.ICustomerService;
import cn.itcast.ssm.utils.PageBean;

@Controller
public class CustomerAction {

	@Resource
	private IBaseDictService baseDictService;
	
	@Resource
	private ICustomerService customerService;
	
	@Value("${sourceCode}")//将资源文件中的基本类型数据注入到指定变量上
	private String sourceCode;
	
	@Value("${industCode}")//将资源文件中的基本类型数据注入到指定变量上
	private String industCode;
	
	@Value("${levelCode}")//将资源文件中的基本类型数据注入到指定变量上
	private String levelCode;
	
	@RequestMapping("/list")
	public String findCustomers(QueryVo queryVo, Model model){
		//1.查询查询条件数据
		List<BaseDict> custIndustrylist = baseDictService.findBaseDictByDictCode(industCode);
		List<BaseDict> custSourcelist = baseDictService.findBaseDictByDictCode(sourceCode);
		List<BaseDict> custLevellist = baseDictService.findBaseDictByDictCode(levelCode);
		//2.将查询条件数据返回
		model.addAttribute("sourceList", custSourcelist);
		model.addAttribute("industryList", custIndustrylist);
		model.addAttribute("levelList", custLevellist);
		//3.查询客户分页数据
		PageBean<Customer> pageBean = customerService.findPageList(queryVo);
		//4.将数据放到model中返回
		model.addAttribute("page", pageBean);
		//5.返回查询条件
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custLevel", queryVo.getCustLevel());
		//跳转界面
		return "customer";
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public Customer edit(Long id){
		//1.根据id查询客户信息
		Customer customer = customerService.findCustomerById(id);
		//2.将客户信息以json形式返回到前台
		return customer;
	}
	
	@RequestMapping("/update")
	public String update(Customer customer){
		customerService.updateCustomer(customer);
		return "forward:/list.action";
	}
	
	@RequestMapping("/delete")
	public String delete(Long id){
		customerService.deleteCustomer(id);
		return "forward:/list.action";
	}
}
