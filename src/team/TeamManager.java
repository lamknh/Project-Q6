package team;

import java.util.Scanner;

public class TeamManager {
	Team[] tlist = new Team[10];
	int index = 0;
	int id = 1;
	
	public void defaultvalue(){
		tlist[index] = new Team(id, "아침이다"); id++; index++;
		tlist[index] = new Team(id, "점심먹고"); id++; index++;
		tlist[index] = new Team(id, "놀다가자"); id++; index++;
		tlist[index] = new Team(id, "꿈꾼다"); id++; index++;
	}
		
	public void showTeam() {
		System.out.println("------------------");
		System.out.println(" ID	TEAM 이름");
		System.out.println("------------------");	
		for (int i = 0; i < index; i++) {
			tlist[i].showData();
		}
		System.out.println("------------------");	
	}
	
	public String mapping(int sel) {
		index = id;
		for (int i = 0; i < index; i++) {
			if (tlist[i].getId() == sel) {
				return tlist[i].getTitle();
			}
		}
		return "-";
	}
	
	public void addTeam() {
		Scanner sc = new Scanner(System.in);
		System.out.println("<Team 추가>");
		System.out.println("- ID: " + id);
		System.out.print("- 타이틀: ");
		String title = sc.next();
		tlist[index] = new Team(id, title); index++;
		System.out.printf(">>%s: Team을 추가하였습니다.\n", title);
	}

}
