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

// 	@Test
// 	void contextLoads() {
// 		Assertions.assertEquals(true, teamService.addTeam(new Team(11, "ABC", new Date(), new Date(),0)));
// 	}
	
	@Test
	void contextLoads1() {
		Assertions.assertEquals(new Team(12, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1),teamService.addTeam(new Team(12, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1)));

	}
	
	@Test
	void contextLoads3() {
		Assertions.assertEquals(new Team(21, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1),teamService.addTeam(new Team(21, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1)));

	}
	
	@Test
	void contextLoads4() {
		Assertions.assertEquals(new Team(20, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1),teamService.addTeam(new Team(20, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1)));

	}
	
	@Test
	void contextLoads5() {
		Assertions.assertEquals(new Team(17, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1),teamService.addTeam(new Team(17, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1)));

	}
	
	@Test
	void contextLoads6() {
		Assertions.assertEquals(new Team(16, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1),teamService.addTeam(new Team(16, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1)));

	}
	
	@Test
	void contextLoads7() {
		Assertions.assertEquals(new Team(12, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1),teamService.addTeam(new Team(12, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1)));

	}
	
	@Test
	void contextLoads8() {
		Assertions.assertEquals(new Team(15, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1),teamService.addTeam(new Team(15, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1)));

	}
	
	@Test
	void contextLoads9() {
		Assertions.assertEquals(new Team(13, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1),teamService.addTeam(new Team(13, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1)));

	}
	
	@Test
	void contextLoads10() {
		Assertions.assertEquals(new Team(14, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1),teamService.addTeam(new Team(14, "ABC", new Date(2002, 02, 02), new Date(2002, 02, 02),1)));

	}
	


}
