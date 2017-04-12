package crm.huyong.entity;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 客户POJO类
 * @author huyong
 *
 */

public class Customer {
	 private String cid;
	 private String cname;
	 private String clevel;
	 private String csource;
	 private String caddress;
	 private String cphone;
	 private Set<LinkMan> linkMan;
	 private Set<Visit> cVisit;
	 
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getClevel() {
		return clevel;
	}
	public void setClevel(String clevel) {
		this.clevel = clevel;
	}
	public String getCsource() {
		return csource;
	}
	public void setCsource(String csource) {
		this.csource = csource;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCid() {
		return cid;
	}
	
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public Set<LinkMan> getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(Set<LinkMan> linkMan) {
		this.linkMan = linkMan;
	}
	public Set<Visit> getcVisit() {
		return cVisit;
	}
	public void setcVisit(Set<Visit> cVisit) {
		this.cVisit = cVisit;
	}
	
}
