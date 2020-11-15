package org.kpu.ticketbox.payment;

public class Receipt {
	String client;	// ����� �̸�
	String productName;	// ��ȭ ��ǰ �̸�
	String payMethod;	// ���� ����
	String payNumber;	// ���� ���� ��ȣ
	double subTotalAmount;	// Ŀ�̼� ������ �ݾ�
	double totalAmount;	// Ŀ�̼� ������ �ݾ�
	
	public Receipt(String client, String productName, String payMethod, 
			String payNumber, double subTotalAmount, double totalAmount) {
		this.client = client;
		this.productName = productName;
		this.payMethod = payMethod;
		this.payNumber = payNumber;
		this.subTotalAmount = subTotalAmount;
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {  // Ƽ�� ���� ���� ���
		return "[ Client :\t" + client + " ]\n[ Product :\t" + productName +
				" ]\n[ PayMethod :\t" + payMethod + " ]\n[ PayNumber :\t"
				+ payNumber + " ]\n[ SubTotal :\t" + subTotalAmount + 
				" ]\n[ Total :\t" + totalAmount + " ]\n";
	}
	
	//������(,)�� ����Ͽ� �� �ٿ� ���
	public String toBackupString() {
		String tbox = client + "," + productName + "," + payMethod + "," + payNumber +
				"," + subTotalAmount + "," + totalAmount;
		return tbox;
	}

	public double getTotalAmount() {
		return totalAmount;
	}
}
