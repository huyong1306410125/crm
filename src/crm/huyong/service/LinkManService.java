package crm.huyong.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import crm.huyong.dao.LinkManDao;
import crm.huyong.entity.LinkMan;
import crm.huyong.entity.PageBean;

@Transactional
public class LinkManService {
	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	public PageBean<LinkMan> findLinkManByPage(Integer currentPage) {
		PageBean<LinkMan> pageBean = new PageBean<LinkMan>();
		int totalCount = linkManDao.findCount();
		int pageSize = 5;
		int totalPage = (totalCount -1 )/pageSize+1;
		int begin = (currentPage-1)*pageSize;
		
		List<LinkMan> list = linkManDao.findLinkManByPage(begin,pageSize);
		
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(list);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	public PageBean<LinkMan> findLinkManByName(String lname, Integer currentPage) {
		PageBean<LinkMan> pageBean = new PageBean<LinkMan>();
		int totalCount = linkManDao.findCount(lname);
		int pageSize = 5;
		int totalPage = (totalCount -1 )/pageSize+1;
		int begin = (currentPage-1)*pageSize;
		
		List<LinkMan> list = linkManDao.findLinkManByName(lname,begin,pageSize);
		
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(list);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	public void updateLinkMan(LinkMan linkMan) {
		linkManDao.updateLinkMan(linkMan);
	}

	public void deleteLinkMan(LinkMan linkMan) {
		linkManDao.deleteLinkMan(linkMan);
	}

	public void saveLinkMan(LinkMan linkMan) {
		linkManDao.saveLinkMan(linkMan);
	}

	public LinkMan findLinkMan(String lid) {
		return linkManDao.findLinkMan(lid);
	}
}
