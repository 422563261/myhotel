package entity;

public class Bed {
	private int id;
	private String bedId;
	private String name;
	private String roomId;
	private int price;
	private String status;
	public Bed() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBedId() {
		return bedId;
	}
	public void setBedId(String bedId) {
		this.bedId = bedId;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Bed(int id, String bedId, String name, String roomId, int price, String status) {

		this.id = id;
		this.bedId = bedId;
		this.name = name;
		this.roomId = roomId;
		this.price = price;
		this.status = status;
	}
}
