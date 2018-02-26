package com.mindtree.PlayerSystem.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.PlayerSystem.dao.PlayerDao;
import com.mindtree.PlayerSystem.entity.Player;
import com.mindtree.PlayerSystem.service.PlayerService;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDao playerDao;

	public boolean addPlayer(Player player) {
		this.playerDao.addPlayer(player);

		return true;

	}

	public Player getPlayer(String playerId) {
		Player player = (Player) this.playerDao.getPlayer(playerId);
		return player;
	}

	public List<Player> getAllPlayer() {
		return this.playerDao.getAllPlayer();

	}

	public boolean updatePlayer(Player player) {
		this.playerDao.updatePlayer(player);
		return true;
	}

}
