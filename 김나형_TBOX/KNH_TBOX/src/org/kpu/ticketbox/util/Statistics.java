package org.kpu.ticketbox.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.kpu.ticketbox.payment.Receipt;

public class Statistics {
	//스크린 별 결제 금액 총액 계산
	public static double sum(HashMap <Integer, Receipt> map) {
		double sum = 0;
		
		Set<Integer> keys = map.keySet();
		Iterator<Integer> it = keys.iterator();
		
		while(it.hasNext()) {
			int reservedId = it.next();
			sum += map.get(reservedId).getTotalAmount();
		}
		
		return sum;
	}
}
