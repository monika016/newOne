package com.mindtree.PlayerSystem.dao.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.PlayerSystem.dao.CoachDao;
import com.mindtree.PlayerSystem.entity.Coach;
import com.mindtree.PlayerSystem.entity.Player;

@Service("coachDao")
@Transactional
public class CoachDaoImpl implements CoachDao {

	@PersistenceContext
	public EntityManager entityManager;
	
	
	public boolean addCoach(Coach coach) {
		this.entityManager.persist(coach);

		return true;

	}

	public Coach getCoach(String coachId) {

		Query query = entityManager
				.createQuery("select coach from Coach coach where coach.coachId=:coachId");
		query.setParameter("coachId", coachId);
		Coach  coach = (Coach) query.getSingleResult();

		return coach;
	}

	public List<Coach> getAllCoach() {
		Query query = entityManager
				.createQuery("select p from Player p");

		List<Coach> list=query.getResultList();
		return list;
		
	}
	
	
}
