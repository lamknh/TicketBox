package org.kpu.ticketbox.payment;

public class Receipt {
	String client;	// 사용자 이름
	String productName;	// 영화 상품 이름
	String payMethod;	// 결제 수단
	String payNumber;	// 결제 정보 번호
	double subTotalAmount;	// 커미션 제외한 금액
	double totalAmount;	// 커미션 포함한 금액
	
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
	public String toString() {  // 티켓 결제 내용 출력
		return "[ Client :\t" + client + " ]\n[ Product :\t" + productName +
				" ]\n[ PayMethod :\t" + payMethod + " ]\n[ PayNumber :\t"
				+ payNumber + " ]\n[ SubTotal :\t" + subTotalAmount + 
				" ]\n[ Total :\t" + totalAmount + " ]\n";
	}
}
