package crm.huyong.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import crm.huyong.entity.Customer;
import crm.huyong.entity.PageBean;
import crm.huyong.entity.User;
import crm.huyong.entity.Visit;
import crm.huyong.service.CustomerService;
import crm.huyong.service.UserService;
import crm.huyong.service.VisitService;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{
	private VisitService visitService;
	private CustomerService customerService;
	private UserService userService;
	private Visit visit = new Visit();
	private PageBean<Visit> pageBean = new PageBean<Visit>();
	
	private Integer currentPage;
	
	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	public Visit getModel() {
		return visit;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public PageBean<Visit> getPageBean() {
		return pageBean;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
	public String toAddVisitPage(){
		List<Customer> customerList = customerService.findAllCustomer();
		List<User> userList = userService.findAllUser();
		ServletActionContext.getRequest().setAttribute("customerList", customerList);
		ServletActionContext.getRequest().setAttribute("userList", userList);
		return "toAddVisitPage";
	}
	
	public String addVisit(){
		visitService.addVisit(visit);
		return "list";
	}
	
	public String editVisit(){
		Visit findVisit = visitService.findVisit(visit.getVid());
		List<Customer> customerList = customerService.findAllCustomer();
		List<User> userList = userService.findAllUser();
		
		
		ServletActionContext.getRequest().setAttribute("visit", findVisit);
		ServletActionContext.getRequest().setAttribute("customerList", customerList);
		ServletActionContext.getRequest().setAttribute("userList", userList);
		return "editVisit";
	}
	
	public String updateVisit(){
		visitService.updateVisit(visit);
		return "list";
	}
	
	public String deleteVisit(){
		Visit findVisit = visitService.findVisit(visit.getVid());
		visitService.deleteVisit(findVisit);
		
		return "list";
	}
	
	public String findVisitByPage(){
		pageBean = visitService.findVisitByPage(currentPage);
		return "visitList";
	}
	
}