package crm.huyong.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import crm.huyong.dao.VisitDao;
import crm.huyong.entity.LinkMan;
import crm.huyong.entity.PageBean;
import crm.huyong.entity.Visit;

@Transactional
public class VisitService {
	private VisitDao visitDao;

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}

	public void addVisit(Visit visit) {
		visitDao.add(visit);
	}

	public Visit findVisit(String vid) {
		return visitDao.find(vid);
	}

	public void updateVisit(Visit visit) {
		visitDao.update(visit);
	}

	public void deleteVisit(Visit findVisit) {
		visitDao.delete(findVisit);
	}

	public PageBean<Visit> findVisitByPage(Integer currentPage) {
		PageBean<Visit> pageBean = new PageBean<Visit>();
		int totalCount = visitDao.findCount();
		int pageSize = 5;
		int totalPage = (totalCount -1 )/pageSize+1;
		int begin = (currentPage-1)*pageSize;
		
		List<Visit> list = visitDao.findLinkManByPage(begin,pageSize);
		
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(list);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}
	
}
