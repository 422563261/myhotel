package action.user;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import service.UserService;

public class UserAction extends ActionSupport{
	private User user;
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String execute() throws Exception {
		if(user.getUsername()!=null){
			System.out.println(user.getUsername());
			System.out.println(user.getIDCard_number());
			userService.save(user);
			return SUCCESS;
		}
		else{
			return "reS";
		}
		
	}

}
