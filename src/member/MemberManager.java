package member;

import java.util.Scanner;
import team.TeamManager;

public class MemberManager {
	Member[] mlist = new Member[50];
	int index = 0;
	int id = 1;
	
	public void defaultvalue(){
		mlist[index] = new Student(id, "홍학생", "아침이다", "소프트웨어", 1); id++; index++;
		mlist[index] = new Student(id, "김학생", "점심먹고", "게임공학", 2); id++; index++;
		mlist[index] = new Student(id, "박학생", "아침이다", "컴퓨터공학", 3); id++; index++;
		mlist[index] = new Mentor(id, "홍멘토", "아침이다", "Happy co."); id++; index++;
		mlist[index] = new Mentor(id, "박멘토", "놀다가자", "(주)행복"); id++; index++;
		mlist[index] = new Student(id, "노학생", "점심먹고", "컴퓨터공학", 2); id++; index++;
	}
	
	public void showAll() {
		System.out.println("---------------------------------------------");
		System.out.println("구분	ID	이름	TEAM	전공/회사	학년");
		System.out.println("---------------------------------------------");
		for (int i = 0; i < index; i++) {
			if(mlist[i].getClass() == Student.class) {
				System.out.print("학생	");
				((Student)mlist[i]).showData();
			}
			else {
				System.out.print("멘토	");
				((Mentor)mlist[i]).showData();
			}
		}
		System.out.println("---------------------------------------------");
	}
	public void search() {
		Scanner sc = new Scanner(System.in);
		System.out.print(" - 이름:");
		String name = sc.next();
		
		System.out.println("<찾은 멤버>");
		System.out.println("---------------------------------------------");
		System.out.println("구분	ID	이름	TEAM	전공/회사	학년");
		System.out.println("---------------------------------------------");
		for(int i = 0; i < index; i++) {
			if(name.equals(mlist[i].getName())) { //문자열 비교 equals
				if(mlist[i].getClass() == Student.class) {
					System.out.print("학생	");
					((Student)mlist[i]).showData();
					System.out.println("---------------------------------------------");
					return;
				}
				else {
					System.out.print("멘토	");
					((Mentor)mlist[i]).showData();
					System.out.println("---------------------------------------------");
					return;
				}
			}
		}
		System.out.println(" - 해당 멤버는 없습니다");
		System.out.println("---------------------------------------------");
	}
	public void showTeamMember(TeamManager tm) {
		Scanner sc = new Scanner(System.in);
		System.out.println("<모든 Team 목록>");
		tm.showTeam();
		System.out.print(" - Team ID: ");
		int teamId = sc.nextInt();	
		String team = tm.mapping(teamId);
		System.out.printf("<%s: 멤버 목록\n>", team);
		System.out.println("---------------------------------------------");
		System.out.println("구분	ID	이름	TEAM	전공/회사	학년");
		System.out.println("---------------------------------------------");
		for(int i = 0; i < index; i++) {
			if(team.equals(mlist[i].getTeam())) { //문자열 비교 equals
				if(mlist[i].getClass() == Student.class) {
					System.out.print("학생	");
					((Student)mlist[i]).showData();
				}
				else {
					System.out.print("멘토	");
					((Mentor)mlist[i]).showData();
				}
			}
		}
		System.out.println("---------------------------------------------");
	}
		
	public void showStudent() {
		System.out.println("---------------------------------------------");
		System.out.println("ID	이름	TEAM	전공	학년");
		System.out.println("---------------------------------------------");
		for (int i = 0; i < index; i++) {
			if(mlist[i].getClass() == Student.class) {
				System.out.print("학생	");
				((Student)mlist[i]).showData();
			}
		}
		System.out.println("---------------------------------------------");
	}
	public void addStudent(TeamManager tm) {	
		Scanner sc = new Scanner(System.in);
		System.out.println("<학생 멤버 추가>");
		id = 6;
		System.out.println(" - ID: "+id);
		System.out.print(" - 이름: ");
		String name = sc.next();
		System.out.print(" - 전공: ");
		String major = sc.next(); //문자열
		System.out.print(" - 학년: ");
		int year = sc.nextInt();
		
		tm.showTeam();
		System.out.print("- Team ID: ");
		int teamId = sc.nextInt();	
		String team = tm.mapping(teamId);
		mlist[index] = new Student(id, name, team, major, year);
		System.out.printf("=> %s: 학생을 추가했습니다.\n", name);
		id++; index++;
	}
	
	
	public void showMentor() {
		System.out.println("---------------------------------------------");
		System.out.println("ID	이름	TEAM	회사");
		System.out.println("---------------------------------------------");
		for (int i = 0; i < index; i++) {
			if(mlist[i].getClass() == Mentor.class) {
				System.out.print("멘토	");
				((Mentor)mlist[i]).showData();
			}
		}
		System.out.println("---------------------------------------------");
	}
	public void addMentor(TeamManager tm) {	
		Scanner sc = new Scanner(System.in);
		System.out.println("<멘토 멤버 추가>");
		System.out.println(" - ID: "+id);
		System.out.print(" - 이름: ");
		String name = sc.next();
		System.out.print(" - 회사: ");
		String org = sc.next(); //문자열
		
		tm.showTeam();
		System.out.print("- Team ID: ");
		int teamId = sc.nextInt();	
		String team = tm.mapping(teamId);
		mlist[index] = new Mentor(id, name, team, org);
		System.out.printf("=> %s: 멘토를 추가했습니다.\n", name);
		id++; index++;
	}
}

