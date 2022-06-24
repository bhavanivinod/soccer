package com.htc.SoccerApp.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="member")
public class Participant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int participantId;
	private String participantName;
	private int age;
    private String gender;
	private String contactNumber;
	private String emailId;
	private String nationality;
	private String userName;
	private String password;
	private int roleId=1;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="teamId")
	Team teamId;
	public Participant()
	{
		
	}
	public Participant(int participantId, String participantName, int age, String gender, String contactNumber,
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
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participant other = (Participant) obj;
		return participantId == other.participantId;
	}
	@Override
	public String toString() {
		return "Participant [participantId=" + participantId + ", participantName=" + participantName + ", age=" + age
				+ ", gender=" + gender + ", contactNumber=" + contactNumber + ", emailId=" + emailId + ", nationality="
				+ nationality + ", userName=" + userName + ", password=" + password + ", roleId=" + roleId + "]";
	}

	

}
