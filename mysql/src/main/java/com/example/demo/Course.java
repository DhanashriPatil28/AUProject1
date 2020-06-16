package com.example.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Courses")
public class Course implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/* The @Id annotation specifies the primary key of an entity and 
	 * the @GeneratedValue provides for the specification of generation strategies for the values of primary keys.
	 */
	public int id;
	
	private String name;
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
