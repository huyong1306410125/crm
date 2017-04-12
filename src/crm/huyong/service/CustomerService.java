package crm.huyong.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import crm.huyong.dao.CustomerDao;
import crm.huyong.entity.Customer;
import crm.huyong.entity.LinkMan;
import crm.huyong.entity.PageBean;

@Transactional
public class CustomerService {
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	public Customer findCustomer(String cid) {
		return customerDao.findCustomer(cid);
	}

	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	public void deleteCustomer(Customer cus) {
		customerDao.deleteCustomer(cus);
	}

	public PageBean<Customer> findCustomerByPage(int currentPage) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		int totalCount = customerDao.findCount();
		int pageSize = 5;
		int totalPage = (totalCount -1 )/pageSize+1;
		int begin = (currentPage-1)*pageSize;
		
		List<Customer> list = customerDao.findCustomerByPage(begin,pageSize);
		
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(list);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	public PageBean<Customer> findCustomerByName(String cname, int currentPage) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		int totalCount = customerDao.findCount(cname);
		int pageSize = 5;
		int totalPage = (totalCount -1 )/pageSize+1;
		int begin = (currentPage-1)*pageSize;
		
		List<Customer> list = customerDao.findCustomerByName(cname,begin,pageSize);
		
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(list);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	public List<Customer> findAllCustomer() {
		return customerDao.findAllCustomer();
	}

}
