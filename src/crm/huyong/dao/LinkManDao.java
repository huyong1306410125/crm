package crm.huyong.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;

import crm.huyong.entity.LinkMan;

@SuppressWarnings("all")
public class LinkManDao {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public int findCount() {
		List<LinkMan> list = (List<LinkMan>) hibernateTemplate.find("from LinkMan");
		if(list != null && list.size() !=0){
			return list.size();
		}
		return 0;
	}

	
	public List<LinkMan> findLinkManByPage(int begin, int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		detachedCriteria.createCriteria("customer");
		List<LinkMan> list = (List<LinkMan>) hibernateTemplate.findByCriteria(detachedCriteria, begin, pageSize);
		return list;
	}

	public int findCount(String lname) {
		List<LinkMan> list = (List<LinkMan>) hibernateTemplate.find("from LinkMan where lname = ?","%"+lname+"%");
		if(list != null && list.size() !=0){
			return list.size();
		}
		return 0;
	}

	public List<LinkMan> findLinkManByName(String lname, int begin, int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		detachedCriteria.createCriteria("customer");
		detachedCriteria.add(Restrictions.like("lname", "%"+lname+"%"));
		List<LinkMan> list = (List<LinkMan>) hibernateTemplate.findByCriteria(detachedCriteria, begin, pageSize);
		return list;
	}

	public void updateLinkMan(LinkMan linkMan) {
		hibernateTemplate.update(linkMan);
	}

	public void deleteLinkMan(LinkMan linkMan) {
		hibernateTemplate.delete(linkMan);
	}

	public void saveLinkMan(LinkMan linkMan) {
		hibernateTemplate.save(linkMan);
	}

	public LinkMan findLinkMan(String lid) {
		
		return hibernateTemplate.get(LinkMan.class, lid);
	}
}
