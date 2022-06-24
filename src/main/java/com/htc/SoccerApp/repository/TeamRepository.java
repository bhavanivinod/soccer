package com.htc.SoccerApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.htc.SoccerApp.model.Team;


@Repository
public interface TeamRepository  extends CrudRepository<Team, Integer> {

}
