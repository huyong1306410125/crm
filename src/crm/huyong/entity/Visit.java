package crm.huyong.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 客户拜访的实体类
 * @author huyong
 *
 */
@Entity
@Table(name="t_visit",catalog="crm")
public class Visit {
	
	@Id
	@GenericGenerator(name="uuid",strategy="uuid")
	@GeneratedValue(generator="uuid")
	private String vid;
	
	private Date visitTime;
	private String visitAddress;
	private String visitConent;
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="u_uid")
	private User visitUser;
	
	@ManyToOne(targetEntity=Customer.class)
	@JoinColumn(name="c_cid")
	private Customer visitCustomer;

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public Date getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	public String getVisitAddress() {
		return visitAddress;
	}

	public void setVisitAddress(String visitAddress) {
		this.visitAddress = visitAddress;
	}

	public String getVisitConent() {
		return visitConent;
	}

	public void setVisitConent(String visitConent) {
		this.visitConent = visitConent;
	}

	public User getVisitUser() {
		return visitUser;
	}

	public void setVisitUser(User visitUser) {
		this.visitUser = visitUser;
	}

	public Customer getVisitCustomer() {
		return visitCustomer;
	}

	public void setVisitCustomer(Customer visitCustomer) {
		this.visitCustomer = visitCustomer;
	}

	
	
}
