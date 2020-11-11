package org.kpu.ticketbox.payment;

public class Receipt {
	String client;	// 사용자 이름
	String productName;	// 영화 상품 이름
	String payMethod;	// 결제 수단
	String payNumber;	// 결제 정보 번호
	double subTotalAmount;	// 커미션 제외한 금액
	double totalAmount;	// 커미션 포함한 금액

}
