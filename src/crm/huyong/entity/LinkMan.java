package crm.huyong.entity;

/**
 * 客户联系人POJO
 * @author huyong
 *
 */
public class LinkMan {
	private String lid;
	private String lname;
	private String lgender;
	private String lphone;
	private String laddress;
	private Customer customer;
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLgender() {
		return lgender;
	}
	public void setLgender(String lgender) {
		this.lgender = lgender;
	}
	public String getLphone() {
		return lphone;
	}
	public void setLphone(String lphone) {
		this.lphone = lphone;
	}
	public String getLaddress() {
		return laddress;
	}
	public void setLaddress(String laddress) {
		this.laddress = laddress;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
