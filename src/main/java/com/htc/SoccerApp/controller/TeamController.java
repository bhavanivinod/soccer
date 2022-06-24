package com.htc.SoccerApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.htc.SoccerApp.dto.TeamDto;
import com.htc.SoccerApp.model.Team;
import com.htc.SoccerApp.service.TeamService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	
	   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	   @PostMapping(value="/team", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<Team> addTeam(@Valid @RequestBody TeamDto teamdto)
		{
		   
		   Team team = new Team();
		   team.setTeamId(teamdto.getTeamId());
		   team.setTeamName(teamdto.getTeamName());
		   team.setParticipantCount(teamdto.getParticipantCount());
		   team.setParticipant(teamdto.getParticipant());
		   team.setCreatedDate(teamdto.getCreatedDate());
		   team.setUpdatedDate(teamdto.getUpdatedDate());
		   
		   Team savedTeam=teamService.addTeam(team);
		   	   
		   TeamDto teamResponse = new TeamDto();
		   teamResponse.setTeamId(savedTeam.getTeamId());
		   teamResponse.setTeamName(savedTeam.getTeamName());
		   teamResponse.setParticipantCount(savedTeam.getParticipantCount());
		   teamResponse.setParticipant(savedTeam.getParticipant());
		   teamResponse.setCreatedDate(savedTeam.getCreatedDate());
		   teamResponse.setUpdatedDate(savedTeam.getUpdatedDate());
		   
		   return new ResponseEntity<Team>(HttpStatus.CREATED);	
		}
	   
	    @GetMapping(value="/allteam",produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<Team>> getAllTeam(){
	        List<Team> team = teamService.getAllTeams();
	        return new ResponseEntity<>(team,HttpStatus.OK);
	    }
	    
	    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
		@PutMapping(value="/team/{teamid}",produces=MediaType.APPLICATION_JSON_VALUE)
		public boolean updateTeam(@PathVariable("teamid")int teamid,@RequestBody Team team)
		{
			if( teamService.updateTeam(teamid, team)) {
				return true;
			}
			else {
				return false;
			}
		}
	    
	    
	    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
		@DeleteMapping(value="/team/{teamid}",produces=MediaType.APPLICATION_JSON_VALUE)
		public boolean DeleteTeam(@PathVariable("teamid")int teamid)
		{
			if( teamService.deleteTeam(teamid)) {
				return true;
			}
			else {
				return false;
			}
		}

}
