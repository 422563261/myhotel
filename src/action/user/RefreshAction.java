package action.user;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.User;

public class RefreshAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void refresh() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletResponse responce = ServletActionContext.getResponse();
		JSONObject JSON_Object = new JSONObject();
		PrintWriter out = responce.getWriter();
		User user = (User) session.getAttribute("user");
		int status;
		System.out.println(user.getUsername());
		status = 1;
		JSON_Object.put("username", user.getUsername());
		JSON_Object.put("money", user.getMoney());
		JSON_Object.put("status", status);
		out.write(JSON_Object.toString());
		out.close();

	}

}
