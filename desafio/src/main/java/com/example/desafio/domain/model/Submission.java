package com.example.desafio.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SUBMISSION")
public class Submission implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "challenge_id", nullable = false)
	private Challenge challenge;
	@Column(name = "SCORE")
	private Float score;
	@Column(name = "CREATED_AT")
	private LocalDateTime createdAt;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Challenge getChallenge() {
		return challenge;
	}
	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((challenge == null) ? 0 : challenge.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Submission other = (Submission) obj;
		if (challenge == null) {
			if (other.challenge != null)
				return false;
		} else if (!challenge.equals(other.challenge))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
}
