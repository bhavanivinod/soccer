package com.htc.SoccerApp.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.htc.SoccerApp.model.Participant;

public class TeamDto {
	
	
	private int teamId;
	@NotEmpty
	@Size(min = 2, message = "Team name should have at least 2 characters")
	private String teamName;
	private Date createdDate;
	private Date updatedDate;
	private int participantCount=0;
	private Set<Participant> participant;
	
	public TeamDto()
	{
		super();
	}



	public TeamDto(int teamId, String teamName, Date createdDate, Date updatedDate, int participantCount) {
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


}
