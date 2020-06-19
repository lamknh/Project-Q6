package team;

import show.Showable;

//동일 package 안에는 import 필요 없음
public class Team implements Showable{	
	private int id;
	private String title;
	
	public Team(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	@Override
	public void showData() {
		System.out.printf("%d	%s\n", id, title);
	}
}








