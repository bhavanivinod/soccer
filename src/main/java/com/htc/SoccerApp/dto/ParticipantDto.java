package com.htc.SoccerApp.dto;

import java.util.Objects;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.htc.SoccerApp.model.Team;

public class ParticipantDto {
	
	private int participantId;
	@NotEmpty
	@Size(min = 2, message = "user name should have at least 2 characters")
	private String participantName;
	@NotEmpty
	private int age;
	@NotEmpty
    private String gender;
	@NotEmpty
	private String contactNumber;
	@Email
	private String emailId;
	@NotEmpty
	private String nationality;
	private String userName;
	@NotEmpty
	@Size(min = 8, message = "password should have at least 8 characters")
	private String password;
	private int roleId=1;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="teamId")
	Team teamId;
	
	public ParticipantDto()
	{
		super();
	}
	
	public ParticipantDto(int participantId, String participantName, int age, String gender, String contactNumber,
			String emailId, String nationality, String userName, String password, int roleId) {
		super();
		this.participantId = participantId;
		this.participantName = participantName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.nationality = nationality;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId=1;
	}
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public String getParticipantName() {
		return participantName;
	}
	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	
	public Team getTeamId() {
		return teamId;
	}
	public void setTeamId(Team teamId) {
		this.teamId = teamId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(participantId);
	}

	
	

}
