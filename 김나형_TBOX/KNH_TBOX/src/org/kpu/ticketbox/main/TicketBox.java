package org.kpu.ticketbox.main;
import java.util.Scanner;
import org.kpu.ticketbox.cinema.*;

public class TicketBox {
	private FamilyScreen familyScreen;
	private AnimationScreen animationScreen;
	private PremiumScreen premiumScreen;
	
	Scanner scan = new Scanner(System.in);
	
	public void initScreen() {
		//Screen( ��ȭ���� , ��ȭ �ٰŸ� , Ƽ�ϰ��� , �¼� rowMax ), �¼� colMax
		familyScreen = new FamilyScreen ("��Ž�Ʈ ���� ", 
				"���� ������ ������ ��� �Ҹ��� ������ �Ǵ� ���� ", 8000, 10, 10);
		animationScreen = new AnimationScreen ("���� ġ������ ���Ҹ� ", 
				"", 10000, 10, 10);
		premiumScreen = new PremiumScreen ("��ŸƮ�� ",
				"������ �̼ǵ��� ������ ������ �� ��ȭ�Ӱ� ���ָ� �����ϴ� �Ŵ� �Լ� ������������ȣ.", 25000, 5, 5);
	}

	public Screen selectScreen() {
		System.out.println("-------------------");
		System.out.println("- �󿵰� ���� ���� �޴�   -");
		System.out.println("-------------------");
		System.out.println(" 1. ���� ��ȭ 1��");
		System.out.println(" 2. �ִϸ��̼� ��ȭ 2��");
		System.out.println(" 3. �����̾� ��ȭ 3�� (Ŀ��, ���� ����)");
		System.out.println("  ����(1~3)�� ����");
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
			default:
				return null;
		}
	}
}
