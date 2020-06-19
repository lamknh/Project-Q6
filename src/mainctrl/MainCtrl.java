package mainctrl;

import java.util.Scanner;
import member.MemberManager;
import team.TeamManager;

public class MainCtrl {

	public static void main(String[] args) {
		MemberManager mem = new MemberManager();
		mem.defaultvalue();
		
		MainMenu mm = new MainMenu();
		mm.showMenu();
		
		TeamManager tm = new TeamManager();
		tm.defaultvalue();
		
		Scanner sc = new Scanner(System.in);
		int sel = sc.nextInt();
		
		while (sel != 0) {
			switch (sel){
			case 1:
				mem.addStudent(tm);
				break;
			case 2:
				mem.showStudent();
				break;
			case 3:
				mem.addMentor(tm);
				break;
			case 4:
				mem.showMentor();
				break;
			case 5:
				mem.search();
				break;
			case 6:			
				mem.showAll();
				break;
			case 7:
				tm.addTeam();
				break;
			case 8:
				tm.showTeam();
				break;
			case 9:
				mem.showTeamMember(tm);
				break;
			case 0:
				System.exit(0);
				return;
			}
			mm.showMenu();
			sel = sc.nextInt();
		}
	}

}
