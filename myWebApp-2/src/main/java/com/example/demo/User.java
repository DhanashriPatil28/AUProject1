package com.example.demo;
import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue
	private int userId;
	private String mailId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", mailId=" + mailId + "]";
	}
	
}
