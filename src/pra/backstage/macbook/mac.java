package pra.backstage.macbook;
//�ڵ���

public class mac {
	String mac;
	int isabsence=1;
int no;
	public mac(String mac, int isabsence,int no) {
		this.mac = mac;
		this.isabsence = isabsence;
		// TODO Auto-generated constructor stub
	}
	/* ��л���л��,��������ƺ������췽���й�ϵ���ɶ��ˡ�
	 * jdbcUtils.findMoreRefResult(sql, null, mac.class);
	 */
	public mac() {
	
		// TODO Auto-generated constructor stub
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public int getNo() {
		return no;
	}
	
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public int getIsabsence() {
		return isabsence;
	}
	public void setIsabsence(int isabsence) {
		this.isabsence = isabsence;
	}
	
}