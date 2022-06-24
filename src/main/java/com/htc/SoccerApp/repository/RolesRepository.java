package com.htc.SoccerApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.SoccerApp.model.Roles;
import com.htc.SoccerApp.model.Team;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

}
