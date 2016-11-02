package action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

public class LoginOutAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		session.setAttribute("user", null);
		JSONObject JSON_Object = new JSONObject();
		int status;
		status=1;
		PrintWriter out = response.getWriter();
		JSON_Object.put("status", status);
		out.print(JSON_Object.toString());
		out.close();
		return SUCCESS;
	}

}
