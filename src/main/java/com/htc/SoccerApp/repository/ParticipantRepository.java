package com.htc.SoccerApp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.SoccerApp.model.Participant;
import com.htc.SoccerApp.model.Team;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, Integer>{
	   public Participant findByUserName(String username);
	   public List<Participant> findByTeamId(Team team);

}
