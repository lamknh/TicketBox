package org.kpu.ticketbox.payment;

public class MobilePay implements Pay{
	public static final double MOBILE_COMMISION = 0.2;
	
	//결재하기 ( 영화상품명 , 영화가격 , 고객명 , 결제 정보)
	public Receipt charge(String product, double amount, String name, String number) {
		String client = name;
		String productName = product;
		String payMethod = "MobilePay";
		String payNumber = number;
		double subTotalAmount = amount;
		double totalAmount = amount * (1 + MOBILE_COMMISION);
		
		Receipt receipt = new Receipt(client, productName, payMethod,
				payNumber, subTotalAmount, totalAmount);
		
		return receipt;
	}
}
