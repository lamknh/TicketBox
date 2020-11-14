package org.kpu.ticketbox.payment;

public class BankTransfer implements Pay{
	public static final double BANK_TRANSFER_COMMISION = 0.1;
	
	//결재하기 ( 영화상품명 , 영화가격 , 고객명 , 결제 정보)
	public Receipt charge(String product, double amount, String name, String number) {
		String client = name;
		String productName = product;
		String payMethod = "BankTransfer";
		String payNumber = number;
		double subTotalAmount = amount;
		double totalAmount = amount * (1 + BANK_TRANSFER_COMMISION);
		
		Receipt receipt = new Receipt(client, productName, payMethod,
				payNumber, subTotalAmount, totalAmount);
		
		return receipt;
	}
}
