package pra.backstage.listener;

import java.util.List;

import pra.backstage.checkwork.*;
import pra.backstage.macbook.*;

public class Listen {

	CheckWork check;

	public static void main(String[] args) {
		CheckWork check;
		check = new CheckWork();
		String[] fordate =check.GetDate();// ��ʱ
		MacBook book = check.CheckDb();// ȡ������MAC��ַ

		List<String> mac = check.CheckNet();// ȡ��ʵ��MAC��ַ

		for (int i = 0; i < mac.size(); i++) {
			book.Search1(mac.get(i));//����һ�ζԱ�
		}

		while (true) {
			if (check.GetDate().equals(fordate)) {

				mac = check.CheckNet();
				for (int i = 0; i < mac.size(); i++) {
					book.Search2(mac.get(i));//�������
				}
			}else {
				
				//�������ݿ�				
				UpdateBook updateBook=new UpdateBook();
				updateBook.Update(book);		
				
				fordate = check.GetDate();
				book = check.CheckDb();// ȡ������MAC��ַ
				mac = check.CheckNet();// ȡ��ʵ��MAC��ַ
				for (int i = 0; i < mac.size(); i++) {
					book.Search1(mac.get(i));//����һ�ζԱ�
				}

				
			}
		}
	}
	
	
	
}
