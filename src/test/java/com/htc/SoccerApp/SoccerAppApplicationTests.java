package com.htc.SoccerApp;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.htc.SoccerApp.model.Team;
import com.htc.SoccerApp.service.TeamService;

@SpringBootTest
class SoccerAppApplicationTests {
	
	@Autowired
	private TeamService teamService;

	@Test
	void contextLoads() {
		Assertions.assertEquals(true, teamService.addTeam(new Team(11, "ABC", new Date(), new Date(),0)));
	}

}
