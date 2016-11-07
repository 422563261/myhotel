package entity;

import java.util.Date;

public class Order {
	private int id;
	private StringBuffer orderId;
	private String name;
	private String roomId;
	private int totalMoney;
	private Date start_day;
	private Date final_day;
	private String order_Status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public StringBuffer getOrderId() {
		return orderId;
	}
	public void setOrderId(StringBuffer orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Date getStart_day() {
		return start_day;
	}
	public void setStart_day(Date start_day) {
		this.start_day = start_day;
	}
	public Date getFinal_day() {
		return final_day;
	}
	public void setFinal_day(Date final_day) {
		this.final_day = final_day;
	}
	public String getOrder_Status() {
		return order_Status;
	}
	public void setOrder_Status(String order_Status) {
		this.order_Status = order_Status;
	}
	
	
	
}
