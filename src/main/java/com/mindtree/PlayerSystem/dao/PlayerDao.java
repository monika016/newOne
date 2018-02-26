package com.mindtree.PlayerSystem.dao;

import java.util.List;

import com.mindtree.PlayerSystem.entity.Player;

public interface PlayerDao {
	public boolean addPlayer(Player player);

	public Player getPlayer(String playerId);

	public List<Player> getAllPlayer();

	public boolean updatePlayer(Player player);
}
