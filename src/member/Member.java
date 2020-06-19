package member;

import show.Showable;

public abstract class Member implements Showable{ //추상클래스
	private int id;
	private String name;
	private String team;
	
	public Member(int id, String name, String team) {
		this.id = id;
		this.name = name;
		this.team = team;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTeam() {
		return team;
	}
	
	public void showData() {
		System.out.println(id+"\t"+name);
	}
}

class Student extends Member {
	private String major;
	private int year;
	
	public Student(int id, String name, String team, String major, int year) {
		super(id, name, team);
		this.major = major;
		this.year = year;
	}
	
	public void showData() {
		System.out.println(getId()+"\t"+getName()+"\t"+getTeam()+'\t'+getMajor()+'\t'+getYear());
	}
	
	public String getMajor() {
		return major;
	}
	
	public int getYear() {
		return year;
	}
}

class Mentor extends Member {
	private String org;
	
	public Mentor(int id, String name, String team, String company) {
		super(id, name, team);
		this.org = company;
	}
	
	public void showData() {
		System.out.println(getId()+"\t"+getName()+"\t"+getTeam()+'\t'+org);
	}
	
	
	public String getOrg() {
		return org;
	}
}

