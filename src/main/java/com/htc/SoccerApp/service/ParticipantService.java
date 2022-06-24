package com.htc.SoccerApp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.htc.SoccerApp.Exception.TaskHandler;
import com.htc.SoccerApp.model.Participant;
import com.htc.SoccerApp.model.Roles;
import com.htc.SoccerApp.model.Team;
import com.htc.SoccerApp.model.User;
import com.htc.SoccerApp.repository.ParticipantRepository;
import com.htc.SoccerApp.repository.RolesRepository;
import com.htc.SoccerApp.repository.TeamRepository;
import com.htc.SoccerApp.repository.UserRepository;

@Service("participantService")
public class ParticipantService {
	
	@Autowired
	ParticipantRepository participantRepository;
	@Autowired
	RolesRepository roleRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	UserRepository userrepository;
	
	public Set<Roles> checkRole(String username) {
		int role_id =0;
		User user = userrepository.findByUserName(username);
        Set<Roles> role = user.getRoles();
        return role;
    }
	
	public int checkUsernameExists(String username) {
		int isPresent =1;
		Optional<Participant> participant=Optional.ofNullable(participantRepository.findByUserName(username));

		if(participant.isEmpty())
		{
			isPresent=0;
		}
        return isPresent;
    }
	
	public int addParticipant(Participant participant,int teamId)
	{
		int result=0;
		Optional<Team> opteam=teamRepository.findById(teamId);
		if(opteam.isPresent())
		{
			Team team = opteam.get();
			int participantCnt=team.getParticipantCount();
			participantCnt=participantCnt+1;
			
			
			Participant partint=participantRepository.findByUserName(participant.getUserName());
			//check participant count exceed 11
			if(participantCnt >= 11)
			{
				throw new TaskHandler("Participant Limit Exceeds", HttpStatus.NOT_FOUND);
			}
			else
			{
					team.setParticipantCount(participantCnt);
					participant.setTeamId(team);
					Set<Roles> rolelist=new HashSet<>();
					if(participantRepository.save(participant)!=null)
					{ 
						int roleId=1;
						
						Optional<Roles> role = roleRepository.findById(1);
						rolelist.add(role.get());
						String userName=participant.getUserName();
						String password=participant.getPassword();
						User userObj = new User();
						userObj.setUserName(userName);
						userObj.setPassword(password);
						userObj.setRoles(rolelist);
//						userObj.setRoleId(roleId);
						userrepository.save(userObj);
						
						result=1;
					}	
				}
							
		}
		return result;
	}
	
	public List<Participant> getParticipantByTeamId(int teamId)
	{
		Optional<Team> opteam=teamRepository.findById(teamId);
		Team team = opteam.get();
		return(List<Participant>) participantRepository.findByTeamId(team);
	}
	public boolean deleteParticipant(int participantId) 
	{
		Optional<Participant> opparticipant=participantRepository.findById(participantId);
		if(opparticipant.isPresent()) {
			participantRepository.deleteById(participantId);;
	        return true;
		}
		else
		{
			throw new TaskHandler("Participant does not exists", HttpStatus.NOT_FOUND);

		}
	}
}
