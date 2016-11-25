package action.room;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

import entity.Room;
import entity.User;
import service.RoomService;

public class RoomChoose extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String price;
	private String roomType;
	private String direction;
	private String roomStatus;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	private RoomService roomService;

	public RoomService getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		JSONObject JSON_Object = new JSONObject();
		PrintWriter out = response.getWriter();
		JSONArray Json_array = new JSONArray();
		Room room = null;
		List<Room> list = valide();
		System.out.println("list" + list.isEmpty());
		List<Room> rooms = new ArrayList<Room>();
		Iterator<Room> it = list.iterator();
		while (it.hasNext()) {
			room = it.next();
			System.out.println(room.getRoomId());
			if (price.equals("level1") && room.getPrice() < 150) {
				rooms.add(room);
			} else if (price.equals("level2") && room.getPrice() >= 150 && room.getPrice() < 300) {
				rooms.add(room);
			} else if (price.equals("level3") && room.getPrice() >= 300 && room.getPrice() <= 500) {
				rooms.add(room);
			} else if (price.equals("level4") && room.getPrice() > 500) {
				rooms.add(room);
			} else {
				rooms.add(room);
			}
		}
		// 发送数据
		System.out.println("+++");
		Iterator<Room> iterator = rooms.iterator();
		while (iterator.hasNext()) {
			room = iterator.next();
			System.out.println(room.getRoomId());
			JSON_Object.put("roomId", room.getRoomId());
			JSON_Object.put("roomType", room.getRoomType());
			JSON_Object.put("sparelive", room.getSpareLive());
			JSON_Object.put("price", room.getPrice());
			JSON_Object.put("direction", room.getDirection());
			Json_array.add(JSON_Object);
			JSON_Object = new JSONObject();
		}
		JSON_Object.put("content", Json_array.toJSONString());
		out.write(JSON_Object.toString());
		out.flush();
		out.close();
		return SUCCESS;
	}

	public List<Room> price(List<Room> room, String roomType) {
		Iterator<Room> it = room.iterator();
		Room r = null;
		List<Room> rooms = new ArrayList<Room>();
		while (it.hasNext()) {
			if (price.equals("level1")) {
				rooms.add(r);
			} else if (price.equals("level2")) {
				rooms.add(r);
			} else if (price.equals("level3")) {
				rooms.add(r);
			} else if (price.equals("level4")) {
				rooms.add(r);
			} else {
				rooms.add(r);
			}

		}
		return rooms;
	}

	public List<Room> roomType(List<Room> room, String roomType) {
		Iterator<Room> it = room.iterator();
		Room r = null;
		List<Room> rooms = new ArrayList<Room>();
		while (it.hasNext()) {
			r = it.next();
			if (r.getRoomType().equals(roomType)) {
				rooms.add(r);
			}
		}
		return rooms;
	}

	public List<Room> roomStatus(List<Room> room, String roomStatus) {
		Iterator<Room> it = room.iterator();
		Room r = null;
		List<Room> rooms = new ArrayList<Room>();
		while (it.hasNext()) {
			r = it.next();
			if (roomStatus.equals("未入住")) {
				if (r.getLimitLive() == r.getSpareLive()) {
					rooms.add(r);
				}
			} else if (roomStatus.equals("已入住")) {
				if (r.getLimitLive() != r.getSpareLive()) {
					rooms.add(r);
				}
			}
		}
		return rooms;
	}

	// 根据direction,rooType,roomStatus筛选
	public List<Room> valide() {
		if (!direction.isEmpty()) {
			List<Room> rs = roomService.findRoomByDirection(direction);
			System.out.println("dir" + rs.isEmpty());
			// 房间类型，二人间，三人间，四人间
			if (!roomType.isEmpty()) {
				rs = roomType(rs, roomType);
				System.out.println("toomType1" + rs.isEmpty());

				//
				if (!roomStatus.isEmpty()) {
					rs = roomStatus(rs, roomStatus);
					System.out.println("roomStatus" + rs.isEmpty());
					return rs;
				} else {
					System.out.println(rs.isEmpty());
					return rs;
				}

			} else {
				//
				if (roomStatus != null) {
					rs = roomStatus(rs, roomStatus);
					return rs;
				}
				System.out.println("toomType2" + rs.isEmpty());
				return rs;
			}

		} else {
			List<Room> rs = roomService.findAllRooms();
			System.out.println("direction" + rs.isEmpty());
			if (!roomType.isEmpty()) {
				rs = roomType(rs, roomType);
				System.out.println("toomType3" + rs.isEmpty());
				//
				if (!roomStatus.isEmpty()) {
					rs = roomStatus(rs, roomStatus);
					return rs;
				}
				return rs;
			} else {
				//
				if (!roomStatus.isEmpty()) {
					rs = roomStatus(rs, roomStatus);
					return rs;
				}
				System.out.println("toomType4" + rs.isEmpty());
				return rs;
			}

		}

	}
}
