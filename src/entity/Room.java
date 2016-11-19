package entity;

public class Room {
	private int id;
	private String roomId;
	private String roomType;
	private String direction;
	private int limitLive;
	private int spareLive;
	private int price;
	
	public Room() {
	
	}

	public Room(int id, String roomId, String roomType, String direction, int limitLive, int spareLive, int price) {

		this.id = id;
		this.roomId = roomId;
		this.roomType = roomType;
		this.direction = direction;
		this.limitLive = limitLive;
		this.spareLive = spareLive;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getLimitLive() {
		return limitLive;
	}

	public void setLimitLive(int limitLive) {
		this.limitLive = limitLive;
	}

	public int getSpareLive() {
		return spareLive;
	}

	public void setSpareLive(int spareLive) {
		this.spareLive = spareLive;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
