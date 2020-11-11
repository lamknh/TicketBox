package org.kpu.ticketbox.payment;

public class MovieTicket {
	public static final char SEAT_EMPTY_MARK = '-';
	public static final char SEAT_RESERVED_MARK = 'R';
	public static final char SEAT_PAY_COMPLETION_MARK = '$';
	
	private int nRow;// �¼� ��
	private int nCol;// �¼� ��
	private char cStatus;// �¼� ���� EMPTY, RESERVED, PAY_COMPLETION
	
	private int nReservedId;// ���� ��ȣ
	
	public int getnRow () {
		return nRow;
	}
	public int getnCol () {
		return nCol;
	}
	public char getcStatus () {
		return cStatus;
	}
	public void setcStatus (char cStatus) {
		this.cStatus = cStatus;
	}
	
	public void setSeat (int row, int col) { // �¼���ȣ����
		row = nRow;
		col = nCol;
		cStatus = SEAT_RESERVED_MARK;
	}
	public void setnReservedId (int id) { // �����ȣ����
		nReservedId = id;
	}
	public int getnReservedId() {// �����ȣ �б� ////////////////////////////
		return nReservedId;
	}
}
