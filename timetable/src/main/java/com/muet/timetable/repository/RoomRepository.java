package com.muet.timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muet.timetable.beans.RoomBean;

public interface RoomRepository extends JpaRepository<RoomBean, Long>{
	
}

