package org.hcl.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class BloodGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	private String groupName;
	@ManyToMany(mappedBy = "bloodGroups")
	private Set<Users> users=new HashSet<>();
	public BloodGroup() {
		
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Set<Users> getUsers() {
		return users;
	}
	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	public void add(Users user)
	{
		users.add(user);
	}
}
