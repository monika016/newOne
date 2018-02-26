package com.mindtree.PlayerSystem.service;

import java.util.List;

import com.mindtree.PlayerSystem.entity.Coach;

public interface CoachService {
	public boolean addCoach(Coach coach);

	public Coach getCoachById(String coachId);

	public List<Coach> getAllCoach();
}
