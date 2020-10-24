package org.hcl.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String userName;
	private String password;
	private String city;
	private String bloodGroup;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_blood",joinColumns = {@JoinColumn(name="user_id")},
	inverseJoinColumns = {@JoinColumn(name="bid")})
	private Set<BloodGroup> bloodGroups=new HashSet<>();
	public Users() {
		// TODO Auto-generated constructor stub
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public Set<BloodGroup> getBloodGroups() {
		return bloodGroups;
	}
	public void setBloodGroups(Set<BloodGroup> bloodGroups) {
		this.bloodGroups = bloodGroups;
	}
	public void add(BloodGroup bg)
	{
		bloodGroups.add(bg);
	}
}
