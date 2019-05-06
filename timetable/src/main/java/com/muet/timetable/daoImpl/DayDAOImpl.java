package com.muet.timetable.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muet.timetable.beans.Day;
import com.muet.timetable.dao.DayDAO;
import com.muet.timetable.repository.DayRepository;


@Service
@Transactional
public class DayDAOImpl implements DayDAO{
	
	@Autowired
	DayRepository dayRepository;

	public Day addRecord(Day rb) {
		// TODO Auto-generated method stub
		return dayRepository.save(rb);
	}

	public List<Day> getRecords() {
		// TODO Auto-generated method stub
		return dayRepository.findAll();
	}

		// TODO Auto-generated method stub
		
	

	public void deleteRecord(Day rb) {
		// TODO Auto-generated method stub
		dayRepository.delete(rb);
	}

	public Day getRecordById(Long id) {
		return dayRepository.getOne(id);
	}
	
	
	
	



}
