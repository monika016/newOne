package com.mindtree.PlayerSystem.dao;

import java.util.List;

import javax.persistence.Query;

import com.mindtree.PlayerSystem.entity.Coach;

public interface CoachDao {
	public boolean addCoach(Coach coach);

	public Coach getCoach(String coachId);

	public List<Coach> getAllCoach();

}
