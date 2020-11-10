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
				if(seatArray[j][i])
				System.out.print("["+ seatArray.SEAT_EMPTY_MARK +"] ");
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
		System.out.printf("�¼� �� ��ȣ �Է�(1 - %d) : ", nColMax);
		int col = scan.nextInt();
		
		seatArray.setSeat(row, col);
		System.out.printf("��[%d] ��[%d] %d ���� ��ȣ�� �����Ǿ����ϴ�.\n", row, col, nCurrentReservedId);
		seatArray.setnReservedId(nCurrentReservedId);
		nCurrentReservedId++;
	}
}
