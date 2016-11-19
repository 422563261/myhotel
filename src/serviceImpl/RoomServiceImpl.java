package serviceImpl;

import java.util.List;

import dao.RoomDao;
import entity.Room;
import service.RoomService;

public class RoomServiceImpl implements RoomService {
	private RoomDao roomDao;

	public RoomDao getRoomDao() {
		return roomDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Override
	public void save(Room room) {
		this.roomDao.saveRoom(room);
	}

	@Override
	public void update(Room room) {
		this.roomDao.updateRoom(room);
	}

	@Override
	public List<Room> findAllRooms() {

		return (List<Room>) this.roomDao.findAllRooms();
	}

}
