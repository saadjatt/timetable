package com.muet.timetable.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muet.timetable.beans.RoomBean;
import com.muet.timetable.dao.RoomDAO;
import com.muet.timetable.repository.RoomRepository;

@Service
@Transactional
public class RoomDAOImpl  implements RoomDAO{

	@Autowired
	RoomRepository roomRepository;
	
	public RoomBean saveRoom(RoomBean rb) {
		// TODO Auto-generated method stub
		return roomRepository.save(rb);
	}

	public List<RoomBean> findAllRooms() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}

	public RoomBean findOneRoom(Long rid) {
		// TODO Auto-generated method stub
		return roomRepository.findOne(rid);
	}

	public void deleteRoom(RoomBean rb) {
    roomRepository.delete(rb);		
	}

}
