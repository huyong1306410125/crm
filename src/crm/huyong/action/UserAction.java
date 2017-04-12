package crm.huyong.action;

import com.opensymphony.xwork2.ActionSupport;

import crm.huyong.entity.User;
import crm.huyong.service.UserService;

public class UserAction extends ActionSupport {
	private UserService userService;
	private String username;
	private String password;
	private String nikeName;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}
	
	
	public String login(){
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		User loginUser = userService.login(user);
		
		if(loginUser == null){
			return "loginfalse";
		}else{
			return "loginsuccesse";
		}
		
	}
}
