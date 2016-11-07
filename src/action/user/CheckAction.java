package action.user;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import service.UserService;

public class CheckAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private UserService userService;

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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void check() throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();
		List<User> list = userService.findAll();
		JSONObject JSON_Object = null;
		JSON_Object = new JSONObject();
		int status;
		User u = new User();
		Iterator<User> it = list.iterator();
		PrintWriter out = response.getWriter();

		while (it.hasNext()) {

			u = it.next();
			if (u.getUsername().equals(username)) {
				status = 0;
				JSON_Object.put("status", status);
				out.write(JSON_Object.toString());
				out.flush();
				out.close();
				
			}

		}
		status = 1;
		JSON_Object.put("status", status);
		out.write(JSON_Object.toString());
		out.flush();
		out.close();
	}

}
