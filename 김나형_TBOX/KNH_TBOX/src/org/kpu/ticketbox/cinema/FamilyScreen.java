package org.kpu.ticketbox.cinema;

public class FamilyScreen extends Screen{
	public FamilyScreen (String name , String story, int price, int row, int col) {
		super(name, story, price, row, col);
	}

	@Override
	public void showMovieInfo() {
		System.out.println("-------------------");
		System.out.printf("%s 소개\n", strMovieName);
		System.out.println("-------------------");
		System.out.println("영화관 : 가족 영화 1관");
		System.out.printf("줄거리 : %s\n", strMovieStory);
		System.out.printf("가격: %d원\n", nTicketPrice);
	}
}
