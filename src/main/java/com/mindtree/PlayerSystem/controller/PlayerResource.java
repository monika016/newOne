package com.mindtree.PlayerSystem.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mindtree.PlayerSystem.entity.Coach;
import com.mindtree.PlayerSystem.entity.Player;
import com.mindtree.PlayerSystem.service.CoachService;
import com.mindtree.PlayerSystem.service.PlayerService;

@Component
@Path("/player1")
public class PlayerResource {

	@Autowired(required = true)
	@Qualifier("playerService")
	private PlayerService playerService;

	@Autowired(required = true)
	@Qualifier("coachService")
	private CoachService coachService;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String addPlayer() {

		Player player = new Player();
		System.out.println("gdgfsdg");
		player.setPlayerId("msd");
		player.setPlayerName("m s dhoni");
		player.setExperience(3);
		player.setCoach(null);
		this.playerService.addPlayer(player);

		return "fgdfg";
	}

	@POST
	@Path("/get-all-players")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> getAllPlayer() {

		return this.playerService.getAllPlayer();

	}

	@POST
	@Path("/assignCoach/{coachId}/{playerId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Player assignCoach(@PathParam("coachId") String coachId,
			@PathParam("playerId") String playerId) {

		Coach coach = this.coachService.getCoachById(coachId);
		Player player = this.playerService.getPlayer(playerId);
		player.setCoach(coach);
		this.playerService.updatePlayer(player);
		return player;

	}
}
