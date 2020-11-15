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
		//Screen( 영화제목 , 영화 줄거리 , 티켓가격 , 좌석 rowMax ), 좌석 colMax
		familyScreen = new FamilyScreen ("어거스트 러쉬", 
				"눈을 감으면 세상의 모든 소리가 음악이 되는 아이 ", 8000, 10, 10);
		animationScreen = new AnimationScreen ("그래비티 폴즈", 
				"수수께끼로 가득 찬 마을에서 벌어지는 미수와 태리의 엽기 코믹 모험 이야기", 10000, 10, 10);
		premiumScreen = new PremiumScreen ("스타트렉",
				"위험한 미션들을 무사히 수행한 후 평화롭게 우주를 항해하던 거대 함선 엔터프라이즈호.", 25000, 5, 5);
	}

	public Screen selectScreen() {
		System.out.println("-------------------");
		System.out.println("- 상영관 선택 메인 메뉴   -");
		System.out.println("-------------------");
		System.out.println(" 1. 가족 영화 1관");
		System.out.println(" 2. 애니메이션 영화 2관");
		System.out.println(" 3. 프리미엄 영화 3관 (커피, 케익 제공)");
		System.out.println(" 9. 관리자 메뉴");
		System.out.println("  선택(1~3, 9)외 종료");
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
			case 9:
				managerMode();
				return null;
			default:
				return null;
		}
	}
	
	public static final String ADMIN_PASSWORD = "admin";
	
	void managerMode() { // 관리자 기능
		System.out.print("암호 입력: ");
		String pw = scan.next();
		
		BackupWriter bw = new BackupWriter();
		
		if(pw.equals(ADMIN_PASSWORD)) {
			Screen screen1 = familyScreen;
			Screen screen2 = animationScreen;
			Screen screen3 = premiumScreen;
			
			System.out.println("-------------------");
			System.out.println("---   관리자 기능    ---");
			System.out.println("-------------------");
			
			System.out.println("가족 영화관 결제 총액 : " + Statistics.sum(screen1.getHashMap()));
			System.out.println("애니메이션 영화관 결제 총액 : " + Statistics.sum(screen2.getHashMap()));
			System.out.println("프리미엄 영화관 결제 총액 : " + Statistics.sum(screen3.getHashMap()));
			System.out.println("영화관 총 티켓 판매량 : " + (screen1.getCount() + screen2.getCount() + screen3.getCount()));
			
			String filename = "c:\\temp\\receipt.txt";
			System.out.println(filename + " 백업 시작합니다.");
			bw.backupFile(filename, screen1.getHashMap());
			System.out.println("가족 영화관 매출 백업 완료");
			bw.backupFile(filename, screen2.getHashMap());
			System.out.println("애니메이션 영화관 매출 백업 완료");
			bw.backupFile(filename, screen3.getHashMap());
			System.out.println("프리미엄 영화관 매출 백업 완료");
			
			System.out.println();
		}
		else {
			System.out.println("잘못된 비밀번호입니다.");
		}
	}
}
