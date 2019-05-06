package com.muet.timetable.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.muet.timetable.beans.Day;
import com.muet.timetable.daoImpl.DayDAOImpl;


@Controller
public class DayController {
	
	 @Autowired
	 DayDAOImpl dayDAOImpl;
//	
	 @RequestMapping(value = "/daypage", method = RequestMethod.GET)
	 public ModelAndView dayPage() {
			ModelAndView model=new ModelAndView("daypage");
			System.out.println("OKzzz");
	        model.addObject("dayList", dayDAOImpl.getRecords());
	        
	        
			return model;
		}
	 
	 @RequestMapping(value = "/day", method = RequestMethod.POST)
	 public ResponseEntity<?> welcome() {
			//ModelAndView model=new ModelAndView("daypage");
			System.out.println("OKzzz get ");
	        //model.addObject("dayList", dayDAOImpl.getRecords());
	        List<Day> list=dayDAOImpl.getRecords();
	        
			return ResponseEntity.ok(list);
		}
		
		
	 
	 
	 
	 
	 
		@PostMapping("/save-day")
		public ResponseEntity<?> saveDay(@ModelAttribute Day day,BindingResult bindingResult,HttpServletRequest httpServletRequest )  {
			dayDAOImpl.addRecord(day);
		return  ResponseEntity.ok("OK");
				
			}
		
		



}
