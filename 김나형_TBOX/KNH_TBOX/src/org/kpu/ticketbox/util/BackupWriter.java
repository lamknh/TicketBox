package org.kpu.ticketbox.util;
import java.io.*;
import java.util.*;

import org.kpu.ticketbox.payment.Receipt;

public class BackupWriter {
	//c:\\temp\\receipt.txt 파일에 전체 스크린 매출 영수증 출력하기
	public void backupFile (String filename, HashMap <Integer, Receipt> map ) { //Integer : 예약 번호
		FileWriter fout = null;
		
		Set<Integer> keys = map.keySet();
		Iterator<Integer> it = keys.iterator();
			
			try {
				fout = new FileWriter(filename, true);
				
				while(it.hasNext()) {
					int reservedId = it.next();
					Receipt receipt = map.get(reservedId);
					String line = receipt.toBackupString();
					if(line.length() == 0) {
						break;
					}
					fout.write(line, 0, line.length());
					fout.write("\r\n", 0, 2);
				}
				fout.close();
			} catch(IOException e) {
				System.out.println("입출력 오류");
			}
		}
		
} 
