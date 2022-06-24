package com.htc.SoccerApp.model;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="team")
public class Team {
	
	@Id
	private int teamId;
	private String teamName;
	private Date createdDate;
	private Date updatedDate;
	private int participantCount=0;
	@OneToMany(mappedBy="participantId")
	private Set<Participant> participant;
	
	public Team()
	{
		super();
	}


	public Team(int teamId, String teamName, Date createdDate, Date updatedDate, int participantCount) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.participantCount = participantCount;
	}

	public int getTeamId() {
		return teamId;
	}
	
	
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	
	
	public String getTeamName() {
		return teamName;
	}
	
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	public Date getUpdatedDate() {
		return updatedDate;
	}
	
	
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	public Set<Participant> getParticipant() {
		return participant;
	}

	
	public void setParticipant(Set<Participant> participant) {
		this.participant = participant;
	}
	
	
	public int getParticipantCount() {
		return participantCount;
	}

	public void setParticipantCount(int participantCount) {
		this.participantCount = participantCount;
	}


	@Override
	public int hashCode() {
		return Objects.hash(teamId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return teamId == other.teamId;
	}
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}

	
	

}
