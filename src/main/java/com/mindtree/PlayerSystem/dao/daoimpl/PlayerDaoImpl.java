package com.mindtree.PlayerSystem.dao.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.PlayerSystem.dao.PlayerDao;
import com.mindtree.PlayerSystem.entity.Coach;
import com.mindtree.PlayerSystem.entity.Player;

@Service("playerDao")
@Transactional
public class PlayerDaoImpl implements PlayerDao {

	@PersistenceContext
	public EntityManager entityManager;

	public boolean addPlayer(Player player) {
		this.entityManager.persist(player);

		return true;

	}

	public Player getPlayer(String playerId) {

		Query query = entityManager
				.createQuery("select player from Player player where player.playerId=:playerId");
		query.setParameter("playerId", playerId);
		Player player = (Player) query.getSingleResult();

		return player;
	}

	public List<Player> getAllPlayer() {
		Query query = entityManager
				.createQuery("select p from Player p");

		List<Player> list=query.getResultList();
		return list;
		
	}
	
	public boolean updatePlayer(Player player)
	{
//		Player rPlayer=this.entityManager.find(Player.class, player.getPlayerId());
//		 ruko ye coach kya hai
		
		this.entityManager.persist(player);
		return true;
	}

}
