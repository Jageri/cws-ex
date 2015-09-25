package pra.backstage.listener;

import java.util.List;

import pra.backstage.checkwork.*;
import pra.backstage.macbook.*;

public class Listen {

	CheckWork check;

	public static void main(String[] args) {
		CheckWork check;
		check = new CheckWork();
		String[] fordate =check.GetDate();// 课时
		MacBook book = check.CheckDb();// 取得理论MAC地址

		List<String> mac = check.CheckNet();// 取得实际MAC地址

		for (int i = 0; i < mac.size(); i++) {
			book.Search1(mac.get(i));//做第一次对比
		}

		while (true) {
			if (check.GetDate().equals(fordate)) {

				mac = check.CheckNet();
				for (int i = 0; i < mac.size(); i++) {
					book.Search2(mac.get(i));//持续监测
				}
			}else {
				
				//更新数据库				
				UpdateBook updateBook=new UpdateBook();
				updateBook.Update(book);		
				
				fordate = check.GetDate();
				book = check.CheckDb();// 取得理论MAC地址
				mac = check.CheckNet();// 取得实际MAC地址
				for (int i = 0; i < mac.size(); i++) {
					book.Search1(mac.get(i));//做第一次对比
				}

				
			}
		}
	}
	
	
	
}
