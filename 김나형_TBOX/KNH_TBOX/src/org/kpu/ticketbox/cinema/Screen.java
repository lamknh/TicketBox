package org.kpu.ticketbox.cinema;
import org.kpu.ticketbox.payment.MovieTicket;
import java.util.Scanner;

public abstract class Screen {
	protected int nTicketPrice;// 티켓 가격
	protected int nRowMax;// 좌석 행 최대 값
	protected int nColMax;// 좌석 열 최대 값
	protected String strMovieName;// 상영중인 영화 제목
	protected String strMovieStory;// 상영중인 영화 줄거리
	protected MovieTicket [][] seatArray; // 좌석 2 차원 배열
	public abstract void showMovieInfo(); //영화 정보 보여주기
	
	Scanner scan = new Scanner(System.in);
	
	Screen(String name, String story, int price, int row, int col) { // 생성자
		strMovieName = name;
		strMovieStory = story;
		nTicketPrice = price;
		nRowMax = row;
		nColMax = col;
	}
	
	public void showScreenMenu() {// 상영관 메뉴 보여주기
		System.out.println("-------------------");
		System.out.printf("영화 메뉴 - %s\n", strMovieName);
		System.out.println("-------------------");
		System.out.println(" 1. 상영 영화 정보");
		System.out.println(" 2. 좌석 예약 현황");
		System.out.println(" 3. 좌석 예약 하기");
		System.out.println(" 7. 메인 메뉴 이동");
	}
	public void showSeatMap () {// 상영관 좌석 예약 현황 보여주기
		System.out.println("	[좌석 예약 현황]");
		System.out.print("	");
		for(int i = 0; i < nRowMax; i++) {
			System.out.printf("[%d] ", (i+1));
		}
		System.out.println();
		
		for(int i = 0; i < nColMax; i++) {
			System.out.printf("[%d]\t", (i+1));
			for(int j = 0; j < nRowMax; j++) {
				if(seatArray[j][i])
				System.out.print("["+ seatArray.SEAT_EMPTY_MARK +"] ");
			}
			System.out.println();
		}
	}
	
	//예약 번호 100 번부터 시작
	private int nCurrentReservedId = 100;
	public void reserveTicket() { // 좌석 예약
		System.out.println(" [  좌석 예약  ]");
		System.out.printf("좌석 행 번호 입력(1 - %d) : ", nRowMax);
		int row = scan.nextInt();
		System.out.printf("좌석 열 번호 입력(1 - %d) : ", nColMax);
		int col = scan.nextInt();
		
		seatArray.setSeat(row, col);
		System.out.printf("행[%d] 열[%d] %d 예약 번호로 접수되었습니다.\n", row, col, nCurrentReservedId);
		seatArray.setnReservedId(nCurrentReservedId);
		nCurrentReservedId++;
	}
}
