package com.timelineplanner.TimeLineMapper.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timelineplanner.TimeLineMapper.model.TimeLine;

@Repository
public interface TimeLineJPARepository extends JpaRepository<TimeLine, Integer>, TimeLineDao {

}