package crm.huyong.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;

import crm.huyong.entity.Customer;
import crm.huyong.entity.LinkMan;


@SuppressWarnings("all")
public class CustomerDao {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void addCustomer(Customer customer) {
		hibernateTemplate.save(customer);
	}

	public List<Customer> findAllCustomer() {
		List<Customer> customerList = (List<Customer>)hibernateTemplate.find("from Customer");
		return customerList;
	}

	public Customer findCustomer(String cid) {
		return hibernateTemplate.get(Customer.class,cid);
	}

	public void updateCustomer(Customer customer) {
		hibernateTemplate.update(customer);
	}

	public void deleteCustomer(Customer cus) {
		hibernateTemplate.delete(cus);
	}

	public int findCount() {
		List<Customer> list = (List<Customer>) hibernateTemplate.find("from Customer");
		if(list != null && list.size()!= 0){
			return list.size();
		}
		return 0;
	}

	public List<Customer> findCustomerByPage(int begin, int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = (List<Customer>) hibernateTemplate.findByCriteria(detachedCriteria, begin, pageSize);
		
		return list;
	}

	

	
	public int findCount(String cname) {
		List<Customer> list = (List<Customer>) hibernateTemplate.find("from Customer where cname like ?","%"+cname+"%");
		if(list != null && list.size()!= 0){
			return list.size();
		}
		return 0;
	}

	public List<Customer> findCustomerByName(String cname, int begin, int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		detachedCriteria.add(Restrictions.like("cname", "%"+cname+"%"));
		List<Customer> list = (List<Customer>) hibernateTemplate.findByCriteria(detachedCriteria, begin, pageSize);
		
		return list;
	}

	
	
}
