package com.timelineplanner.TimeLineMapper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timelineplanner.TimeLineMapper.DAO.TimeLineDao;
import com.timelineplanner.TimeLineMapper.model.TimeLine;

@Service
public class TimeLineService implements TimeLineServiceInterface {
	
	@Autowired
	private TimeLineDao dao;	
	
	@Override
	public List<TimeLine> findAll() {
		return dao.findAll();
	}

	@Override
	public Optional<TimeLine> findById(int id) {
		return dao.findById(id);
	}

	@Override
	public TimeLine save(TimeLine timeline) {
		return dao.save(timeline);
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
		return;
	}

}
