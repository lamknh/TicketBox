package org.kpu.ticketbox.main;
import java.util.Scanner;
import org.kpu.ticketbox.cinema.Screen;

public class TicketBoxMain {
	public static void main(String[] args) {
		TicketBox ticketBox = new TicketBox();
		Scanner scan = new Scanner(System.in);
		Screen screen = null;
		boolean bMainMenu = true; //상영관 선택 메뉴 사용
		ticketBox.initScreen(); // 3 개의 스크린 객체를 생성
		
		while(true) {
			if(bMainMenu) {
				screen = ticketBox.selectScreen();
				if( screen == null ) {
					System.out.print(" 안녕히 가세요 !");
					scan.close();
					System.exit(0);
				}
				bMainMenu = false;
			}
			screen.showScreenMenu();
			System.out.print(" 메뉴를 선택하세요 >> ");
			try {
				int select = scan.nextInt();
				switch(select) {
				case 1: // 스크린 상영 영화 정보 보기
					screen.showMovieInfo();
					break;
				case 2:
					screen.showSeatMap();
					break;
				case 3:
					screen.reserveTicket();
					break;
				case 4:
					screen.changeTicket();
					break;
				case 5:
					screen.payment();
				case 7:
					bMainMenu = true;
				}
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				System.exit(0);
			}
		}
	}
}
