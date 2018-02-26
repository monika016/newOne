package com.mindtree.PlayerSystem.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.PlayerSystem.dao.CoachDao;
import com.mindtree.PlayerSystem.dao.PlayerDao;
import com.mindtree.PlayerSystem.entity.Coach;
import com.mindtree.PlayerSystem.entity.Player;
import com.mindtree.PlayerSystem.service.CoachService;

@Service("coachService")
public class CoachServiceImpl implements CoachService{
	@Autowired
	private CoachDao coachDao;

	public boolean addCoach(Coach coach) {
		this.coachDao.addCoach(coach);
		return true;
	}

	public Coach getCoachById(String coachId) {
		return this.coachDao.getCoach(coachId);
	}

	public List<Coach> getAllCoach() {
		return this.coachDao.getAllCoach();
	}
}
