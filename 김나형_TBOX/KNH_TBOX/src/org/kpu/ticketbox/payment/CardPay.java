package org.kpu.ticketbox.payment;

public class CardPay implements Pay{
	public static final double CARD_COMMISION = 0.15;
	
	//�����ϱ� ( ��ȭ��ǰ�� , ��ȭ���� , ���� , ���� ����)
	public Receipt charge(String product, double amount, String name, String number) {
		String client = name;
		String productName = product;
		String payMethod = "CardPay";
		String payNumber = number;
		double subTotalAmount = amount;
		double totalAmount = amount * (1 + CARD_COMMISION);
		
		Receipt receipt = new Receipt(client, productName, payMethod,
				payNumber, subTotalAmount, totalAmount);
		
		return receipt;
	}
}
