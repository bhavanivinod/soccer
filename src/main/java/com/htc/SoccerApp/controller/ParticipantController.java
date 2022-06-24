package com.htc.SoccerApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.htc.SoccerApp.model.Participant;
import com.htc.SoccerApp.model.Team;
import com.htc.SoccerApp.service.ParticipantService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ParticipantController {
	@Autowired
	private ParticipantService participantService;
	
	   @PostMapping(value="/participant/{teamId}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	   	public String addParticipant(@PathVariable("teamId")int  teamId, @RequestBody Participant participant) {
			if(participantService.addParticipant(participant,teamId)==1) {
				return "{'status': 'success'}";
			}
			else {
				return "{'status': 'fail'}";
			}
		}
	   
	   @GetMapping(value="/participantList/{teamId}",produces=MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<List<Participant>> getParticipantsByTeam(@PathVariable("teamId")int  teamId){
	        List<Participant> participants = participantService.getParticipantByTeamId(teamId);
	        return new ResponseEntity<>(participants,HttpStatus.OK);
	    }
	   @PreAuthorize("hasAuthority('ROLE_ADMIN')")
		@DeleteMapping(value="/participant/{participantId}",produces=MediaType.APPLICATION_JSON_VALUE)
		public boolean DeleteTeam(@PathVariable("participantId")int participantId)
		{
			if( participantService.deleteParticipant(participantId)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		@GetMapping(value="/checkUsername/{username}",produces=MediaType.APPLICATION_JSON_VALUE)
		   public int checkUsername(@PathVariable("username")String  username){
		        int isPresent  = participantService.checkUsernameExists(username);
		        return isPresent;
		    }
	   
}
