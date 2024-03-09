package com.timelineplanner.TimeLineMapper.service;

import java.util.List;
import java.util.Optional;

import com.timelineplanner.TimeLineMapper.model.TimeLine;

public interface TimeLineServiceInterface {
	
	public List<TimeLine> findAll();
	Optional<TimeLine> findById(int id);
	public TimeLine save(TimeLine timeline);
	public void deleteById(int id);
}
