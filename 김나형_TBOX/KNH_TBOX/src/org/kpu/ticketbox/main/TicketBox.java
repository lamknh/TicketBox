package org.kpu.ticketbox.main;
import java.util.HashMap;
import java.util.Scanner;
import org.kpu.ticketbox.cinema.*;
import org.kpu.ticketbox.payment.Receipt;
import org.kpu.ticketbox.util.BackupWriter;
import org.kpu.ticketbox.util.Statistics;


public class TicketBox {
	private FamilyScreen familyScreen;
	private AnimationScreen animationScreen;
	private PremiumScreen premiumScreen;
	
	Scanner scan = new Scanner(System.in);
	
	public void initScreen() {
		//Screen( ��ȭ���� , ��ȭ �ٰŸ� , Ƽ�ϰ��� , �¼� rowMax ), �¼� colMax
		familyScreen = new FamilyScreen ("��Ž�Ʈ ����", 
				"���� ������ ������ ��� �Ҹ��� ������ �Ǵ� ���� ", 8000, 10, 10);
		animationScreen = new AnimationScreen ("�׷���Ƽ ����", 
				"���������� ���� �� �������� �������� �̼��� �¸��� ���� �ڹ� ���� �̾߱�", 10000, 10, 10);
		premiumScreen = new PremiumScreen ("��ŸƮ��",
				"������ �̼ǵ��� ������ ������ �� ��ȭ�Ӱ� ���ָ� �����ϴ� �Ŵ� �Լ� ������������ȣ.", 25000, 5, 5);
	}

	public Screen selectScreen() {
		System.out.println("-------------------");
		System.out.println("- �󿵰� ���� ���� �޴�   -");
		System.out.println("-------------------");
		System.out.println(" 1. ���� ��ȭ 1��");
		System.out.println(" 2. �ִϸ��̼� ��ȭ 2��");
		System.out.println(" 3. �����̾� ��ȭ 3�� (Ŀ��, ���� ����)");
		System.out.println(" 9. ������ �޴�");
		System.out.println("  ����(1~3, 9)�� ����");
		System.out.println();
		System.out.print(" �󿵰� ���� : ");
		
		int sel = scan.nextInt();
		switch(sel) {
			case 1:
				return familyScreen;
			case 2:
				return animationScreen;
			case 3:
				return premiumScreen;
			case 9:
				managerMode();
				return null;
			default:
				return null;
		}
	}
	
	public static final String ADMIN_PASSWORD = "admin";
	
	void managerMode() { // ������ ���
		System.out.print("��ȣ �Է�: ");
		String pw = scan.next();
		
		BackupWriter bw = new BackupWriter();
		
		if(pw.equals(ADMIN_PASSWORD)) {
			Screen screen1 = familyScreen;
			Screen screen2 = animationScreen;
			Screen screen3 = premiumScreen;
			
			System.out.println("-------------------");
			System.out.println("---   ������ ���    ---");
			System.out.println("-------------------");
			
			System.out.println("���� ��ȭ�� ���� �Ѿ� : " + Statistics.sum(screen1.getHashMap()));
			System.out.println("�ִϸ��̼� ��ȭ�� ���� �Ѿ� : " + Statistics.sum(screen2.getHashMap()));
			System.out.println("�����̾� ��ȭ�� ���� �Ѿ� : " + Statistics.sum(screen3.getHashMap()));
			System.out.println("��ȭ�� �� Ƽ�� �Ǹŷ� : " + (screen1.getCount() + screen2.getCount() + screen3.getCount()));
			
			String filename = "c:\\temp\\receipt.txt";
			System.out.println(filename + " ��� �����մϴ�.");
			bw.backupFile(filename, screen1.getHashMap());
			System.out.println("���� ��ȭ�� ���� ��� �Ϸ�");
			bw.backupFile(filename, screen2.getHashMap());
			System.out.println("�ִϸ��̼� ��ȭ�� ���� ��� �Ϸ�");
			bw.backupFile(filename, screen3.getHashMap());
			System.out.println("�����̾� ��ȭ�� ���� ��� �Ϸ�");
			
			System.out.println();
			System.out.println("�ȳ��� ������!");
			System.exit(0);
		}
	}
}
