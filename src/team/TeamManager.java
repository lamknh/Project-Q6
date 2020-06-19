package team;

import java.util.Scanner;

public class TeamManager {
	Team[] tlist = new Team[10];
	int index = 0;
	int id = 1;
	
	public void defaultvalue(){
		tlist[index] = new Team(id, "��ħ�̴�"); id++; index++;
		tlist[index] = new Team(id, "���ɸ԰�"); id++; index++;
		tlist[index] = new Team(id, "��ٰ���"); id++; index++;
		tlist[index] = new Team(id, "�޲۴�"); id++; index++;
	}
		
	public void showTeam() {
		System.out.println("------------------");
		System.out.println(" ID	TEAM �̸�");
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
		System.out.println("<Team �߰�>");
		System.out.println("- ID: " + id);
		System.out.print("- Ÿ��Ʋ: ");
		String title = sc.next();
		tlist[index] = new Team(id, title); index++;
		System.out.printf(">>%s: Team�� �߰��Ͽ����ϴ�.\n", title);
	}

}
