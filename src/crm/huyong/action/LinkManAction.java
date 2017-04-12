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
import crm.huyong.service.LinkManService;

@SuppressWarnings("all")
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	private LinkManService linkManService;
	private LinkMan linkMan = new LinkMan();
	private CustomerService customerService;
	private Integer currentPage;
	private PageBean<LinkMan> pageBean = new PageBean<LinkMan>();
	
	public LinkMan getModel() {
		return linkMan;
	}
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public PageBean<LinkMan> getPageBean() {
		return pageBean;
	}
	
	
	
	public String toAddLinkManPage(){
		List<Customer> list = customerService.findAllCustomer();
		ServletActionContext.getRequest().setAttribute("customerList", list);
		return "addLinkMan";
	}
	
	
	public String findLinkManByPage(){
		pageBean = linkManService.findLinkManByPage(currentPage);
		return "linkManList";
	}
	
	public String findLinkManByName(){
		pageBean = linkManService.findLinkManByName(linkMan.getLname(),currentPage);
		ServletActionContext.getRequest().setAttribute("lname", linkMan.getLname());
		return "likeList";
	}
	
	public String editLinkMan(){
		String lid = linkMan.getLid();
		LinkMan lm = linkManService.findLinkMan(lid);
		List<Customer> list = customerService.findAllCustomer();
		ServletActionContext.getRequest().setAttribute("customerList", list);
		ServletActionContext.getRequest().setAttribute("linkMan", lm);
		return "editLinkMan";
	}
	public String updateLinkMan(){
		linkManService.updateLinkMan(linkMan);
		return "list";
	}
	
	public String deleteLinkMan(){
		linkManService.deleteLinkMan(linkMan);
		return "list";
	}
	
	public String saveLinkMan(){
		linkManService.saveLinkMan(linkMan);
		return "list";
	}
}
