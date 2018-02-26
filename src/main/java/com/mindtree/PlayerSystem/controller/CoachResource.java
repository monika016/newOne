package com.mindtree.PlayerSystem.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
@Path("/coach")
public class CoachResource {

	@Autowired(required=true)
	@Qualifier("coachService")
	private CoachService coachService;
	

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
 	@Produces(MediaType.TEXT_HTML)
	public String addCoach(Coach coach)
	{
		
		
		this.coachService.addCoach(coach);
		
		return "done";
	}
	
	
	
	
	
}
