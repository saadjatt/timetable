package com.muet.timetable.dao;

import java.util.List;

import com.muet.timetable.beans.RoomBean;

public interface RoomDAO {

	public RoomBean saveRoom(RoomBean rb);
	
	public List<RoomBean> findAllRooms();
	
	public RoomBean findOneRoom(Long rid);
	
	public void deleteRoom(RoomBean rb);
	
}
