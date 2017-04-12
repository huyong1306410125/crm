package crm.huyong.entity;

import java.util.Set;

public class User {
	private Integer uid;
	private String username;
	private String password;
	private String nikeName;
	private Set<Visit> uVisit;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNikeName() {
		return nikeName;
	}
	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}
	public Set<Visit> getuVisit() {
		return uVisit;
	}
	public void setuVisit(Set<Visit> uVisit) {
		this.uVisit = uVisit;
	}
	
	
}
