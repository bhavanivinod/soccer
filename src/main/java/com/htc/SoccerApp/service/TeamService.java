package com.htc.SoccerApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.htc.SoccerApp.Exception.TaskHandler;
import com.htc.SoccerApp.model.Team;
import com.htc.SoccerApp.repository.TeamRepository;

@Service("teamService")
public class TeamService {
	@Autowired
	TeamRepository teamRepository;
	
	public Team addTeam(Team team) {
		
		if(teamRepository.save(team) != null)
		{
			return teamRepository.save(team);
		}
		else
		{
			throw new TaskHandler("Team details cannot be add", HttpStatus.NOT_FOUND);
		}
	}
	
	public List<Team> getAllTeams()
	{
		return(List<Team>) teamRepository.findAll();
	}
	
	public boolean updateTeam(int teamId,Team Teamobj) 
	{
		Optional<Team> oppub=teamRepository.findById(teamId);
		if(oppub.isPresent()) {
			teamRepository.save(Teamobj);
	    return true;
		}
		throw new TaskHandler("Team details cannot be found", HttpStatus.NOT_FOUND);
	}
	
	public boolean deleteTeam(int teamId) 
	{
		Optional<Team> oppub=teamRepository.findById(teamId);
		if(oppub.isPresent()) {
			teamRepository.deleteById(teamId);;
	        return true;
		}
		throw new TaskHandler("Team details cannot be found", HttpStatus.NOT_FOUND);
	}
}
