package com.accolite.hibernate.hibernate2;

import javax.persistence.Id;
import javax.persistence.*;

@Entity(name = "Person")
@Table(name = "Person_table")
//@Column(name="PRIMARY_KEY_ID")
public class Person {
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@Column(name = "address", unique = true)
	private String address;
	
    public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
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
}
