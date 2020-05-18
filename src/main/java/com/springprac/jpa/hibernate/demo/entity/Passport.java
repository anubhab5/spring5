package com.springprac.jpa.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String number;

	public Passport() {
	}

	public Passport(long id, String number) {
		super();
		this.id = id;
		this.number = number;
	}

	public Passport(String number) {
		this.number = number;
	}

	public long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String name) {
		this.number = name;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", name=" + number + "]";
	}

}
