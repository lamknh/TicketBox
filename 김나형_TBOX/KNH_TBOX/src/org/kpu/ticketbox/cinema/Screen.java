package org.kpu.ticketbox.cinema;
import org.kpu.ticketbox.payment.MovieTicket;
import java.util.Scanner;

public abstract class Screen {
	protected int nTicketPrice;// Ƽ�� ����
	protected int nRowMax;// �¼� �� �ִ� ��
	protected int nColMax;// �¼� �� �ִ� ��
	protected String strMovieName;// ������ ��ȭ ����
	protected String strMovieStory;// ������ ��ȭ �ٰŸ�
	protected MovieTicket [][] seatArray; // �¼� 2 ���� �迭
	public abstract void showMovieInfo(); //��ȭ ���� �����ֱ�
	
	Scanner scan = new Scanner(System.in);
	
	Screen(String name, String story, int price, int row, int col) { // ������
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
		} //�迭 �ʱ�ȭ
	}
	
	public void showScreenMenu() {// �󿵰� �޴� �����ֱ�
		System.out.println("-------------------");
		System.out.printf("��ȭ �޴� - %s\n", strMovieName);
		System.out.println("-------------------");
		System.out.println(" 1. �� ��ȭ ����");
		System.out.println(" 2. �¼� ���� ��Ȳ");
		System.out.println(" 3. �¼� ���� �ϱ�");
		System.out.println(" 7. ���� �޴� �̵�");
	}
	
	public void showSeatMap () {// �󿵰� �¼� ���� ��Ȳ �����ֱ�	
		
		System.out.println("	[�¼� ���� ��Ȳ]");
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
	
	//���� ��ȣ 100 ������ ����
	private int nCurrentReservedId = 100;
	
	public void reserveTicket() { // �¼� ����

		
		System.out.println(" [  �¼� ����  ]");
		System.out.printf("�¼� �� ��ȣ �Է�(1 - %d) : ", nRowMax);
		int row = scan.nextInt();
		row--;
		System.out.printf("�¼� �� ��ȣ �Է�(1 - %d) : ", nColMax);
		int col = scan.nextInt();
		col--;
		
		if(seatArray[row][col].getcStatus() == seatArray[row][col].SEAT_RESERVED_MARK) {
			System.out.println("�̹� ���õ� �¼��Դϴ�.");
		}
		else {
			seatArray[row][col].setSeat(row, col);
			seatArray[row][col].setnReservedId(nCurrentReservedId);
			
			System.out.printf("��[%d] ��[%d] ", row + 1, col + 1);
			seatArray[row][col].getnReservedId();
			System.out.println(" �����ȣ�� �����Ǿ����ϴ�.");
			nCurrentReservedId++;
		}	
	}
}
