package action.order;


import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

import entity.Order;
import entity.User;
import service.OrderService;

public class OrderAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date startDay;
	private Date finalDay;
	private String orderStatus;
	private int totalMoney;
	private String roomId;
	private OrderService orderService;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void saveOrder() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		JSONObject JSON_Object = new JSONObject();
		User user = (User) session.getAttribute("user");
		Order order = new Order();
		int status;
		order.setName(user.getName());
		order.setStart_day(startDay);
		order.setFinal_day(finalDay);
		order.setRoomId(roomId);
		order.setTotalMoney(totalMoney);
		order.setOrder_Status(orderStatus);
		status = 1;
		JSON_Object.put("status", status);
		PrintWriter out = response.getWriter();
		out.write(JSON_Object.toString());
		out.flush();
		out.close();

	}
	public void getOrder() throws Exception {
		
		
	}

}
