package com.muet.timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muet.timetable.beans.Day;

public interface DayRepository extends JpaRepository<Day, Long>{

}
