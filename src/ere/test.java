package ere;

import entity.User;
import service.UserService;

public class test {

private UserService userService;



public UserService getUserService() {
	return userService;
}

public void setUserService(UserService userService) {
	this.userService = userService;
}

public static void main(String[] args) {
	User user = new User();
	user.setUsername("1212");
	user.setPassword("asdas");
}
}
