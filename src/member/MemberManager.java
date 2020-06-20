package member;

import java.util.Scanner;
import team.TeamManager;

public class MemberManager {
	Member[] mlist = new Member[50];
	int index = 0;
	int id = 1;
	
	public void defaultvalue(){
		mlist[index] = new Student(id, "ȫ�л�", "��ħ�̴�", "����Ʈ����", 1); id++; index++;
		mlist[index] = new Student(id, "���л�", "���ɸ԰�", "���Ӱ���", 2); id++; index++;
		mlist[index] = new Student(id, "���л�", "��ħ�̴�", "��ǻ�Ͱ���", 3); id++; index++;
		mlist[index] = new Mentor(id, "ȫ����", "��ħ�̴�", "Happy co."); id++; index++;
		mlist[index] = new Mentor(id, "�ڸ���", "��ٰ���", "(��)�ູ"); id++; index++;
		mlist[index] = new Student(id, "���л�", "���ɸ԰�", "��ǻ�Ͱ���", 2); id++; index++;
	}
	
	public void showAll() {
		System.out.println("---------------------------------------------");
		System.out.println("����	ID	�̸�	TEAM	����/ȸ��	�г�");
		System.out.println("---------------------------------------------");
		for (int i = 0; i < index; i++) {
			if(mlist[i].getClass() == Student.class) {
				System.out.print("�л�	");
				((Student)mlist[i]).showData();
			}
			else {
				System.out.print("����	");
				((Mentor)mlist[i]).showData();
			}
		}
		System.out.println("---------------------------------------------");
	}
	public void search() {
		Scanner sc = new Scanner(System.in);
		System.out.print(" - �̸�:");
		String name = sc.next();
		
		System.out.println("<ã�� ���>");
		System.out.println("---------------------------------------------");
		System.out.println("����	ID	�̸�	TEAM	����/ȸ��	�г�");
		System.out.println("---------------------------------------------");
		for(int i = 0; i < index; i++) {
			if(name.equals(mlist[i].getName())) { //���ڿ� �� equals
				if(mlist[i].getClass() == Student.class) {
					System.out.print("�л�	");
					((Student)mlist[i]).showData();
					System.out.println("---------------------------------------------");
					return;
				}
				else {
					System.out.print("����	");
					((Mentor)mlist[i]).showData();
					System.out.println("---------------------------------------------");
					return;
				}
			}
		}
		System.out.println(" - �ش� ����� �����ϴ�");
		System.out.println("---------------------------------------------");
	}
	public void showTeamMember(TeamManager tm) {
		Scanner sc = new Scanner(System.in);
		System.out.println("<��� Team ���>");
		tm.showTeam();
		System.out.print(" - Team ID: ");
		int teamId = sc.nextInt();	
		String team = tm.mapping(teamId);
		System.out.printf("<%s: ��� ���\n>", team);
		System.out.println("---------------------------------------------");
		System.out.println("����	ID	�̸�	TEAM	����/ȸ��	�г�");
		System.out.println("---------------------------------------------");
		for(int i = 0; i < index; i++) {
			if(team.equals(mlist[i].getTeam())) { //���ڿ� �� equals
				if(mlist[i].getClass() == Student.class) {
					System.out.print("�л�	");
					((Student)mlist[i]).showData();
				}
				else {
					System.out.print("����	");
					((Mentor)mlist[i]).showData();
				}
			}
		}
		System.out.println("---------------------------------------------");
	}
		
	public void showStudent() {
		System.out.println("---------------------------------------------");
		System.out.println("ID	�̸�	TEAM	����	�г�");
		System.out.println("---------------------------------------------");
		for (int i = 0; i < index; i++) {
			if(mlist[i].getClass() == Student.class) {
				System.out.print("�л�	");
				((Student)mlist[i]).showData();
			}
		}
		System.out.println("---------------------------------------------");
	}
	public void addStudent(TeamManager tm) {	
		Scanner sc = new Scanner(System.in);
		System.out.println("<�л� ��� �߰�>");
		System.out.println(" - ID: "+id);
		System.out.print(" - �̸�: ");
		String name = sc.next();
		System.out.print(" - ����: ");
		String major = sc.next(); //���ڿ�
		System.out.print(" - �г�: ");
		int year = sc.nextInt();
		
		tm.showTeam();
		System.out.print("- Team ID: ");
		int teamId = sc.nextInt();	
		String team = tm.mapping(teamId);
		mlist[index] = new Student(id, name, team, major, year);
		System.out.printf("=> %s: �л��� �߰��߽��ϴ�.\n", name);
		id++; index++;
	}
	
	
	public void showMentor() {
		System.out.println("---------------------------------------------");
		System.out.println("ID	�̸�	TEAM	ȸ��");
		System.out.println("---------------------------------------------");
		for (int i = 0; i < index; i++) {
			if(mlist[i].getClass() == Mentor.class) {
				System.out.print("����	");
				((Mentor)mlist[i]).showData();
			}
		}
		System.out.println("---------------------------------------------");
	}
	public void addMentor(TeamManager tm) {	
		Scanner sc = new Scanner(System.in);
		System.out.println("<���� ��� �߰�>");
		System.out.println(" - ID: "+id);
		System.out.print(" - �̸�: ");
		String name = sc.next();
		System.out.print(" - ȸ��: ");
		String org = sc.next(); //���ڿ�
		
		tm.showTeam();
		System.out.print("- Team ID: ");
		int teamId = sc.nextInt();	
		String team = tm.mapping(teamId);
		mlist[index] = new Mentor(id, name, team, org);
		System.out.printf("=> %s: ���並 �߰��߽��ϴ�.\n", name);
		id++; index++;
	}
}

