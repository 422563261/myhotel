package action.user;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import service.UserService;

public class UserRegisterAction extends ActionSupport {

	private String username;
	private String password;
	private UserService userService;

	public UserService getUserService() {
		return userService;
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

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {

		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		List<User> list = userService.findAll();
		JSONObject JSON_Object = null;
		JSON_Object = new JSONObject();
		int status;
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		PrintWriter out = response.getWriter();
		if (password != null && password != null) {
			status = 1;
			userService.save(user);
			JSON_Object.put("status", status);
			JSON_Object.put("username", username);
			out.write(JSON_Object.toString());
			out.close();
		} else {
			status = 0;
			JSON_Object.put("status", status);
			out.write(JSON_Object.toString());
			out.close();
		}
		return INPUT;

	}

}
