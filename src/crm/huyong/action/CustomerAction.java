package crm.huyong.action;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import crm.huyong.entity.Customer;
import crm.huyong.entity.LinkMan;
import crm.huyong.entity.PageBean;
import crm.huyong.service.CustomerService;
/**
 * 客户模块action
 * @author huyong
 *
 */
@SuppressWarnings("all")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private CustomerService customerService;
	private PageBean<Customer> pageBean = new PageBean<Customer>();
	private Customer customer = new Customer();
	private	Integer currentPage;
	
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public PageBean<Customer> getPageBean() {
		return pageBean;
	}
	
	public Customer getModel() {
		return customer;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
	public String addCustomer(){
		customerService.addCustomer(customer);
		return "list";
	}
	
	public String findCustomerByPage(){
		pageBean = customerService.findCustomerByPage(currentPage);
		return "customerList";
	}
	
	public String editCustomer(){
		String cid = customer.getCid();
		Customer cus = customerService.findCustomer(cid);
		ServletActionContext.getRequest().setAttribute("customer", cus);
		return "editCustomer";
	}
	
	public String updateCustomer(){
		customerService.updateCustomer(customer);
		return "list";
	}
	
	public String deleteCustomer(){
		String cid = customer.getCid();
		Customer cus = customerService.findCustomer(cid);
		customerService.deleteCustomer(cus);
		return "list";
	}
	
	public String findCustomerByName(){
		pageBean = customerService.findCustomerByName(customer.getCname(),currentPage);
		ServletActionContext.getRequest().setAttribute("cname", customer.getCname());
		return "likeList";
	}

	
}
