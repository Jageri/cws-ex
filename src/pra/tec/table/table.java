package pra.tec.table;

public class table {

	public table() {

	}

	public table(long id, String name, String cname, Integer cno, Integer tno,
			Integer ctime, Integer isabsence,long no) {

		this.id = id;
		this.name = name;
		this.cname = cname;
		this.cno = cno;
		this.tno = tno;
		this.ctime = ctime;
		this.isabsence = isabsence;
		this.no = no;
	}

	private long id;
	private String name;
	private String cname;
	private Integer cno;
	private Integer tno;
	private Integer ctime;
	private Integer isabsence;
	private long no;

	public void setNo(long no) {
		this.no = no;
	}

	public long getNo() {
		return no;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getTno() {

		return tno;

	}

	public void setTno(Integer tno) {
		this.tno = tno;
	}

	public Integer getCtime() {

		return ctime;

	}

	public void setCtime(Integer ctime) {
		this.ctime = ctime;
	}

	public long getId() {

		return id;

	}

	public void setId(long id) {

		this.id = id;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCno() {

		return cno;

	}

	public void setCno(Integer cno) {
		this.cno = cno;
	}

	public Integer getIsabsence() {
		return isabsence;
	}

	public void setIsabsence(Integer isabsence) {
		this.isabsence = isabsence;
	}

}