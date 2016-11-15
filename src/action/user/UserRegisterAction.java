package action.user;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import service.UserService;

public class UserRegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public void register() throws Exception {
<<<<<<< HEAD
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest res = ServletActionContext.getRequest();
		String str = new String(res.getParameter("username").getBytes("iso-8859-1"),"utf-8");
		System.out.println(str);
=======
		
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest re = ServletActionContext.getRequest();
		re.setCharacterEncoding("utf-8");
		System.out.println(username);
		response.setContentType("text/html; charset=utf-8");
		List<User> list = userService.findAll();
>>>>>>> b04e99b0a3a624fd8c57d844e90e0dce2496e8be
		JSONObject JSON_Object = null;
		JSON_Object = new JSONObject();
		JSONArray Json_array = new JSONArray();
		int status;
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		PrintWriter out = response.getWriter();
		
		if (username != null && password != null) {
			status = 1;
			userService.save(user);
			JSON_Object.put("status", status);
<<<<<<< HEAD
			JSON_Object.put("username", str);
=======
			JSON_Object.put("username", username);
			JSON_Object.put("xx", "123");
>>>>>>> b04e99b0a3a624fd8c57d844e90e0dce2496e8be
			Json_array.add(JSON_Object);
			JSON_Object = new JSONObject();
			JSON_Object.put("content", Json_array.toJSONString());
			out.write(JSON_Object.toString());
			System.out.println("aaaaaaaa");
			out.close();
			
		} else {
			status = 0;
			JSON_Object.put("status", status);
			Json_array.add(JSON_Object);
			JSON_Object = new JSONObject();
			JSON_Object.put("content", Json_array.toJSONString());
			out.write(JSON_Object.toString());
			out.close();
		}

	}

}
