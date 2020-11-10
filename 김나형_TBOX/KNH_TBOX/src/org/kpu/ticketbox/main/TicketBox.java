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
		familyScreen = new FamilyScreen ("어거스트 러쉬 ", 
				"눈을 감으면 세상의 모든 소리가 음악이 되는 아이 ", 8000, 10, 10);
		animationScreen = new AnimationScreen ("센과 치히로의 행방불명 ", 
				"", 10000, 10, 10);
		premiumScreen = new PremiumScreen ("스타트렉 ",
				"위험한 미션들을 무사히 수행한 후 평화롭게 우주를 항해하던 거대 함선 엔터프라이즈호.", 25000, 5, 5);
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
