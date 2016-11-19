package action.user;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.http.HttpRequest;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import service.UserService;

public class UserSave extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private String cellphone;
	private String name;
	private String sex;
	private String idCard;
 	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		String n = URLDecoder.decode(request.getParameter("name"), "UTF-8");
		User user = (User)session.getAttribute("user");
		if(user!=null){
			user.setCellphone(cellphone);
			user.setSex(sex);
			user.setName(n);
			user.setIDCard_number(idCard);
			this.userService.update(user);
		}
		return SUCCESS;
	}
}
