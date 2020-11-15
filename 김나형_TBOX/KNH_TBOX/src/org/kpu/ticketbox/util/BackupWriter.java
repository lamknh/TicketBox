package org.kpu.ticketbox.util;
import java.io.*;
import java.util.*;

import org.kpu.ticketbox.payment.Receipt;

public class BackupWriter {
	//c:\\temp\\receipt.txt ���Ͽ� ��ü ��ũ�� ���� ������ ����ϱ�
	public void backupFile (String filename, HashMap <Integer, Receipt> map ) { //Integer : ���� ��ȣ
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
				System.out.println("����� ����");
			}
		}
		
} 
