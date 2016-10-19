package action.user;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import net.sf.json.JSONObject;
import service.UserService;

public class UserAction extends ActionSupport {
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
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<User> list = userService.findAll();
		User u = new User();
		Iterator<User> it = list.iterator();
	
		while (it.hasNext()) {
			u=it.next();
			if (user.getUsername().equals(u.getUsername())&& user.getPassword().equals(u.getPassword())) {
				session.setAttribute("status", "1");
				return SUCCESS;
			}
		}
		session.setAttribute("status", "0");
		return INPUT;
		
	}

}
