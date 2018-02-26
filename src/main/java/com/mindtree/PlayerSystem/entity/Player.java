package com.mindtree.PlayerSystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Table(name="Player")
@Entity
public class Player {

	
	@Id
	private String playerId;
	
	@Column
	private String playerName;
	
	@Column
	private int experience;

	
	@ManyToOne(fetch=FetchType.LAZY, cascade =   CascadeType.ALL)
	private Coach coach;
	
	
	public void setCoachForPlayer(Coach coach)
	{
		this.coach=coach;
		if(!coach.getList().contains(this))
		{
			coach.getList().add(this);
		}
	}
	
	
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Player(String playerId, String playerName, int experience) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName
				+ ", experience=" + experience + ", coach=" + coach + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coach == null) ? 0 : coach.hashCode());
		result = prime * result + experience;
		result = prime * result
				+ ((playerId == null) ? 0 : playerId.hashCode());
		result = prime * result
				+ ((playerName == null) ? 0 : playerName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (coach == null) {
			if (other.coach != null)
				return false;
		} else if (!coach.equals(other.coach))
			return false;
		if (experience != other.experience)
			return false;
		if (playerId == null) {
			if (other.playerId != null)
				return false;
		} else if (!playerId.equals(other.playerId))
			return false;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		return true;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	
	
}
