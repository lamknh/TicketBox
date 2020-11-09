package org.kpu.ticketbox.main;
import java.util.Scanner;
import org.kpu.ticketbox.cinema.*;

public class TicketBox {
	private FamilyScreen familyScreen;
	private AnimationScreen animationScreen;
	private PremiumScreen premiumScreen;
	
	Scanner scan = new Scanner(System.in);
	
	public void initScreen() {
		//Screen( 영화제목 , 영화 줄거리 , 티켓가격 , 좌석 rowMax ), 좌석 colMax
		familyScreen = new FamilyScreen ("어바웃 타임 ", 
				"모태솔로 팀은 성인이 된 날 , 아버지로부터 ", 8000, 10, 10);
		animationScreen = new AnimationScreen ("센과 치히로의 행방불명 ", 
				"인간에게는 금지된 신들의 세계로 오게 된 치히로 .", 10000, 10, 10);
		premiumScreen = new PremiumScreen ("스타트렉 ",
				"세계 각국의 정부와 경제가 완전히 붕괴된 미래가 다가온다 .", 25000, 5, 5);
	}

	public Screen selectScreen() {
		System.out.println("-------------------");
		System.out.println("- 상영관 선택 메인 메뉴   -");
		System.out.println("-------------------");
		System.out.println(" 1. 가족 영화 1관");
		System.out.println(" 2. 애니메이션 영화 2관");
		System.out.println(" 3. 프리미엄 영화 3관 (커피, 케익 제공)");
		System.out.println("  선택(1~3)의 종료");
		System.out.println();
		System.out.print(" 상영관 선택 : ");
		
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
