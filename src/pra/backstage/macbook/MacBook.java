package pra.backstage.macbook;

import java.util.ArrayList;
import java.util.List;


public class MacBook {

	List<mac> list;

	public MacBook() {
		list = new ArrayList<mac>();
	}

	public void add(String mac, int no) {
		mac add = new mac(mac, 1, no);
		list.add(add);
	}

	public void add(mac mac) {

		list.add(mac);
	}

	public mac get(int i) {
		return list.get(i);
	}
	public int size() {
		return list.size();
	}

	public void Search1(String str) {// 初始查找
		for (mac mac : list) {
			if (mac.mac == str && mac.isabsence == 1)
				mac.isabsence = 0;
		}
		for (mac mac : list) {
			if (mac.isabsence == 1)
				mac.isabsence = 2;
		}
	}

	public void Search2(String str) {
		for (mac mac : list) {// 到勤处理
			if (mac.mac == str && mac.isabsence == 1)
				mac.isabsence = 0;
			else if (mac.mac == str && mac.isabsence == 2) {
				mac.isabsence = 3;
			} else if (mac.mac == str && mac.isabsence == 3) {
				mac.isabsence = 1;
			}
		}

		for (mac mac : list) {// 两次连续缺勤=旷课
			if (mac.isabsence == 2)
				mac.isabsence = 4;
		}
	}

}
