package com.muet.timetable.dao;

import java.util.List;

import com.muet.timetable.beans.Day;

public interface DayDAO {

	public Day addRecord(Day rb);
	
	public List<Day> getRecords();
	
	public Day getRecordById(Long id);
	
	public void deleteRecord(Day rb);
	
}
