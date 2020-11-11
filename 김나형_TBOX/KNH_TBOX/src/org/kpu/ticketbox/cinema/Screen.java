package org.kpu.ticketbox.cinema;
import org.kpu.ticketbox.payment.MovieTicket;
import org.kpu.ticketbox.payment.Pay;
import org.kpu.ticketbox.payment.Receipt;
import java.util.*;

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
		
		seatArray = new MovieTicket[nRowMax][nColMax];
		for(int i = 0; i < nColMax; i++) {
			for(int j = 0; j < nRowMax; j++) {
				seatArray[i][j] = new MovieTicket();
				seatArray[i][j].setcStatus(MovieTicket.SEAT_EMPTY_MARK);
			}
		} //배열 초기화
	}
	
	public void showScreenMenu() {// 상영관 메뉴 보여주기
		System.out.println("-------------------");
		System.out.printf("영화 메뉴 - %s\n", strMovieName);
		System.out.println("-------------------");
		System.out.println(" 1. 상영 영화 정보");
		System.out.println(" 2. 좌석 예약 현황");
		System.out.println(" 3. 좌석 예약 하기");
		System.out.println(" 4. 좌석 변경 하기");
		System.out.println(" 5. 좌석 결제 하기");
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
				System.out.print("["+ seatArray[i][j].getcStatus() +"] ");
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
		row--;
		System.out.printf("좌석 열 번호 입력(1 - %d) : ", nColMax);
		int col = scan.nextInt();
		col--;
		
		if(seatArray[row][col].getcStatus() == seatArray[row][col].SEAT_RESERVED_MARK) {
			System.out.println("이미 선택된 좌석입니다.");
		}
		else {
			seatArray[row][col].setSeat(row, col);
			seatArray[row][col].setnReservedId(nCurrentReservedId);
			
			System.out.printf("행[%d] 열[%d] %d 예약번호로 접수되었습니다.\n", 
					row + 1, col + 1, seatArray[row][col].getnReservedId());
			nCurrentReservedId++;
		}	
	}
	
	private MovieTicket checkReservedId(int id) {// 예약 번호로 티켓 체크하기		
		for(int i = 0; i < nColMax; i++) {
			for(int j = 0; j < nRowMax; j++) {
				if(seatArray[i][j].getnReservedId() == id) {
					seatArray[i][j].setcStatus(MovieTicket.SEAT_EMPTY_MARK);
					return seatArray[i][j];
				}
			}
		}
		return null;
	}
	
	public void changeTicket () {// 좌석 변경
		System.out.println(" [  좌석 변경  ]");
		System.out.print("좌석 예약 번호 입력 : ");
		int rnum = scan.nextInt();
		
		if(checkReservedId(rnum) != null) {
			System.out.printf("좌석 행 번호 입력(1 - %d) : ", nRowMax);
			int row = scan.nextInt();
			row--;
			System.out.printf("좌석 열 번호 입력(1 - %d) : ", nColMax);
			int col = scan.nextInt();
			col--;
			
			seatArray[row][col].setSeat(row, col);
			
			System.out.printf("예약번호 %d 행[%d] 열[%d] 좌석으로 변경되었습니다.\n", 
					rnum, row + 1, col + 1);
		}		
	}
	
	private HashMap <Integer, Receipt> receiptMap = new HashMap <Integer, Receipt>();
	
	public void payment() { // 결제 하기
		System.out.println(" [  좌석 예약 결제  ]");
		System.out.print("예약 번호 입력 : ");
		int rnum = scan.nextInt();
		
		for(int i = 0; i < nColMax; i++) {
			for(int j = 0; j < nRowMax; j++) {
				if(seatArray[i][j].getnReservedId() == rnum) {
					System.out.println();
					System.out.println("-------------------");
					System.out.println("	결제 방식 선택");
					System.out.println("-------------------");
					System.out.printf(" %d. 은행 이체\n", Pay.BANK_TRANSFER_PAYMENT);
					System.out.printf(" %d. 카드 결제\n", Pay.CREDIT_CARD_PAYMENT);
					System.out.printf(" %d. 모바일 결제\n", Pay.MOBILE_PHONE_PAYMENT);
					System.out.print("결제 방식 입력(1~3) : ");
					int pay = scan.nextInt();
					
					switch(pay) {
					case Pay.BANK_TRANSFER_PAYMENT:
						
						break;
					case Pay.CREDIT_CARD_PAYMENT:
						
						break;
					case Pay.MOBILE_PHONE_PAYMENT:
						
						break;
					}
				}
			}
		}	
		
		
		receiptMap.put(rnum, );// 키 예약 번호 ))+ Receipt 객체
	}
	
	//티켓 영수증 출력
	public void printTicket () {
		
	}
}
