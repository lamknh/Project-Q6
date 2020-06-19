package team;

import show.Showable;

//���� package �ȿ��� import �ʿ� ����
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








