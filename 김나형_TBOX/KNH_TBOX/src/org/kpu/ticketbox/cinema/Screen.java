package org.kpu.ticketbox.cinema;
import org.kpu.ticketbox.payment.BankTransfer;
import org.kpu.ticketbox.payment.CardPay;
import org.kpu.ticketbox.payment.MobilePay;
import org.kpu.ticketbox.payment.MovieTicket;
import org.kpu.ticketbox.payment.Pay;
import org.kpu.ticketbox.payment.Receipt;
import java.util.*;

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
		System.out.println(" 4. �¼� ���� �ϱ�");
		System.out.println(" 5. �¼� ���� �ϱ�");
		System.out.println(" 6. Ƽ�� ��� �ϱ�");
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
			
			System.out.printf("��[%d] ��[%d] %d �����ȣ�� �����Ǿ����ϴ�.\n", 
					row + 1, col + 1, seatArray[row][col].getnReservedId());
			nCurrentReservedId++;
		}	
	}
	
	private MovieTicket checkReservedId(int id) {// ���� ��ȣ�� Ƽ�� üũ�ϱ�		
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
	
	public void changeTicket () {// �¼� ����
		System.out.println(" [  �¼� ����  ]");
		System.out.print("�¼� ���� ��ȣ �Է� : ");
		int rnum = scan.nextInt();
		
		if(checkReservedId(rnum) != null) {
			System.out.printf("�¼� �� ��ȣ �Է�(1 - %d) : ", nRowMax);
			int row = scan.nextInt();
			row--;
			System.out.printf("�¼� �� ��ȣ �Է�(1 - %d) : ", nColMax);
			int col = scan.nextInt();
			col--;
			
			seatArray[row][col].setSeat(row, col);
			
			System.out.printf("�����ȣ %d ��[%d] ��[%d] �¼����� ����Ǿ����ϴ�.\n", 
					rnum, row + 1, col + 1);
		}		
	}
	
	private HashMap <Integer, Receipt> receiptMap = new HashMap <Integer, Receipt>();
	
	public void payment() { // ���� �ϱ�
		BankTransfer bt = new BankTransfer();
		System.out.println(" [  �¼� ���� ����  ]");
		System.out.print("���� ��ȣ �Է� : ");
		int rnum = scan.nextInt();
		
		for(int i = 0; i < nColMax; i++) {
			for(int j = 0; j < nRowMax; j++) {
				if(seatArray[i][j].getnReservedId() == rnum) {
					System.out.println();
					System.out.println("-------------------");
					System.out.println("    ���� ��� ����");
					System.out.println("-------------------");
					System.out.printf(" %d. ���� ��ü\n", Pay.BANK_TRANSFER_PAYMENT);
					System.out.printf(" %d. ī�� ����\n", Pay.CREDIT_CARD_PAYMENT);
					System.out.printf(" %d. ����� ����\n", Pay.MOBILE_PHONE_PAYMENT);
					System.out.print("���� ��� �Է�(1~3) : ");
					int pay = scan.nextInt();
					System.out.println();
					
					switch(pay) {
					case Pay.BANK_TRANSFER_PAYMENT:
						System.out.println(" [ ���� ��ü ]");
						System.out.print("�̸� �Է� : ");
						String name = scan.next();
						System.out.print("���� ��ȣ �Է�(12�ڸ���) : "); //12�ڸ��� ���� �����ϱ�
						String payment = scan.next();
						
						System.out.printf("���� ������ �Ϸ�Ǿ����ϴ�. : %.1f��\n", 
								nTicketPrice * (1 + BankTransfer.BANK_TRANSFER_COMMISION));
						seatArray[i][j].setcStatus(MovieTicket.SEAT_PAY_COMPLETION_MARK);
						
						Receipt receipt = bt.charge(strMovieName, nTicketPrice, name, payment);
						receiptMap.put(rnum, receipt);// Ű (���� ��ȣ)+ Receipt ��ü
						break;
					case Pay.CREDIT_CARD_PAYMENT:
						System.out.println(" [ ī�� ���� ]");
						System.out.print("�̸� �Է� : ");
						name = scan.next();
						System.out.print("ī�� ��ȣ �Է�(12�ڸ���) : ");
						payment = scan.next();
						
						System.out.printf("ī�� ������ �Ϸ�Ǿ����ϴ�. : %.1f��\n",
								(double)nTicketPrice * (1 + CardPay.CARD_COMMISION));
						seatArray[i][j].setcStatus(MovieTicket.SEAT_PAY_COMPLETION_MARK);
						
						receipt = bt.charge(strMovieName, nTicketPrice, name, payment);
						receiptMap.put(rnum, receipt);// Ű (���� ��ȣ)+ Receipt ��ü
						break;
					case Pay.MOBILE_PHONE_PAYMENT:
						System.out.println(" [ ����� ���� ]");
						System.out.print("�̸� �Է� : ");
						name = scan.next();
						System.out.print("�ڵ��� ��ȣ �Է�(12�ڸ���) : ");
						payment = scan.next();
						
						System.out.printf("����� ������ �Ϸ�Ǿ����ϴ�. : %.1f��\n",
								nTicketPrice * (1 + MobilePay.MOBILE_COMMISION));
						seatArray[i][j].setcStatus(MovieTicket.SEAT_PAY_COMPLETION_MARK);
						
						receipt = bt.charge(strMovieName, nTicketPrice, name, payment);
						receiptMap.put(rnum, receipt);// Ű (���� ��ȣ)+ Receipt ��ü
						break;
					}
				}
			}
		}
	}
	
	//Ƽ�� ������ ���
	public void printTicket () {
		System.out.println(" [ �¼� Ƽ�� ��� ]");
		System.out.print("���� ��ȣ �Է� : ");
		int rnum = scan.nextInt();
		
		for(int i = 0; i < nColMax; i++) {
			for(int j = 0; j < nRowMax; j++) {
				if(seatArray[i][j].getnReservedId() == rnum) {
					System.out.println();
					System.out.println("-------------------");
					System.out.println("--     Receipt   --");
					System.out.println("-------------------");
					
					receiptMap.get(rnum);
				}
			}
		}
		
	}
}
