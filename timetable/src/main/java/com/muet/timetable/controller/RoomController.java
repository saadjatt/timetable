package com.muet.timetable.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.muet.timetable.beans.RoomBean;
import com.muet.timetable.daoImpl.RoomDAOImpl;

@Controller
public class RoomController {

	 @Autowired
	 RoomDAOImpl roomDAOImpl;
//	

		@RequestMapping("/welcome")
		public ModelAndView welcome() {
			ModelAndView model=new ModelAndView("welcomepage");
	        model.addObject("roomList", roomDAOImpl.findAllRooms());
			return model;
		}
		
		@PostMapping("/save-room")
		public ModelAndView saveRoom(@ModelAttribute RoomBean roomBean,BindingResult bindingResult,HttpServletRequest httpServletRequest) {
			roomDAOImpl.saveRoom(roomBean);
	        return new ModelAndView("redirect:/welcome");
				
			}
		
		
		@RequestMapping(value = "/{id}/delete-room", method = RequestMethod.GET)
	    public ModelAndView deleteRoom(@PathVariable long id) {
			RoomBean rb=roomDAOImpl.findOneRoom(id);
		   	roomDAOImpl.deleteRoom(rb);
	        return new ModelAndView("redirect:/welcome");

	    }
		
		
		@RequestMapping(value = "/{id}/editRoom", method = RequestMethod.GET)
	    public ModelAndView edit(@PathVariable("id") long id) {
		  ModelAndView model = new ModelAndView("edit-room");
	        RoomBean room = roomDAOImpl.findOneRoom(id);
	        model.addObject("room", room);
	        return model;
	    }
	  
		
		@RequestMapping(value = "/update", method = RequestMethod.POST)
	    public ModelAndView update(@ModelAttribute RoomBean roomBean,BindingResult bindingResult,HttpServletRequest httpServletRequest) {
	        RoomBean updatedRoom = roomDAOImpl.findOneRoom(roomBean.getId());
	        updatedRoom.setName(roomBean.getName());
	        updatedRoom.setType(roomBean.getType());
	        roomDAOImpl.saveRoom(updatedRoom);
	        return new ModelAndView("redirect:/welcome");
	    }

		}
	 
	
