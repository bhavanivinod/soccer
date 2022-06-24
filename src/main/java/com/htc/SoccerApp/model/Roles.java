package com.htc.SoccerApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Roles {
		@Id
		private int role;
		private String type;
		public Roles() {
		
		}
		public Roles(int role, String type) {
			super();
			this.role = role;
			this.type = type;
		}
		public int getRole() {
			return role;
		}
		public void setRole(int role) {
			this.role = role;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + role;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Roles other = (Roles) obj;
			if (role != other.role)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Roles [role=" + role + ", type=" + type + "]";
		}
		
}
