package com.mindtree.PlayerSystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="Coach")
@Entity
public class Coach {

	@Id
	private String coachId;
	
	@Column
	private String coachName;
	
	@Column
	private int coachRate;
	
	public Coach() {
		super();
		// TODO Auto-generated constructor stub
	}

	@OneToMany(fetch=FetchType.EAGER, orphanRemoval = true, cascade =   CascadeType.ALL,mappedBy="coach")
	private List<Player> list=new ArrayList<Player>();

	public Coach(String coachId, String coachName, int coachRate,
			List<Player> list) {
		super();
		this.coachId = coachId;
		this.coachName = coachName;
		this.coachRate = coachRate;
		this.list = list;
	}

	@Override
	public String toString() {
		return "Coach [coachId=" + coachId + ", coachName=" + coachName
				+ ", coachRate=" + coachRate + ", list=" + list + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coachId == null) ? 0 : coachId.hashCode());
		result = prime * result
				+ ((coachName == null) ? 0 : coachName.hashCode());
		result = prime * result + coachRate;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		Coach other = (Coach) obj;
		if (coachId == null) {
			if (other.coachId != null)
				return false;
		} else if (!coachId.equals(other.coachId))
			return false;
		if (coachName == null) {
			if (other.coachName != null)
				return false;
		} else if (!coachName.equals(other.coachName))
			return false;
		if (coachRate != other.coachRate)
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

	public String getCoachId() {
		return coachId;
	}

	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public int getCoachRate() {
		return coachRate;
	}

	public void setCoachRate(int coachRate) {
		this.coachRate = coachRate;
	}

	public List<Player> getList() {
		return list;
	}

	public void setList(List<Player> list) {
		this.list = list;
	}
	
	public void addToList(Player player) {
		this.list.add(player);
		if(player.getCoach()!=this)
			player.setCoach(this);
	}
	
}
