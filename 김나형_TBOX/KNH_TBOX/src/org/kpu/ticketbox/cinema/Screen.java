package org.kpu.ticketbox.cinema;
import org.kpu.ticketbox.payment.MovieTicket;

public abstract class Screen {
	protected int nTicketPrice;// 티켓 가격
	protected int nRowMax;// 좌석 행 최대 값
	protected int nColMax;// 좌석 열 최대 값
	protected String strMovieName;// 상영중인 영화 제목
	protected String strMovieStory;// 상영중인 영화 줄거리
	protected MovieTicket [][] seatArray; // 좌석 2 차원 배열
	public abstract void showMovieInfo(); //영화 정보 보여주기
	
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
		System.out.println(" 7. 메인 메뉴 이동");
	}
	public void showSeatMap () {// 상영관 좌석 예약 현황 보여주기
		for(int i = 0; i < nColMax; i++) {
			for(int j = 0; j < nRowMax; j++) {
				System.out.printf("[%d]	", (j+1));
			}
		}
	}
}
