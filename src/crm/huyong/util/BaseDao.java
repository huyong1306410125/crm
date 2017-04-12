package crm.huyong.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import crm.huyong.entity.LinkMan;
import crm.huyong.entity.Visit;

public class BaseDao<T> extends HibernateDaoSupport {
	private Class clazzp;
	
	public BaseDao() {
		
		//获得调用构造方法的当前对象的字节码文件
		Class<? extends BaseDao> clazz = this.getClass();
		
		//获得参数化类型的父类class
		ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
		
		//获得实际参数类型数组
		Type[] types = type.getActualTypeArguments();
		
		//因为我们只有一个泛型,所以取数组的第一个
		this.clazzp = (Class) types[0];
		
	}

	public List<T> findAll(){
		return (List<T>) this.getHibernateTemplate().find("from "+clazzp.getSimpleName());
	}
	
	public T find(String id){
		return (T) this.getHibernateTemplate().get(clazzp, id);
	}
	
	public void add(T t){
		this.getHibernateTemplate().save(t);
	}
	public void update(T t){
		this.getHibernateTemplate().update(t);
	}
	public void delete(T t){
		this.getHibernateTemplate().delete(t);
	}
	
	public int findCount(){
		List<T> list = (List<T>) this.getHibernateTemplate().find("from "+clazzp.getSimpleName());
		if(list != null && list.size() !=0){
			return list.size();
		}
		return 0;
	}
	public List<T> findLinkManByPage(int begin, int pageSize) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(clazzp);
		List<T> list = (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
		return list;
	}
}
