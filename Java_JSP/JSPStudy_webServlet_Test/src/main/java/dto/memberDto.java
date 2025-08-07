package dto;

public class memberDto {
	private String mnum, mid, mname, mage, mdate;

	public memberDto() {
	}

	public memberDto(String mnum, String mid, String mname, String mage, String mdate) {
		this.mnum = mnum;
		this.mid = mid;
		this.mname = mname;
		this.mage = mage;
		this.mdate = mdate;
	}

	public String getMnum() {
		return mnum;
	}

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMage() {
		return mage;
	}

	public void setMage(String mage) {
		this.mage = mage;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	
}
