package org.kpu.ticketbox.cinema;

public class PremiumScreen extends Screen{
	public PremiumScreen (String name , String story, int price, int row, int col) {
		super(name, story, price, row, col);
	}

	@Override
	public void showMovieInfo() {
		System.out.println("-------------------");
		System.out.printf("%s �Ұ�\n", strMovieName);
		System.out.println("-------------------");
		System.out.println("��ȭ�� : �ִϸ��̼ǿ�ȭ 1��");
		System.out.printf("�ٰŸ� : %s\n", strMovieStory);
		System.out.printf("����: %d��\n", nTicketPrice);
	}
}
