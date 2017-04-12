   package crm.huyong.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import crm.huyong.entity.User;

@SuppressWarnings("all")
public class UserDao {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public User login(User user) {
		List<User> list = (List<User>) hibernateTemplate.find
				("from User where username = ? and password =?", user.getUsername(),user.getPassword());
		
		if(list != null && list.size() != 0){
			return list.get(0);
		}else{
			return null;
		}
	}

	public List<User> findAllUser() {
		return (List<User>) hibernateTemplate.find("from User");
	}
	
}
