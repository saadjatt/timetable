package com.muet.timetable.controller;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muet.timetable.beans.RoomBean;
import com.muet.timetable.daoImpl.RoomDAOImpl;


	@RestController
	@RequestMapping("/timetable")
	public class RoomRestController {  

		 @Autowired
		 RoomDAOImpl roomDAOImpl;
		

			@RequestMapping("/welcome")
			public String welcome() {
				return "welcomepage";
			}
		 
//		 
		 @PostMapping("/rooms")
		 public RoomBean createRoom(@Valid @RequestBody RoomBean roomBean) {
			 return roomDAOImpl.saveRoom(roomBean);
		 }
		@GetMapping("/rooms")
	    public List<RoomBean> getAllRooms(){
			return roomDAOImpl.findAllRooms();
		}	
		
		@GetMapping("/rooms/{id}")
		public ResponseEntity<RoomBean>getRoomById(@PathVariable(value="id") Long rid){
			RoomBean roomBean=roomDAOImpl.findOneRoom(rid);
			if(roomBean==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(roomBean);
		}
		
		@PutMapping("/rooms/{id}")
		public ResponseEntity<RoomBean> updateRoom(@PathVariable(value="id") Long rid,@Valid @RequestBody RoomBean roomDetails){
			RoomBean roomBean=roomDAOImpl.findOneRoom(rid);
			if(roomBean==null) {
				return ResponseEntity.notFound().build();
			}
	       roomBean.setName(roomDetails.getName());
	       roomBean.setType(roomDetails.getType());
	       roomBean.setCreatedBy(roomDetails.getUpdatedBy());
	       roomBean.setCreatedAt(roomDetails.getCreatedAt());
	       roomBean.setActive(roomDetails.getActive());
	       RoomBean  updateRoom=roomDAOImpl.saveRoom(roomBean);
			return ResponseEntity.ok().body(updateRoom);
	 
		}
		
		@DeleteMapping("/rooms/{id}")
		public ResponseEntity<RoomBean> deleteRoom(@PathVariable(value="id") Long rid){
			RoomBean roomBean=roomDAOImpl.findOneRoom(rid);
			if(roomBean==null) {
				return ResponseEntity.notFound().build();
			}
			roomDAOImpl.deleteRoom(roomBean);
			return ResponseEntity.ok().build();
		}
	}


