package org.kpu.ticketbox.cinema;
import org.kpu.ticketbox.payment.MovieTicket;

public abstract class Screen {
	protected int nTicketPrice;// Ƽ�� ����
	protected int nRowMax;// �¼� �� �ִ� ��
	protected int nColMax;// �¼� �� �ִ� ��
	protected String strMovieName;// ������ ��ȭ ����
	protected String strMovieStory;// ������ ��ȭ �ٰŸ�
	protected MovieTicket [][] seatArray; // �¼� 2 ���� �迭
	public abstract void showMovieInfo(); //��ȭ ���� �����ֱ�
	
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
		System.out.println(" 7. ���� �޴� �̵�");
	}
	public void showSeatMap () {// �󿵰� �¼� ���� ��Ȳ �����ֱ�
		for(int i = 0; i < nColMax; i++) {
			for(int j = 0; j < nRowMax; j++) {
				System.out.printf("[%d]	", (j+1));
			}
		}
	}
}
