package org.kpu.ticketbox.main;
import java.util.Scanner;
import org.kpu.ticketbox.cinema.Screen;

public class TicketBoxMain {
	public static void main(String[] args) {
		TicketBox ticketBox = new TicketBox();
		Scanner scan = new Scanner(System.in);
		Screen screen = null;
		boolean bMainMenu = true; //�󿵰� ���� �޴� ���
		ticketBox.initScreen(); // 3 ���� ��ũ�� ��ü�� ����
		
		while(true) {
			if(bMainMenu) {
				screen = ticketBox.selectScreen();
				if( screen == null ) {
					System.out.print(" �ȳ��� ������ !");
					scan.close();
					System.exit(0);
				}
				bMainMenu = false;
			}
			screen.showScreenMenu();
			System.out.print(" �޴��� �����ϼ��� >> ");
			try {
				int select = scan.nextInt();
				switch(select) {
				case 1 : // ��ũ�� �� ��ȭ ���� ����
					screen.showMovieInfo();
					break;
				case 2 :
					screen.showSeatMap();
					break;
				case 7:
					ticketBox.selectScreen();				
				}
			} catch (Exception e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.exit(0);
			}
		}
	}
}
